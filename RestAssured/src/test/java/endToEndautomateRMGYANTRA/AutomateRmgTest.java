package endToEndautomateRMGYANTRA;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.crm.GenericUtilities.BaseApiclass;
import com.crm.GenericUtilities.EndPointsLibrary;
import com.crm.GenericUtilities.IConstants;
import com.crm.GenericUtilities.JavaUtility;
import com.crm.GenericUtilities.Pojoclass;
import com.mysql.jdbc.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class AutomateRmgTest extends BaseApiclass {

	@Test
	public void automatePostRmg() throws Throwable
	{
		JavaUtility jlib = new JavaUtility();
		int rand = jlib.getRandomNumber();
		Pojoclass pojo = new Pojoclass("ravi","Nasa"+rand, "created", 5);
		//store data into resp variable
		Response resp = given()
				.body(pojo).contentType(ContentType.JSON)
				.when().post(IConstants.baseURI+EndPointsLibrary.createProject);

		//store projectId
		String projectid = resp.jsonPath().get("projectId");
		System.out.println(projectid);

		//To check Project id in UI using selenium
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get(IConstants.baseURI);
		//maximize the browser
		driver.manage().window().maximize();
		//implicit timeout
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//username
		driver.findElement(By.id("usernmae")).sendKeys(IConstants.appUserName);
		//password
		driver.findElement(By.id("inputPassword")).sendKeys(IConstants.appPassword);
		//submit
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		//click on projects link
		driver.findElement(By.linkText("Projects")).click();
		//To get all projectId
		
		List<WebElement> allprojectId = driver.findElements(By.xpath("//table[@class='table table-striped table-hover']/tbody/tr/td[1]"));
		for (WebElement webElement : allprojectId) {
			
			if (webElement.equals(projectid)) {
				System.out.println("project is Matched in UI");
			}
			else {
				System.out.println("project is not Matched in UI");
			}
		}
		
		driver.quit();
		
		//To check project Id in database
		
		Driver driveref=new Driver();
		DriverManager.registerDriver(driveref);
		Connection con = DriverManager.getConnection(IConstants.dburl,IConstants.dbUsername,IConstants.dbPassword);
		Statement statement = con.createStatement();
		String query="select * from project";
		ResultSet result = statement.executeQuery(query);
		while (result.next()) {
			String allproject = result.getString(1);
			if (allproject.equals(projectid)) {
				System.out.println("project is Matched In databse");
			}
			else {
				System.out.println("project is not Matched In database");
			}
			
		}
		
		//delete project in api
		when()
		.delete(IConstants.baseURI+EndPointsLibrary.deleteProject+projectid)
		.then().assertThat().statusCode(204)
		.log().all();
	}	
}

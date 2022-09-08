package dataProvider;

import static io.restassured.RestAssured.given;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.GenericUtilities.ExcelUtility;
import com.crm.GenericUtilities.JavaUtility;

import io.restassured.http.ContentType;
import pojoclassforSwaggerdocument.PojoclassForPost;

public class ExceldataproviderRestTest  {
	@Test(dataProvider="Postdata")
	public void pojo(String createdBy,String projectName,String status,int teamsize)
	{
		PojoclassForPost pojo = new PojoclassForPost(createdBy, projectName, status, teamsize);
		given()
		.body(pojo).contentType(ContentType.JSON)
		.when()
		.post("http://localhost:8084/addProject")
		.then()
		.assertThat().statusCode(201)
		.contentType(ContentType.JSON)
		.log().all();
	}
	@DataProvider
	public Object[][] Postdata() throws Throwable
	{
		JavaUtility jlb = new JavaUtility();
		int rand = jlb.getRandomNumber();
		ExcelUtility eLib=new ExcelUtility();
		Object[][] obj = new Object[2][4];
		obj[0][0]=eLib.getExceldata("pojo", 1, 0)+rand;
		obj[0][1]=eLib.getExceldata("pojo", 1, 1)+rand;
		obj[0][2]=eLib.getExceldata("pojo", 1, 2);
		obj[0][3]=eLib.getExceldata("pojo", 1, 3);

		obj[1][0]=eLib.getExceldata("pojo", 2, 0)+rand;
		obj[1][1]=eLib.getExceldata("pojo", 2, 1)+rand;
		obj[1][2]=eLib.getExceldata("pojo", 2, 2);
		obj[1][3]=eLib.getExceldata("pojo", 2, 3);

		return obj;
	}
}

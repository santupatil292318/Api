package validation;

import static io.restassured.RestAssured.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;


public class StaticvalidationTest {
	@Test
	public void staticResponce()
	{
		
		String expdata="TY_PROJ_1003";
		Response resp = when().get("http://localhost:8084/projects");
		//validation
		String actualdata = resp.jsonPath().get("[1].projectId");
		Assert.assertEquals(actualdata, expdata);
		//Assert.assertEquals(actualdata, expdata);
		System.out.println("data verified");
		resp.then().log().all();
		
	}
}

package validation;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
public class DynamicResponce {


	@Test
	public void dynamicResponse()
	{
		//pre requistes
		String expData = "TY_PROJ_1202";

		//Action
		Response resp = when().get("http://localhost:8084/projects");

		//Validation
		boolean flag = false;
		List<String> pIDs = resp.jsonPath().get("projectId");
		for(String projectID : pIDs)
		{
			if(projectID.equalsIgnoreCase(expData))
			{
				flag = true;
			}
		}

		Assert.assertTrue(flag);
		System.out.println("data verfied");
		//print on console
		resp.then().log().all();
	}
}

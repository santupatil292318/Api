package crudOperationWithoutBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class GetsingleProject {
	@Test
	public void getsingleProject()
	{
		//actions
		Response resp = RestAssured.get("http://localhost:8084/projects/TY_PROJ_1202");
		ValidatableResponse validate = resp.then();
		validate.assertThat().statusCode(200);
		validate.log().all();		
	}
}

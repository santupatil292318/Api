package crudOperationWithoutBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class GetProjectsTest {
	@Test
	public void getallProjects()

	{

		//actions
		Response resp = RestAssured.get("http://localhost:8084/projects");
		ValidatableResponse validate = resp.then();
		validate.assertThat().statusCode(200);
		validate.log().all();	
	}
}

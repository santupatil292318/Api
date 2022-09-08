package crudOperationWithoutBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class DeleteProjectTest {
	@Test
	public void deleteProject()
	{

		//actions
		Response resp = RestAssured.delete("http://localhost:8084/projects/TY_PROJ_836");
		ValidatableResponse validate = resp.then();
		validate.assertThat().statusCode(204);
		validate.log().all();

	}

}

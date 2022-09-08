package requestChaining;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class GetandDelete {

	@Test
	public void getanddelete()
	{
		//get projects
		Response allProjects = when().get("http://localhost:8084/projects");
		allProjects.then().assertThat().statusCode(200).log().all();
		
		String projId = allProjects.jsonPath().get("[0].projectId");
		System.out.println(projId);
		
		//delete project
		given().pathParam("pid", projId)
		.when().delete("http://localhost:8084/projects/{pid}")
		.then().assertThat().statusCode(204).log().all();
		
	}
}

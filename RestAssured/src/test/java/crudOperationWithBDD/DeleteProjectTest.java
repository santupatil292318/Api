package crudOperationWithBDD;

import static io.restassured.RestAssured.when;

import org.testng.annotations.Test;

public class DeleteProjectTest {
	@Test
	public void deleteProject()				
	{
		when()
		.delete("http://localhost:8084/projects/TY_PROJ_1402")
		.then()
		.assertThat().statusCode(204)
		.log().all();
	}
}

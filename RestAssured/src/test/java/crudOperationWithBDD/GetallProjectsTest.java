package crudOperationWithBDD;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class GetallProjectsTest {
	@Test
	public void getallProjects()
	{
		when()
		.get("http://localhost:8084/projects")
		.then()
		.assertThat()
		.statusCode(200)
		.log().all();
	}
}

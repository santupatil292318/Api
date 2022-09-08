package crudOperationWithBDD;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
public class GetProjectsTest {
	@Test
	public void getProject()
	{
		when()
		.get("http://localhost:8084/projects/TY_PROJ_1402")
		.then()
		.assertThat()
		.statusCode(200)
		.log().all();
	}
}

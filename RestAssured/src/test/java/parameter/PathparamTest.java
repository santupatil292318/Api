package parameter;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class PathparamTest {

	@Test
	public void pathparam()
	{
		given()
		.pathParam("projectId", "TY_PROJ_1003")
		.when().get("http://localhost:8084/projects/{projectId}")
		.then().assertThat().statusCode(200).log().all();
	}
}

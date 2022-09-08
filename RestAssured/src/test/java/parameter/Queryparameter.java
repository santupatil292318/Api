package parameter;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class Queryparameter {

	@Test
	public void queryparameter()
	{
		given()
		.queryParam("page", 2)
		.when()
		.get("https://reqres.in/api/users?page=2")
		.then().assertThat().statusCode(200)
		.log().all();
	}
}

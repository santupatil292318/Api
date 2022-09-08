package reqresApi;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class GetsingleUserNotFound {

	@Test
	public void getsingleuserNotFound()
	{
		when().get("https://reqres.in/api/users/23")
		.then()
		.assertThat().statusCode(404)
		.log().all();
		
	}
}

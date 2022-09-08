package reqresApi;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class GetlistResourcesTest {

	@Test
	public void getlistresources()
	{
		when().get("https://reqres.in/api/unknown")
		.then().assertThat().statusCode(200)
		.assertThat().contentType(ContentType.JSON)
		.log().all();
	}
}

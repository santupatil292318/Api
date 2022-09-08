package assighnmentsSwaggerPetStore;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class GetstoreTest {

	@Test
	public void getstore()
	{
		when()
		.get("https://petstore.swagger.io/v2/store/order/{2}")
		.then()
		.assertThat().statusCode(200)
		.log().all();
	}
}

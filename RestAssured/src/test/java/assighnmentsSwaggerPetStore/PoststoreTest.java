package assighnmentsSwaggerPetStore;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class PoststoreTest {

	@SuppressWarnings("unchecked")
	@Test
	public void poststore()
	{
		JSONObject object = new JSONObject();
		object.put("id", 2);
		object.put("petId", 4);
		object.put("quantity", 6);
		object.put("shipDate", "2022-09-06T10:54:06.333Z");
		object.put("status", "placed");
		object.put("complete", true);
		given()
		.body(object).contentType(ContentType.JSON)
		.when()
		.post("https://petstore.swagger.io/v2/store/order")
		.then().assertThat().contentType(ContentType.JSON)
		.statusCode(200).log().all();
	}
}

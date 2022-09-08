package reqresApi;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PostWithBdd {

	@Test
	public void postReqres()
	{
		JSONObject jo = new JSONObject();
		jo.put("name", "morpheus");
		jo.put("job", "leader");
		
		given()
		.body(jo)
		.contentType(ContentType.JSON)
		.post("https://reqres.in/api/users")
		.then()
		.assertThat().statusCode(201)
		.assertThat().contentType(ContentType.JSON)
		.log().all();
	}
	
}

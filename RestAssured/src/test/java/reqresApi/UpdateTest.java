package reqresApi;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import  io.restassured.http.ContentType;

public class UpdateTest {

		@Test
		public void updateReqres()
		{
			JSONObject jo = new JSONObject();
			jo.put("name", "morpheus");
			jo.put("job", "zion resident");
			
			given()
			.body(jo)
			.contentType(ContentType.JSON)
			.put("https://reqres.in/api/users/2")
			.then()
			.assertThat().statusCode(200)
			.assertThat().contentType(ContentType.JSON)
			.log().all();
		}
}

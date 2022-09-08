package swaggerDifferentWayToPost;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class JsonObjectTest {
	@SuppressWarnings("unchecked")
	@Test
	public void jsonObject()
	{
		JSONObject jsobj = new JSONObject();
		jsobj.put("createdBy", "Anil123");
		jsobj.put("projectName", "ICI");
		jsobj.put("status", "created");
		jsobj.put("teamsize", 10);
		//actions
		given()
		.contentType(ContentType.JSON)
		.body(jsobj)
		.when()
		.post("http://localhost:8084/addProject")
		.then()
		.assertThat()
		.statusCode(201)
		.assertThat().contentType(ContentType.JSON)
		.log().all();
	}
}

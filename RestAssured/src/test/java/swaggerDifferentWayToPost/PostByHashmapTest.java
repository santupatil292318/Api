package swaggerDifferentWayToPost;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class PostByHashmapTest {
	@SuppressWarnings("unchecked")
	@Test
	public void hashmapPost()
	{
		@SuppressWarnings("rawtypes")
		HashMap Obj = new HashMap()	;
		Obj.put("createdBy", "avi");
		Obj.put("projectName", "alex");
		Obj.put("status", "created");
		Obj.put("teamSize", 2);

		//actions
		given()
		.body(Obj).contentType(ContentType.JSON)
		.when()
		.post("http://localhost:8084/addProject")
		.then()
		.assertThat()
		.contentType(ContentType.JSON)
		.statusCode(201)
		.log().all();
	}
}

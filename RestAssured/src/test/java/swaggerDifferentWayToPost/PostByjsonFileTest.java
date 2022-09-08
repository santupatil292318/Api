package swaggerDifferentWayToPost;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class PostByjsonFileTest {

	@Test
	public void postByjsonFile()
	{
		File file = new File("./src/test/resources/postjson.json.txt");
		//actions
		given()
		.body(file)
		.contentType(ContentType.JSON)
		.when()
		.post("http://localhost:8084/addProject")
		.then()
		.assertThat().statusCode(201)
		.contentType(ContentType.JSON)
		.log().all();
	}
}

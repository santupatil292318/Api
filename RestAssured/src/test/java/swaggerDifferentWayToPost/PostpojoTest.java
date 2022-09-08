package swaggerDifferentWayToPost;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import pojoclassforSwaggerdocument.PojoclassForPost;

public class PostpojoTest {
@Test
	public void post()
	{
		PojoclassForPost pojo = new PojoclassForPost("patilsantu", "rmgqsp", "created", 3);
		given()
		.body(pojo).contentType(ContentType.JSON)
		.when()
		.post("http://localhost:8084/addProject")
		.then()
		.assertThat().statusCode(201).contentType(ContentType.JSON)
		.log().all();
	}

}

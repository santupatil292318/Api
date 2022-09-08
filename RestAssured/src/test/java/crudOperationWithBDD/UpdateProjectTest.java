package crudOperationWithBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class UpdateProjectTest {
	@SuppressWarnings("unchecked")
	@Test
	public void updateProject()
	{
		//To create body
		JSONObject jsobj = new JSONObject();
		jsobj.put("createdBy", "Anil");
		jsobj.put("projectName", "ICICI");
		jsobj.put("status", "created");
		jsobj.put("teamsize", 5);

		//actions
		given()
		.contentType(ContentType.JSON)
		.body(jsobj)
		.when()
		.put("http://localhost:8084/projects/TY_PROJ_1402")
		.then()
		.assertThat().contentType(ContentType.JSON)
		.statusCode(200)
		.log().all();
	}
}

package crudOperationWithBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class AddProjectTest {
	@SuppressWarnings("unchecked")
	@Test
	public void addProject()
	{
		//To create body
		JSONObject jsobj = new JSONObject();
		jsobj.put("createdBy", "Anil");
		jsobj.put("projectName", "ICICI");
		jsobj.put("status", "created");
		jsobj.put("teamsize", 10);

		//actions
		given()
		.contentType(ContentType.JSON)
		.body(jsobj)
		.when()
		.post("http://localhost:8084/addProject")
		.then()
		.log().all()
		.assertThat()
		.statusCode(201)
		.assertThat().contentType(ContentType.JSON);
	}
}

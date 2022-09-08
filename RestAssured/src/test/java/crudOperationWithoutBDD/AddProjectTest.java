package crudOperationWithoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class AddProjectTest {
	@SuppressWarnings("unchecked")
	@Test
	public void create()
	{
		//created json body
		JSONObject jobj = new JSONObject();	
		jobj.put("createdBy", "santupatil123");
		jobj.put("projectName", "vtiger123");
		jobj.put("status", "created");
		jobj.put("teamsize", 5);
		//request
		RequestSpecification reqspe = RestAssured.given();
		reqspe.body(jobj);
		reqspe.contentType(ContentType.JSON);
		//actions
		Response resp = reqspe.post("http://localhost:8084/addProject");
		ValidatableResponse validate = resp.then();
		validate.assertThat().contentType(ContentType.JSON);
		validate.assertThat().statusCode(201);
		validate.log().all();

	}
}

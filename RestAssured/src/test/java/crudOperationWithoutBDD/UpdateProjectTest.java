package crudOperationWithoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class UpdateProjectTest {
	@SuppressWarnings("unchecked")
	@Test
	public void updateProject()
	{
		//created json body
		JSONObject jobj = new JSONObject();	
		jobj.put("createdBy", "santupatil1234");
		jobj.put("projectName", "vtiger1234");
		jobj.put("status", "created");
		jobj.put("teamsize", 5);
		//request
		RequestSpecification reqspe = RestAssured.given();
		reqspe.body(jobj);
		reqspe.contentType(ContentType.JSON);
		//actions
		Response resp = reqspe.put("http://localhost:8084/projects/TY_PROJ_1202");
		ValidatableResponse validate = resp.then();
		validate.assertThat().contentType(ContentType.JSON);
		validate.assertThat().statusCode(200);
		validate.log().all();	
	}
}

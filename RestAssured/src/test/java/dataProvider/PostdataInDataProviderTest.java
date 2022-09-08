package dataProvider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import pojoclassforSwaggerdocument.PojoclassForPost;

public class PostdataInDataProviderTest {
	@Test(dataProvider="Postdata")
	public void postdatapojo(String createdBy,String projectName,String status,int teamsize)
	{
		PojoclassForPost pojo = new PojoclassForPost(createdBy, projectName, status, teamsize);
		given()
		.body(pojo).contentType(ContentType.JSON)
		.when()
		.post("http://localhost:8084/addProject")
		.then()
		.assertThat().statusCode(201)
		.contentType(ContentType.JSON)
		.log().all();
	}
	@DataProvider
	public Object[][] Postdata()
	{
		Object[][] obj = new Object[2][4];
		obj[0][0]="patilsan123";
		obj[0][1]="alexgo";
		obj[0][2]="created";
		obj[0][3]=2;

		obj[1][0]="patilsan1234";
		obj[1][1]="alexgoo";
		obj[1][2]="created";
		obj[1][3]=3;

		return obj;
	}
}

package requestChaining;

import org.testng.annotations.Test;

import com.crm.GenericUtilities.JavaUtility;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import pojoclassforSwaggerdocument.PojoclassForPost;

public class PostAndDeletTest {

	@Test
	public void postanddelete()
	{
		//post
		JavaUtility jlb = new JavaUtility();
		int random = jlb.getRandomNumber();
		PojoclassForPost obj = new PojoclassForPost("london", "moov"+random, "created", 5);
		Response resp = given().body(obj).contentType(ContentType.JSON).post("http://localhost:8084/addProject");
		String projectid=resp.jsonPath().get("projectId");
		System.out.println(projectid);
		resp.then().assertThat().contentType(ContentType.JSON)
		.assertThat().statusCode(201)
		.log().all();
		
		//delete
		given().pathParam("pid", projectid)
		.when()
		.delete("http://localhost:8084/projects/{pid}")
		.then()
		.assertThat().statusCode(204)
		.log().all();
	}
}

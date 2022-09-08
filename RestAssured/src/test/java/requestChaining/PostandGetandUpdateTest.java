package requestChaining;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import com.crm.GenericUtilities.JavaUtility;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojoclassforSwaggerdocument.PojoclassForPost;

public class PostandGetandUpdateTest {

	@Test
	public void postandupdate()
	{
		JavaUtility jlib = new JavaUtility();
		int randomnu = jlib.getRandomNumber();

		//post
		PojoclassForPost obj = new PojoclassForPost("london", "moov"+randomnu, "created", 5);
		Response responce = given().contentType(ContentType.JSON)
				.body(obj).when()
				.post("http://localhost:8084/addProject");
		String projId = responce.jsonPath().get("projectId");
		System.out.println(projId);
		responce.then().assertThat().statusCode(201)
		.log().all();

		//get
		given().pathParam("pid", projId)
		.when()
		.get("http://localhost:8084/projects/{pid}")
		.then().assertThat().statusCode(200)
		.log().all();

		//update
		PojoclassForPost obj1 = new PojoclassForPost("londonSAN", "moov"+randomnu, "created", 5);
		Response responce1 = given().contentType(ContentType.JSON)
				.body(obj1).contentType(ContentType.JSON)
				.pathParam("projectId", projId)
				.when()
				.put("http://localhost:8084/projects/{projectId}");
		responce1.then().assertThat().statusCode(200)
		.log().all();

		//delete
		given().pathParam("pids", projId)
		.when()
		.delete("http://localhost:8084/projects/{pids}")
		.then().assertThat().statusCode(204)
		.log().all();
		
		
	}
}

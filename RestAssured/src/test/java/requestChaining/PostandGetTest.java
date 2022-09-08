package requestChaining;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import com.crm.GenericUtilities.JavaUtility;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojoclassforSwaggerdocument.PojoclassForPost;

public class PostandGetTest {

	@Test
	public void postandgetdata()
	{
		JavaUtility jlib = new JavaUtility();
		int randomnu = jlib.getRandomNumber();
//		Random random = new Random();
//		int randomnu = random.nextInt(1000);
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
		given()
		.pathParam("pid", projId)
		.when()
		.get("http://localhost:8084/projects/{pid}")
		.then()
		.assertThat().statusCode(200)
		.log().all();
	}
}

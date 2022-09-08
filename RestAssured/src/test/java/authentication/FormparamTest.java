package authentication;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class FormparamTest {
	@Test
	public void authentication()
	{
		Response responce = given()
				.formParam("client_id","Jenki")
				.formParam("client_secret","7db896a1167e0b60c8d3baac40724eef")
				.formParam("grant_type","client_credentials")
				.formParam("redirect_uri","https://jenki.com")
				.formParam("code","authorization_code")
				.when()
				.post("http://coop.apps.symfonycasts.com/token");

		String token = responce.jsonPath().get("access_token");
		given()
		.auth().oauth2(token)
		.pathParam("user_Id", "3733")
		.when()
		.post("http://coop.apps.symfonycasts.com/api/{user_Id}/eggs-count")
		.then().log().all();
	}
}

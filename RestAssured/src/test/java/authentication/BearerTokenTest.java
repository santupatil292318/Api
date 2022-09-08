package authentication;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class BearerTokenTest {

	@Test
	public void authentication()
	{
		given()
		.auth().oauth2("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")
		.when()
		.get("https://api.github.com/user/repos")
		.then()
		.assertThat().statusCode(200).log().all();
	}
}

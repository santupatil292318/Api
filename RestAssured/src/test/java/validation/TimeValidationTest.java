package validation;

import static io.restassured.RestAssured.when;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class TimeValidationTest {

	@Test
	public void timevalidation()
	
	{
		when().get("http://localhost:8084/projects")
		.then()
		.assertThat().body("[0].projectName",Matchers.equalTo("rmg123"))
		//.assertThat().contentType(Matchers.comparesEqualTo(ContentType.JSON))
		//.assertThat().contentType(Matchers.equalTo(ContentType.JSON))
		//.assertThat().time(Matchers.lessThan(2000L),TimeUnit.MILLISECONDS)
		//.assertThat().contentType(Matchers.equalTo(ContentType.JSON))
		//.assertThat().contentType(Matchers.equalTo(ContentType.JSON))
		.log().all();
	}
}

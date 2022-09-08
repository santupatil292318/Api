package reqresApi;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class DeleteTest {

	@Test
	public void delete()
	{
		when().delete("https://reqres.in/api/users/2")
		.then().assertThat().statusCode(204)
		.log().all();
	}
}

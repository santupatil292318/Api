package crudOpertionFramework;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import com.crm.GenericUtilities.EndPointsLibrary;
import com.crm.GenericUtilities.IConstants;
import com.crm.GenericUtilities.Pojoclass;

import io.restassured.http.ContentType;

public class UpdateTest {

	@Test
	public void update()
	{
		Pojoclass pojo = new Pojoclass("amar","planet","created",4);
		given()
		.body(pojo)
		.contentType(ContentType.JSON)
		.when()
		.put(IConstants.baseURI+EndPointsLibrary.updateProject+"TY_PROJ_1810")
		.then()
		.assertThat().contentType(ContentType.JSON)
		.assertThat().statusCode(200)
		.log().all();
	}
}

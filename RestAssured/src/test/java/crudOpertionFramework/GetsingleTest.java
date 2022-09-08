package crudOpertionFramework;

import org.testng.annotations.Test;

import com.crm.GenericUtilities.EndPointsLibrary;
import com.crm.GenericUtilities.IConstants;

import static io.restassured.RestAssured.*;

public class GetsingleTest {

	@Test
	public void getsingle()
	{
		when()
		.get(IConstants.baseURI+EndPointsLibrary.getSingleProject+"TY_PROJ_808")
		.then()
		.assertThat().statusCode(200).log().all();
	}
}

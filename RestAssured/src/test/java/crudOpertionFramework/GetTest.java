package crudOpertionFramework;

import org.testng.annotations.Test;

import com.crm.GenericUtilities.BaseApiclass;
import com.crm.GenericUtilities.EndPointsLibrary;
import com.crm.GenericUtilities.IConstants;

import static io.restassured.RestAssured.*;

public class GetTest extends BaseApiclass {

	@Test
	public void get()
	{
		when()
		.get(IConstants.baseURI+EndPointsLibrary.getAllProjects)
		.then()
		.assertThat().statusCode(200).log().all();
	}
}

package crudOpertionFramework;

import org.testng.annotations.Test;

import com.crm.GenericUtilities.BaseApiclass;
import com.crm.GenericUtilities.EndPointsLibrary;
import com.crm.GenericUtilities.IConstants;

import static io.restassured.RestAssured.*;

public class DeleteTest extends BaseApiclass {

	@Test
	public void delete()
	{
		when().delete(IConstants.baseURI+EndPointsLibrary.deleteProject+"TY_PROJ_1808")
		.then().assertThat().statusCode(204).log().all();
	}
}

package crudOpertionFramework;

import org.testng.annotations.Test;

import com.crm.GenericUtilities.BaseApiclass;
import com.crm.GenericUtilities.EndPointsLibrary;
import com.crm.GenericUtilities.IConstants;
import com.crm.GenericUtilities.JavaUtility;
import com.crm.GenericUtilities.Pojoclass;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
/**
 * 
 * @author santu
 *
 */
public class PostTest extends BaseApiclass {

	@Test
	public void post()
	{	
		JavaUtility jlib = new JavaUtility();
		int rand = jlib.getRandomNumber();
		Pojoclass pojo = new Pojoclass("amar","planet"+rand,"created",4);
		given()
		.body(pojo)
		.contentType(ContentType.JSON)
		.when()
		.post(IConstants.baseURI+EndPointsLibrary.createProject)
		.then()
		.assertThat().contentType(ContentType.JSON)
		.assertThat().statusCode(201)
		.log().all();
	}
}

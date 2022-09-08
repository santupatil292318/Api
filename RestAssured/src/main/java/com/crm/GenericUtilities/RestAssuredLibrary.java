package com.crm.GenericUtilities;

import  io.restassured.response.Response;

public class RestAssuredLibrary {
 
	public String getjsonData(Response response, String path)
	{
		String  jsondata= response.jsonPath().get(path);
		return jsondata;
	}
	
}

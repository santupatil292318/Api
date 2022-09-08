package com.crm.GenericUtilities;

import java.sql.SQLException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
public class BaseApiclass    {
	
	public DataBaseUtility dLib=new DataBaseUtility();
	public ExcelUtility eLib=new ExcelUtility();
	public FileUtility fLib=new FileUtility();
	public WebdriverUtility  wLib=new WebdriverUtility();
	public JavaUtility jLib=new JavaUtility();
	public RestAssuredLibrary rlib=new RestAssuredLibrary();
	/**
	 * connecting to database
	 */
	@BeforeSuite
	public void dbConfig() throws SQLException
	{
		dLib.connectTodb();
//		Reporter.log("====connection successful====",true);
//		String baseURI = "http://localhost";
//		int port = 8084;
	}
	
	@AfterSuite
	public void closeDBconfig()throws SQLException
	{
		dLib.closeDB();
//		Reporter.log("=====connection closed====",true);
	}
}

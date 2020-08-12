package com.purpleAdmin.qa.testcases;

import java.util.HashMap;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.purpleAdmin.qa.base.TestBase;

import businessLogic.WebBL;

public class WebHomePageTestCase extends  TestBase{
	public static final String DETAIL_PAGE_DATA_SHEET = System.getProperty("user.dir") +"/src/main/java/com/purpleAdmin/qa/testdata/KioskData.xls";
	public static final String SHEET_NAME = "Web";
	ExtentTest extentTest = null;
	public static ExtentTest parent;
	HashMap<String, String> outputMap;

/*	public WebHomePageTestCase(){
		super();
	}
*/
	@BeforeTest
	public void createTest() {
		parent = extent.createTest("Home Page Features Validation Test");		
	}

	@BeforeMethod
	public void setUp() {
		outputMap = new HashMap<String, String>();
	}

	@Test(priority = 1, dataProvider = "getData")
	public void validateCompanyLogo(HashMap<String, String> dataMap){
		initialization(dataMap.get("BROWSER_NAME"));
		extentTest = parent.createNode("Validate Company Logo Loaded on Home Page in "+ dataMap.get("BROWSER_NAME")+ " for " +dataMap.get("CAMPUS_NAME"));
		WebBL wb = new WebBL();
		try {
			outputMap = wb.verifyCompanyLogo(driver, dataMap);
			wb.validateResults(extentTest, outputMap);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@AfterMethod
	public void tearDown() {
        driver.close();	
	}
	

}
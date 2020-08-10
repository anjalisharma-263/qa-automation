package com.purpleAdmin.qa.testcases;

import java.util.HashMap;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.purpleAdmin.qa.base.TestBase;
import com.purpleAdmin.qa.pages.WebEmailPrintPage;

import businessLogic.WebBL;

public class WebEmailPrintTestCases extends TestBase {
	public static final String DETAIL_PAGE_DATA_SHEET = System.getProperty("user.dir") +"/src/main/java/com/purpleAdmin/qa/testdata/KioskData.xls";
	public static final String SHEET_NAME = "Web";
	ExtentTest extentTest = null;
	public static ExtentTest parent;
	HashMap<String, String> outputMap;
	WebEmailPrintPage webEmailPrintPage = new WebEmailPrintPage();
	/*public WebEmailPrintTestCases(){
		super();
	}
*/
	@BeforeTest
	public void createTest() {
		parent = extent.createTest("Email & Print  Validation Test");		
	}

	@BeforeMethod
	public void setUp() {
		outputMap = new HashMap<String, String>();
	}

/*	@Test(dataProvider = "getData")
	public void validateEmailBtn(HashMap<String, String> dataMap){
		initialization(dataMap.get("BROWSER_NAME"));
		extentTest = parent.createNode("Validating Email Functionality on "+ dataMap.get("BROWSER_NAME")+ " for " +dataMap.get("CAMPUS_NAME"));
		WebBL wb = new WebBL();
		outputMap = wb.performEmail(driver, dataMap);
		wb.validateResults(extentTest, outputMap);
	}
*/
	@Test(dataProvider = "getData")
	public void validatePrintBtn(HashMap<String, String> dataMap){
		initialization(dataMap.get("BROWSER_NAME"));
		extentTest = parent.createNode("Validating Print Functionality on "+ dataMap.get("BROWSER_NAME")+ " for " +dataMap.get("CAMPUS_NAME"));
		WebBL wb = new WebBL();
		outputMap = wb.performPrint(driver, dataMap);
		wb.validateResults(extentTest, outputMap);
	}
	

	@AfterMethod
	public void tearDown() {
        driver.close();	
	}
}

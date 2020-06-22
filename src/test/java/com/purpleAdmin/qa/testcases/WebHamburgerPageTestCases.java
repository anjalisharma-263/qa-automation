package com.purpleAdmin.qa.testcases;

import java.util.HashMap;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.purpleAdmin.qa.base.TestBase;

import businessLogic.WebBL;

public class WebHamburgerPageTestCases extends TestBase {
	public static final String DETAIL_PAGE_DATA_SHEET = System.getProperty("user.dir") +"/src/main/java/com/purpleAdmin/qa/testdata/KioskData.xls";
	public static final String SHEET_NAME = "Web";
	ExtentTest extentTest = null;
	public static ExtentTest parent;
	HashMap<String, String> outputMap;

	public WebHamburgerPageTestCases(){
		super();
	}

	@BeforeTest
	public void createTest() {
		parent = extent.createTest("Hamburger Features Validation Test");		
	}

	@BeforeMethod
	public void setUp() {
		outputMap = new HashMap<String, String>();
		initialization();
	}

	@Test(dataProvider = "getData")
	public void validateClearRouteBtn(HashMap<String, String> dataMap){
		extentTest = parent.createNode("Validating Clear Route Button Functionality");
		WebBL wb = new WebBL();
		outputMap = wb.performClearRoute(driver, dataMap);
		wb.validateResults(extentTest, outputMap);
	}

/*
	@Test(dataProvider = "getData")
	public void validateAppOverviewBtn(HashMap<String, String> dataMap){
		extentTest = parent.createNode("Validating App Overview Button Functionality");
		WebBL wb = new WebBL();
		outputMap = wb.performAppOverview(driver, dataMap);
		wb.validateResults(extentTest, outputMap);
	}

	@Test(dataProvider = "getData")
	public void validatePrivacyPolicyBtn(HashMap<String, String> dataMap){
		extentTest = parent.createNode("Validating Privacy Policy Button Functionality");
		WebBL wb = new WebBL();
		outputMap = wb.performPrivacyPolicyBtn(driver, dataMap);
		wb.validateResults(extentTest, outputMap);
	}

	@Test(dataProvider = "getData")
	public void validateEULABtn(HashMap<String, String> dataMap){
		extentTest = parent.createNode("Validating EULA Button Functionality");
		WebBL wb = new WebBL();
		outputMap = wb.performEULA(driver, dataMap);
		wb.validateResults(extentTest, outputMap);
	}*/
}

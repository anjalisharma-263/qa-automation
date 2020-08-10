package com.purpleAdmin.qa.testcases;

import java.util.HashMap;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentTest;
import com.purpleAdmin.qa.base.TestBase;
import businessLogic.WebBL;

public class WebNavigationDirectionsTestCases extends TestBase{
	public static final String DETAIL_PAGE_DATA_SHEET = System.getProperty("user.dir") +"/src/main/java/com/purpleAdmin/qa/testdata/KioskData.xls";
	public static final String SHEET_NAME = "Campuses";
	ExtentTest extentTest = null;
	public static ExtentTest parent;
	HashMap<String, String> outputMap;

/*	public WebNavigationDirectionsTestCases(){
		super();
	}*/

	@BeforeTest
	public void createTest() {
		parent = extent.createTest("Directions Validation Test");		
	}

	@BeforeMethod
	public void setUp() {
		outputMap = new HashMap<String, String>();
	}
	

	@Test(priority = 1, enabled = true, dataProvider = "getData")
	public void validateOnsiteDirections(HashMap<String, String> dataMap     ) throws InterruptedException {
		initialization(dataMap     .get("BROWSER_NAME"));
		extentTest = parent.createNode("Validating Onsite Directions on "+ dataMap     .get("BROWSER_NAME")+ " for " +dataMap     .get("CAMPUS_NAME"));
		WebBL wb = new WebBL();
		outputMap = wb.performOnisteDirections(driver, dataMap     );
		wb.validateResults(extentTest, outputMap);
	}
	
	/*@Test(priority = 2,dataProvider = "getData")
	public void validateGoogleResults(HashMap<String, String> dataMap     ){
	initialization(dataMap     .get("BROWSER_NAME"));
		extentTest = parent.createNode("Validating Google Results on "+ dataMap     .get("BROWSER_NAME")+ " for " +dataMap     .get("CAMPUS_NAME"));
		WebBL wb = new WebBL();
		outputMap = wb.performGoogleSearch(driver, dataMap     );
		wb.validateResults(extentTest, outputMap);
	}

	@Test(priority = 3, enabled = true, dataProvider = "getData")
	public void validateOnsiteOffsiteDirections(HashMap<String, String> dataMap     ) throws InterruptedException {
	    initialization(dataMap     .get("BROWSER_NAME"));
		extentTest = parent.createNode("Validating Onsite to Offsite directions on "+ dataMap     .get("BROWSER_NAME")+ " for " +dataMap     .get("CAMPUS_NAME"));
		WebBL wb = new WebBL();
		outputMap = wb.performOnsiteOffsiteDirections(driver, dataMap     );
		wb.validateResults(extentTest, outputMap);
	}
	 
	@Test(priority = 4, enabled = true, dataProvider = "getData")
	public void validateOffsiteOnsiteDirections(HashMap<String, String> dataMap     ) throws InterruptedException {
		initialization(dataMap     .get("BROWSER_NAME"));
		extentTest = parent.createNode("Validating offsite to onsite directions on "+ dataMap     .get("BROWSER_NAME")+ " for " +dataMap     .get("CAMPUS_NAME"));
		WebBL wb = new WebBL();
		outputMap = wb.performOffsiteOnsiteDirections(driver, dataMap     );
		wb.validateResults(extentTest, outputMap);
	}
	
	@Test(priority = 5, enabled = true, dataProvider = "getData")
	public void validateReverseDirections(HashMap<String, String> dataMap     ) throws InterruptedException {
		initialization(dataMap     .get("BROWSER_NAME"));
		extentTest = parent.createNode("Validating Reverse directions on "+ dataMap     .get("BROWSER_NAME")+ " for " +dataMap     .get("CAMPUS_NAME"));
		WebBL wb = new WebBL();
		outputMap = wb.performReverse(driver, dataMap     );
		wb.validateResults(extentTest, outputMap);
	}
	*/
	@AfterMethod
	public void tearDown() {
        driver.close();	
	}


}


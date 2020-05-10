package com.purpleAdmin.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.purpleAdmin.qa.base.TestBase;
import com.purpleAdmin.qa.pages.DestinationPage;
import com.purpleAdmin.qa.pages.HomePage;
import com.purpleAdmin.qa.pages.LoginPage;
import com.purpleAdmin.qa.util.TestUtil;

public class DestinationPageTestCases extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	DestinationPage destinationPage;
	
	public DestinationPageTestCases() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		homePage.clickOnWayFindingSSO();
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		homePage.clickOnHamburgerMenuBtn();
		homePage.clickOnWayfindingLeftMenu();
//	    destinationPage = homePage.clickOnDestinationLink();
	    testUtil.switchToFrame();
	}
	
	@Test(priority = 1, enabled=true)
	public void verifypurpleHeading() {
		String purpleClientText = homePage.verifyHomePageTitle();
		System.out.println(purpleClientText);
		AssertJUnit.assertEquals(purpleClientText, "Purple Test !");
	}
	
	@Test(priority = 2, enabled=true)
	public void verifyDestinationType() {
     destinationPage.validateDestinationType();
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}

package com.purpleAdmin.qa.testcases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.purpleAdmin.qa.base.TestBase;
import com.purpleAdmin.qa.pages.DestinationPage;
import com.purpleAdmin.qa.pages.HomePage;
import com.purpleAdmin.qa.pages.LoginPage;
import com.purpleAdmin.qa.util.TestUtil;

public class HomePageTestCases extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	DestinationPage destinationPage;

	public HomePageTestCases() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

//	@Test(priority = 1, enabled = true)
//	public void verifyHomePageTitleTest() {
//		String homePageTitle = homePage.verifyHomePageTitle();
//		Assert.assertEquals(homePageTitle, "Purple Test !");
//	}
//
//	@Test(priority = 2, enabled = true)
//	public void verifyWayFindingSSOTest() {
//		homePage.clickOnWayFindingSSO();
//	}

	@Test(priority = 3, enabled = true)
	public void verifyDestinationLink() {
		homePage.clickOnWayFindingSSO();
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		homePage.clickOnHamburgerMenuBtn();
		homePage.clickOnWayfindingLeftMenu();
		homePage.clickOnLeftModuleLink("Data Management", "Parking Lots");
		// destinationPage = homePage.clickOnDestinationLink();
	}

	// @Test(priority = 4, enabled = true)
	// public void verifyParkinLot() {
	// homePage.clickOnDataManagement();
	// homePage.clickOnParkingLot();
	// }

	// @AfterMethod
	// public void tearDown() {
	// driver.quit();
	// }

}

package com.purpleAdmin.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.purpleAdmin.qa.base.TestBase;
import com.purpleAdmin.qa.pages.DestinationPage;
import com.purpleAdmin.qa.pages.HomePage;
import com.purpleAdmin.qa.pages.LoginPage;
import com.purpleAdmin.qa.util.TestUtil;

public class ValidateMenuLinksTestCases extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	DestinationPage destinationPage;
	String sheetName = "MenuList";
	
	public ValidateMenuLinksTestCases() {
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

	}

	@DataProvider
	public Object[][] getMenuTestData() {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}

	@Test(priority = 1, enabled = true, dataProvider = "getMenuTestData")
	public void validateMenuLinks(String Menu, String SubMenu) {

		System.out.println(Menu + "---->" + SubMenu);

		homePage.clickOnLeftModuleLink(Menu, SubMenu);
		/*testUtil.switchToFrame();
	    String pageText =	homePage.validatePurpleHeadingtest();
		System.out.println(pageText);*/

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}

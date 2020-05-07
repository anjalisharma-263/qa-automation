package com.purpleAdmin.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.purpleAdmin.qa.base.TestBase;
import com.purpleAdmin.qa.pages.HomePage;
import com.purpleAdmin.qa.pages.LoginPage;
import com.purpleAdmin.qa.util.TestUtil;


public class LoginPageTestCases extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testutil;

	public LoginPageTestCases() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
	}

	@Test(priority = 1, enabled = true)
	public void loginPageTitleTest() {
		String title = loginPage.validateLoginPageTitle();
		System.out.println(title);
		Assert.assertEquals(title, "Purple Test");
	}

	@Test(priority = 2, enabled = true)
	public void loginTest() {
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}

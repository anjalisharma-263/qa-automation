package com.purpleAdmin.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.purpleAdmin.qa.base.TestBase;

public class LoginPage extends TestBase {
	// Page Factory - OR:
	@FindBy(name = "_username")
	WebElement username;

	@FindBy(name = "_password")
	WebElement password;

	@FindBy(xpath = "//button[@id='login' or type='submit']")
	WebElement loginBtn;


	// Initializing the Page Objects:
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions:
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}

	public HomePage login(String un, String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		
		loginBtn.click();
		System.out.println(loginBtn.getText());
//		 JavascriptExecutor js = (JavascriptExecutor)driver;
//		 js.executeScript("arguments[0].click();", loginBtn);
		return new HomePage();
	}

}

package com.purpleAdmin.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.purpleAdmin.qa.base.TestBase;
import com.purpleAdmin.qa.util.TestUtil;

public class KioskHomePage extends TestBase {

	// Page Factory - OR:

	@FindBy(xpath = "//button[contains(text(),'Touch Here To Begin')]")
	WebElement BeginBtn;
	@FindBy(xpath = "//button[@class='closeVideoIntro']")
	WebElement SkipIntro;

	@FindBy(xpath = "//h3[contains(text(),'Main Menu')]")
	WebElement MainMenu;

	// Initializing the Page Objects:
	public KioskHomePage() {
		PageFactory.initElements(driver, this);
	}

	// Actions:
	public void clickBeginBtn() {
		System.out.println("-----------------" + BeginBtn);
		if (TestUtil.waitForElementPresence(BeginBtn, driver)) {
			BeginBtn.click();

		}
	}

	public void clickSkipIntro() {
		System.out.println("-----------------" + SkipIntro);
		if (TestUtil.waitForElementPresence(SkipIntro, driver)) {
			SkipIntro.click();

		}
	}

	public String getTitleMainMenu() {
		String title = "";
		if (TestUtil.waitForElementPresence(MainMenu, driver)) {
			title = MainMenu.getText();
		}
		return title;
	}

}

package com.purpleAdmin.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.purpleAdmin.qa.base.TestBase;
import com.purpleAdmin.qa.util.TestUtil;

public class KioskDirectoryPage extends TestBase {
	// Page Factory - OR:

	@FindBy(xpath = "//h3[contains(text(),'Main Menu')]")
	WebElement MainMenu;

	// Initializing the Page Objects:
	public KioskDirectoryPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions:

	public String getTitleMainMenu() {
		String title = "";
		if (TestUtil.waitForElementPresence(MainMenu, driver)) {
			title = MainMenu.getText();
		}
		return title;
	}

	public void clickOnDirectoryMenuFrom(String fromFirstMenu) {
		WebElement FromFirstMenu = driver.findElement(By.xpath("//span[contains(text(),'" + fromFirstMenu + "')]"));
		if (TestUtil.waitForElementPresence(FromFirstMenu, driver)) {
			FromFirstMenu.click();
		}
	}

	public void clickOnDirectorySubMenuFrom(String fromSubMenu) {
		WebElement FromSubMenu = driver.findElement(By.xpath("//span[contains(text(),'" + fromSubMenu + "')]"));
		if (TestUtil.waitForElementPresence(FromSubMenu, driver)) {
			FromSubMenu.click();
		}
	}

	public void clickOnDirectorySubMenu2From(String fromSubMenu2) {
		WebElement FromSubMenu2 = driver.findElement(By.xpath("//span[contains(text(),'" + fromSubMenu2 + "')]"));
		if (TestUtil.waitForElementPresence(FromSubMenu2, driver)) {
			FromSubMenu2.click();
		}
	}

}

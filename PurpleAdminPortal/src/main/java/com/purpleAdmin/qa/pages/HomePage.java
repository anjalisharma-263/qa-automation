package com.purpleAdmin.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.purpleAdmin.qa.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath = "//input[@id='scope-search-input']")
	WebElement WayFindingSSO;

	@FindBy(xpath = "//span[contains(text(),'Albany Medical Center')]")
	WebElement AMCLink;

	@FindBy(xpath = "//div[@class='scope-item--venue scope-item']//button[@class='btn icon xsmall']")
	WebElement AMCIconBtn;

	@FindBy(xpath = "//div[@class='menu-icon']")
	WebElement HamburgerMenuBtn;

	@FindBy(xpath = "//p[contains(text(),'Wayfinding')]")
	WebElement WayfindingLeftMenu;
	
	@FindBy(xpath = "//h4[@class='purpleHeading']")
	WebElement PurpleHeadingOnPage;
	
	// Initializing the Page Objects:
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public String verifyHomePageTitle() {
		return driver.getTitle();
	}

	public void clickOnWayFindingSSO() {
		WayFindingSSO.click();
		Actions action = new Actions(driver);
		action.moveToElement(AMCLink).build().perform();
		AMCIconBtn.click();
	}

//	 public void clickOnHamburgerMenuBtn() {
//	 WebDriverWait wait = new WebDriverWait(driver, 10);
//	 WebElement HamburgerMenuBtn;
//	 HamburgerMenuBtn = wait
//	 .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='menu-icon']")));
//	 HamburgerMenuBtn.click();
//	 }

	public void clickOnHamburgerMenuBtn() {
		HamburgerMenuBtn.click();
	}

	public void clickOnWayfindingLeftMenu() {
		WayfindingLeftMenu.click();
		Reporter.log("AAA", true);
	}

//	 public DestinationPage clickOnDestinationLink() {
//	 DestinationLink.click();
//	 return new DestinationPage();
//	 }
	
	
	public void clickOnLeftModuleLink(String module , String subModule)
	{
		WebElement ModuleLink= driver.findElement(By.xpath("//p[contains(text(),'"+module+"')]"));
		WebElement SubModuleLink= driver.findElement(By.xpath("//p[contains(text(),'"+subModule+"')]"));
		ModuleLink.click();
		SubModuleLink.click();
	}
	
	public String validatePurpleHeadingtest() {
		return PurpleHeadingOnPage.getText();
	}
	

//	public void clickOnDestinationLink() {
//		DestinationLink.click();
//
//	}

}

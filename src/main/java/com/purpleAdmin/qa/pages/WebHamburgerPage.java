package com.purpleAdmin.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.purpleAdmin.qa.base.TestBase;
import com.purpleAdmin.qa.util.TestUtil;

public class WebHamburgerPage extends TestBase {
	// Page Factory - OR:


	@FindBy(xpath = "(//ion-menu-button)[2]")
	WebElement hambugerTag;
	
	@FindBy(xpath = "//span[@class='menuBackArrow']")
	WebElement closeHamburger;
	
	@FindBy(xpath = "//span[contains(text(),'Clear Route')]")
	WebElement clearRoute;
	
	@FindBy(xpath = "//span[contains(text(),'App Overview')]")
	WebElement appOverview;
	
	@FindBy(xpath = "//span[contains(text(),'Privacy Policy')]")
	WebElement privacyPolicy;

	@FindBy(xpath = "//span[contains(text(),'End User License Agreement (EULA)')]")
	WebElement clickEULAFromHamburger;
	
	@FindBy(xpath = "//span[contains(text(), 'LJ PRIVACY AND SECURITY POLICY')]")
	WebElement privacyPolicyText;
	
	@FindBy(xpath = "//strong[contains(text(), 'END USER SOFTWARE LICENSE AGREEMENT')]")
	WebElement EULAText;
	
	Boolean blnFlag = false;

	//Initializing the Page objects
	public WebHamburgerPage(){
		PageFactory.initElements(driver, this);
	}

	
	public void clickCloseHamburger(){
		if(TestUtil.waitForElementPresence(closeHamburger, driver)){
			closeHamburger.click();
		}
	}
	
	public void clickHamburger(){
		if(TestUtil.waitForElementPresence(hambugerTag, driver)){
		WebElement shadowRoot1 = TestUtil.expandRootElement(hambugerTag);
		shadowRoot1.findElement(By.cssSelector("button[type=button]")).click();;
		}
	}
	
	public void clickClearRoute(){
		if(TestUtil.waitForElementPresence(clearRoute, driver)){
			clearRoute.click();
		}
	}
	
	public void clickPrivacyPolicy(){
		if(TestUtil.waitForElementPresence(privacyPolicy, driver)){
			privacyPolicy.click();
		}
	}
	
	public Boolean isPrivacyPolicyLoaded(){
		if(TestUtil.waitForElementPresence(privacyPolicyText, driver)){
			blnFlag = true;
		}
		return blnFlag;
	}
	
	public void clickEULAFromHamburger(){
		if(TestUtil.waitForElementPresence(clickEULAFromHamburger, driver)){
			clickEULAFromHamburger.click();
		}
	}
	
	public Boolean isEULALoaded(){
		if(TestUtil.waitForElementPresence(EULAText, driver)){
			blnFlag = true;
		}
		return blnFlag;
	}
	
	public void clickAppOverview() throws InterruptedException{
		if(TestUtil.waitForElementPresence(appOverview, driver)){
			Thread.sleep(5000);
			appOverview.click();
		}
	}
	
}




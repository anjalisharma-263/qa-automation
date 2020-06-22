package com.purpleAdmin.qa.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.purpleAdmin.qa.base.TestBase;
import com.purpleAdmin.qa.util.TestUtil;

public class WebLoginPage extends TestBase {
	// Page Factory - OR:

	@FindBy(tagName = "ion-checkbox")
	WebElement eULAchkBoxTag;

	@FindBy(xpath = "//button[@class='agreeBtn']")
	WebElement agreeBtn;

	@FindBy(xpath = "//a[contains(text(),'SKIP TUTORIAL')]")
	WebElement skipTutorial;

	@FindBy(xpath = "//input[@name ='ion-input-0']")
	public
	WebElement startingPoint;

	//Initializing the Page objects
	public WebLoginPage(){
		PageFactory.initElements(driver, this);
	}

	public void acceptEULAChkBox(){
		if(TestUtil.waitForElementPresence(eULAchkBoxTag, driver)){
			WebElement shadowRoot1 = TestUtil.expandRootElement(eULAchkBoxTag);
			shadowRoot1.findElement(By.cssSelector("button[type=button]")).click();;
		}
	}

	public void acceptEULABtn(){
		try{
			if(TestUtil.waitForElementPresence(agreeBtn, driver)){
				agreeBtn.click();
			}
		}catch(Exception e){
			System.out.println("EULA is not displayed");
		}
	}

	public Boolean skipTutorial(){
		Boolean blnFlag = false;
		try{
			if(TestUtil.waitForElementPresence(skipTutorial, driver)){
				skipTutorial.click();
				blnFlag = true;
			}
		}catch(Exception e){
			System.out.println("Skip tutorial not displayed");
		}
		return blnFlag;
	}	

	public void clickStartingPoint(){
		if(TestUtil.waitForElementPresence(startingPoint, driver)){
			startingPoint.click();
		}
	}
}


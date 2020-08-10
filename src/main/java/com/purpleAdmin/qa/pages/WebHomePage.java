package com.purpleAdmin.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.purpleAdmin.qa.base.TestBase;
import com.purpleAdmin.qa.util.TestUtil;

public class WebHomePage extends TestBase {
	// Page Factory - OR:

	@FindBy(tagName = "ion-checkbox")
	WebElement eULAchkBoxTag;

	@FindBy(xpath = "//div[@class ='checkboxTerms']//ion-checkbox")
	WebElement eULAchkBox;

	@FindBy(xpath = "//button[@class='agreeBtn']")
	WebElement agreeBtn;

	@FindBy(xpath = "//a[contains(text(),'SKIP TUTORIAL')]")
	WebElement skipTutorial;

	@FindBy(xpath = "//ion-col[@class='md hydrated']//img[@class='logo']")
	public WebElement companyLogo;

	@FindBy(xpath = "//input[@name ='ion-input-0']")
	WebElement startingPoint;

	//Initializing the Page objects
	public WebHomePage(){
		PageFactory.initElements(driver, this);
	}

	public void acceptEULAChkBox(String browserName){
		if(browserName.equals("Chrome")){
			if(TestUtil.waitForElementPresence(eULAchkBoxTag, driver)){
				WebElement shadowRoot1 = TestUtil.expandRootElement(eULAchkBoxTag);
				shadowRoot1.findElement(By.cssSelector("button[type=button]")).click();;
			}
		}
		if(browserName.equals("FF") || browserName.equals("Edge") || browserName.equals("IE")){
			try {
				Thread.sleep(15000);
				JavascriptExecutor executor = (JavascriptExecutor)driver;
				executor.executeScript("arguments[0].click();", eULAchkBox);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		if(browserName.equals("Safari")){
			if(TestUtil.waitForElementPresence(eULAchkBox, driver)){
				eULAchkBox.click();
			}
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

	public Boolean isLogoPresent(){
		Boolean blnFlag = false;
		if(TestUtil.waitForElementPresence(companyLogo, driver)){
			blnFlag = true;
		}
		return blnFlag;
	}

	public Boolean isTextCleared(){
		return TestUtil.compareText(startingPoint, "");
	}
}


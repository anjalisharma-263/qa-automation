package com.purpleAdmin.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.purpleAdmin.qa.base.TestBase;
import com.purpleAdmin.qa.util.TestUtil;

public class WebEmailPrintPage extends TestBase{
	// Page Factory - OR:

	@FindBy(xpath = "//span[@class ='emailIcon']")
	WebElement emailBtn;

	@FindBy(xpath = "//input[@type ='email']")
	WebElement typeEmail;

	@FindBy(xpath = "//div[@class ='buttonWrapperInModal']//button")
	WebElement sendEmail;

	@FindBy(xpath = "//div[@class = 'thankyouMessage']")
	WebElement sentEmailMessage;

	@FindBy(xpath = "//button[@class = 'close-button-modal-popup']")
	WebElement closeEmail;

	@FindBy(xpath = "//span[@class ='printIcon ']")
	WebElement printBtn;

	@FindBy(xpath = "//button[contains(text(),'Print Directions')]")
	WebElement printDirectionsBtn;

	@FindBy(xpath = "//button[contains(text(),'Return to Map')]")
	WebElement returnMapBtn;

	//Initializing the Page objects
	public WebEmailPrintPage(){
		PageFactory.initElements(driver, this);
	}

	public void clickEmailBtn(){
		if(TestUtil.waitForElementPresence(emailBtn, driver)){
			emailBtn.click();
		}
	}

	public void enterEmail(String email){
		if(TestUtil.waitForElementPresence(typeEmail, driver)){
			typeEmail.sendKeys(email);
		}
	}

	public void clickSendEmail(){
		if(TestUtil.waitForElementPresence(sendEmail, driver)){
			sendEmail.click();
		}
	}

	public String getSentMessage(){
		String messageSent = sentEmailMessage.getText();
		return messageSent;
	}

	public void closeSendEmail(){
		if(TestUtil.waitForElementPresence(closeEmail, driver)){
			closeEmail.click();
		}
	}

	public void clickPrintBtn(){
		if(TestUtil.waitForElementPresence(printBtn, driver)){
			printBtn.click();
		}
	}

	public Boolean isPrintDirectionVisible(){
		Boolean blnFlag = false;
		String currentPageURL = "";
		currentPageURL = driver.getCurrentUrl();
		if(currentPageURL.contains("printable")){
			blnFlag = true;
		}
		return blnFlag;
	}

	public void clickReturnToMapBtn(){
		if(TestUtil.waitForElementPresence(returnMapBtn, driver)){
			returnMapBtn.click();
		}
	}
}

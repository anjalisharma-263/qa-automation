package com.purpleAdmin.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.purpleAdmin.qa.base.TestBase;
import com.purpleAdmin.qa.util.TestUtil;

public class WebDirectoryPage extends TestBase{
	@FindBy(xpath = "//input[@name ='ion-input-0']")
	WebElement startingPoint;

	@FindBy(xpath = "//input[@name ='ion-input-1']")
	WebElement destinationPoint;

	@FindBy(xpath = "(//span[@class='iconExpanderBg'])[1]")
	WebElement expandIcon;

	@FindBy(xpath = "(//button[@class='mapItButton'])[1]")
	WebElement MapIt;

	@FindBy(xpath = "(//button[@class='viewMap '])[1]")
	WebElement viewOnMap;
	
	@FindBy(xpath = "(//button[@class='viewMap '])[2]")
	WebElement viewOnMapForOffsite;

	@FindBy(xpath = "(//div[@class='accordion']//a)[1]")
	WebElement selectParking;

	@FindBy(id = "reverseDirection")
	WebElement reverseDirection;

	Boolean blnFlag = false;
	
	//Initializing the Page objects
	public WebDirectoryPage(){
		PageFactory.initElements(driver, this);
	}
	public void enterStartingPoint(String starting_Point){
		if(TestUtil.waitForElementPresence(startingPoint, driver)){
			startingPoint.click();
			startingPoint.sendKeys(starting_Point);
		}
	}

	public void enterDestinationPoint(String destination_Point){
		if(TestUtil.waitForElementPresence(startingPoint, driver)){
			destinationPoint.click();
			destinationPoint.sendKeys(destination_Point);
		}
	}

	public void ExpandIconPoint(){
		if(TestUtil.waitForElementPresence(expandIcon, driver)){
			expandIcon.click();
		}
	}

	public void clickMapIt(){
		if(TestUtil.waitForElementPresence(MapIt, driver)){
			MapIt.click();
		}
	}

	public Boolean clickViewOnMap(){
		if(TestUtil.waitForElementPresence(viewOnMap, driver)){
			viewOnMap.click();
			blnFlag = true;
		}
		return blnFlag;
	}
	
	public Boolean clickViewOnMapForOffiste(){
		TestUtil.scrollByVisibleElement(viewOnMapForOffsite);
		if(TestUtil.waitForElementPresence(viewOnMapForOffsite, driver)){
			viewOnMapForOffsite.click();
			blnFlag = true;
		}
		return blnFlag;
	}

	public void selectParkingFromMenu(){
		if(TestUtil.waitForElementPresence(selectParking, driver)){
			selectParking.click();
		}
	}

	public void clickReverseDirection(){
		if(TestUtil.waitForElementPresence(reverseDirection, driver)){
			reverseDirection.click();
		}
	}
}

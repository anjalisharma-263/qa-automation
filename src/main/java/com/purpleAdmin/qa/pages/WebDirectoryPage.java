package com.purpleAdmin.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
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
	
	@FindBy(xpath = "(//ion-row[@class ='searchGoogleRow md hydrated']//ion-col//div//a)[1]")
	WebElement selectOffsiteLocation;

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
	
	public void selectOffsiteLocation(){
		if(TestUtil.waitForElementPresence(selectOffsiteLocation, driver)){
			selectOffsiteLocation.click();
			/*WebElement shadowRoot1 = TestUtil.expandRootElement(selectOffsiteLocation);
			shadowRoot1.findElement(By.cssSelector("ion-row[class=searchGoogleRow md hydrated]")).click();;*/
		}
	}

	public void clickMapIt(){
		if(TestUtil.waitForElementPresence(MapIt, driver)){
			MapIt.click();
		}
	}

	public Boolean clickViewOnMap(){
		Boolean blnFlag = false;
		if(TestUtil.waitForElementPresence(viewOnMap, driver)){
			viewOnMap.click();
			blnFlag = true;
		}
		return blnFlag;
	}

	public Boolean clickViewOnMapForOffiste(){
		Boolean blnFlag = false;
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

	public Boolean isReverseIconEnabled(){
		Boolean blnFlag = false;
		blnFlag = reverseDirection.isEnabled();
		if(blnFlag==false){
			blnFlag = true;
		}
		return blnFlag;
	}

	public Boolean isDirectionContentClickable(){
		Boolean blnFlag = false;
		List<WebElement> allRows = driver.findElements(By.xpath("//ul//li//span[@class = 'directionContent ']"));
		System.out.println(allRows);

		for (WebElement element: allRows) {
			System.out.println(element.getText());
			blnFlag = element.isEnabled();
			if(blnFlag){
				element.click();          
			}
			else{
				System.out.println(element +" is not clickable ");
			}
		}
		return blnFlag;
	}

	public void clearStartingPointText(){
		TestUtil.clearData(startingPoint);
	}

	public void clearDestinationPointText(){
		TestUtil.clearData(destinationPoint);
	}

	public Boolean isGoogleSearchEnable(){
		Boolean blnFlag = false;
		List<WebElement> googleResultList = driver.findElements(By.xpath("//div[@class ='googlesearchAtoComplete']//div//div//ion-row"));
		for (WebElement element: googleResultList) {
			System.out.println(element.getText());
		}
		if(googleResultList.size()>=1){
			blnFlag = true;    
		}
		else{
			System.out.println("Google search is not working");
		}
		return blnFlag;
	}
}

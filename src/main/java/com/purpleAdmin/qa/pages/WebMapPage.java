package com.purpleAdmin.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.purpleAdmin.qa.base.TestBase;
import com.purpleAdmin.qa.util.TestUtil;

public class WebMapPage extends TestBase {
	@FindBy(xpath = "(//*[@name='withDirectionButton'])[2]")
	WebElement onsiteMapOnly;

	@FindBy(xpath = "(//*[@name='noDirectionButton'])[2]")
	WebElement onsiteOffsiteMap;

	@FindBy(xpath = "//ion-content[@name='noDirectionButton']")
	WebElement offsiteOnsiteMap;

	@FindBy(xpath = "//img[@class='flipIcon']")
	WebElement blueDot;

	@FindBy(xpath = "(//map[@id='gmimap2']//..)[1]")
	WebElement googlePointA;

	@FindBy(xpath = "//img[@usemap='#gmimap3']")
	WebElement googlePointB;
	
	@FindBy(xpath = "//span[@class='zoomIcon zoomIn active']")
	WebElement mapZoomIn;
	
	@FindBy(xpath = "//span[@class='zoomIcon zoomOut active']")
	WebElement mapZoomOut;
	
	@FindBy(xpath = "//span[@class='rotationIcon leftRotation active']")
	WebElement mapRotateLeft;
	
	@FindBy(xpath = "//span[@class='rotationIcon rightRotation active']")
	WebElement mapRotateRight;
	
	@FindBy(xpath = "//span[@class='recenter active']")
	WebElement mapRecentre;
	
	@FindBy(xpath = "//span[@class='legendsKey active']")
	WebElement legendsKey;
	
	Boolean blnFlag = false;

	//Initializing the Page objects
	public WebMapPage(){
		PageFactory.initElements(driver, this);
	}

	public Boolean verifyOnsiteMapPresence(){
		if(TestUtil.waitForElementPresence(onsiteMapOnly, driver)){
			System.out.println("indoorMap is loaded");
			blnFlag = true;
		}
		return blnFlag;
	}

	public Boolean verifyOnsiteOffsiteMapPresence(){
		if(TestUtil.waitForElementPresence(onsiteOffsiteMap, driver)){
			System.out.println("indoorMap is loaded");
			blnFlag = true;
		}
		return blnFlag;
	}

	public Boolean verifyOffsiteOnsiteMapPresence(){
		if(TestUtil.waitForElementPresence(offsiteOnsiteMap, driver)){
			System.out.println("Google Map is loaded");
			blnFlag = true;
		}
		return blnFlag;
	}

	public Boolean verifyBlueDotPresence(){
		if(TestUtil.waitForElementPresence(blueDot, driver)){
			System.out.println("Blue Dot is present");
			blnFlag = true;
		}
		return blnFlag;
	}
	
	public void verifyPointAB(){
		if(TestUtil.waitForElementPresence(googlePointA, driver)){
			System.out.println("Point A is present on Google map");
		}
		if(TestUtil.waitForElementPresence(googlePointB, driver)){
			System.out.println("Point B is present on Google map");
		}
		else{
			System.out.println("Points are not present on Google map");
		}
	}
	
	public Boolean verifyMapZoomIn(){
		if(TestUtil.waitForElementPresence(mapZoomIn, driver)){
			System.out.println("Zoom In icon is present");
			mapZoomIn.click();
			blnFlag = true;
		}
		return blnFlag;
	}
	
	public Boolean verifyMapZoomOut(){
		if(TestUtil.waitForElementPresence(mapZoomOut, driver)){
			System.out.println("Zoom Out icon is present");
			blnFlag = true;
		}
		return blnFlag;
	}
	
	public Boolean verifyMapRotateLeft(){
		if(TestUtil.waitForElementPresence(mapRotateLeft, driver)){
			System.out.println("Rotate Left icon is present");
			blnFlag = true;
		}
		return blnFlag;
	}
	
	public Boolean verifyMapRotateRight(){
		if(TestUtil.waitForElementPresence(mapRotateRight, driver)){
			System.out.println("Rotate Right icon is present");
			blnFlag = true;
		}
		return blnFlag;
	}
	
	public Boolean verifyMapRecenter(){
		if(TestUtil.waitForElementPresence(mapRecentre, driver)){
			System.out.println("Map Recentre icon is present");
			blnFlag = true;
		}
		return blnFlag;
	}
	
	public Boolean verifyKeyLegends(){
		if(TestUtil.waitForElementPresence(legendsKey, driver)){
			System.out.println("Key Legends icon is present");
			blnFlag = true;
		}
		return blnFlag;
	}
}

package com.purpleAdmin.qa.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
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
	WebElement keylegends;
	
	@FindBy(xpath = "//button[@class='legends-modal-close-button']")
	WebElement keylegendsCloseBtn;
	
	@FindBy(xpath = "//div[@id ='FloorBasement-map']//div[@class = 'leaflet-pane leaflet-rotate-pane']")
	WebElement rotatePane;
	
	@FindBy(xpath = "//div[@id ='FloorBasement-map']//div[@class = 'leaflet-proxy leaflet-zoom-animated']")
	WebElement zoomPane;
	
 


	//Initializing the Page objects
	public WebMapPage(){
		PageFactory.initElements(driver, this);
	}

	public Boolean verifyOnsiteMapPresence(){
		Boolean blnFlag = false;
		if(TestUtil.waitForElementPresence(onsiteMapOnly, driver)){
			System.out.println("indoorMap is loaded");
			blnFlag = true;
		}
		return blnFlag;
	}

	public Boolean verifyOnsiteOffsiteMapPresence(){
		Boolean blnFlag = false;
		if(TestUtil.waitForElementPresence(onsiteOffsiteMap, driver)){
			System.out.println("indoorMap is loaded");
			blnFlag = true;
		}
		return blnFlag;
	}

	public Boolean verifyOffsiteOnsiteMapPresence(){
		Boolean blnFlag = false;
		if(TestUtil.waitForElementPresence(offsiteOnsiteMap, driver)){
			System.out.println("Google Map is loaded");
			blnFlag = true;
		}
		return blnFlag;
	}

	public Boolean verifyBlueDotPresence(){
		Boolean blnFlag = false;
		if(TestUtil.waitForElementPresence(blueDot, driver)){
			System.out.println("Blue Dot is present");
			blnFlag = true;
		}
		return blnFlag;
	}

	public Boolean isGooglePointABVisible(){
		Boolean blnFlag = false;
		List<WebElement> list = new ArrayList<WebElement>();
		list = driver.findElements(By.xpath("//map[contains(@id,'gmimap')]//area"));
		System.out.print(list.size());
		if(list.size()==2){
			System.out.println("Google Points A and B are present");
			blnFlag = true;
		}
		return blnFlag;
	}

	public Boolean verifyMapZoomIn(){
		Boolean blnFlag = false;
		if(TestUtil.waitForElementPresence(mapZoomIn, driver)){
			System.out.println("Zoom In icon is present");
			mapZoomIn.click();
			blnFlag = true;
		}
		return blnFlag;
	}

	public Boolean verifyMapZoomOut(){
		Boolean blnFlag = false;
		if(TestUtil.waitForElementPresence(mapZoomOut, driver)){
			mapZoomOut.click();
			System.out.println("Zoom Out icon is present");
			blnFlag = true;
		}
		return blnFlag;
	}

	public Boolean verifyMapRotateLeft(){
		Boolean blnFlag = false;
		if(TestUtil.waitForElementPresence(mapRotateLeft, driver)){
			mapRotateLeft.click();
			System.out.println("Rotate Left icon is present");
			blnFlag = true;
		}
		return blnFlag;
	}

	public Boolean verifyMapRotateRight(){
		Boolean blnFlag = false;
		if(TestUtil.waitForElementPresence(mapRotateRight, driver)){
			mapRotateRight.click();
			System.out.println("Rotate Right icon is present");
			blnFlag = true;
		}
		return blnFlag;
	}

	public Boolean verifyMapRecenter(){
		Boolean blnFlag = false;
		if(TestUtil.waitForElementPresence(mapRecentre, driver)){
			mapRecentre.click();
			System.out.println("Map Recentre icon is present");
			blnFlag = true;
		}
		return blnFlag;
	}

	public Boolean verifyKeyLegends(){
		Boolean blnFlag = false;
		if(TestUtil.waitForElementPresence(keylegends, driver)){
			keylegends.click();
			blnFlag = true;
		}
		return blnFlag;
	}
	
	public Boolean getKeyLegendsList(){
		Boolean isKeyLegendList = false;
		List<WebElement> keyLegendsList = driver.findElements(By.xpath("//div[@class ='legends']//li"));
		for (WebElement element: keyLegendsList) {
			System.out.println(element.getText());
		}
		if(keyLegendsList.size()>=1){
			isKeyLegendList = true;    
		}
		else{
			System.out.println("Key legend list has no keys");
		}
		return isKeyLegendList;
	}
	
	public Boolean closeKeyLegendsModel(){
		Boolean blnFlag = false;
		if(TestUtil.waitForElementPresence(keylegendsCloseBtn, driver)){
			keylegendsCloseBtn.click();
			blnFlag = true;
		}
		return blnFlag;
	}
	
	public String getRotateAttributeValue(){
		String att = rotatePane.getAttribute("style");
		System.out.print(att);
		int index = att.indexOf("rotate");
		System.out.println(att.substring(index));
		return att.substring(index);
	}
	
	public String getZoomAttributeValue(){
		String att = zoomPane.getAttribute("style");
		System.out.print(att);
		int beginindex = att.indexOf("translate3d");
		int endindex = att.indexOf(")");
		System.out.println(att.substring(beginindex, endindex));
		return att.substring(beginindex, endindex);
	}
}	
	
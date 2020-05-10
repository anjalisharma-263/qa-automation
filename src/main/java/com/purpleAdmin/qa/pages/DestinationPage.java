package com.purpleAdmin.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.purpleAdmin.qa.base.TestBase;

public class DestinationPage extends TestBase {

	@FindBy(xpath = "//*[@class='purpleHeading']")
	WebElement purpleHeading;

	@FindBy(xpath = "//select[@id='DestinationTypeID']")
	WebElement DestinationType;

	public DestinationPage() {
		PageFactory.initElements(driver, this);
	}

	public String validatepurpleHeading() {
		return purpleHeading.getText();

	}

	public void validateDestinationType() {

		Select destination = new Select(DestinationType);
		destination.selectByVisibleText(prop.getProperty("DestinationTypeDdlValue"));

	}

}

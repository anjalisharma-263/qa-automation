package businessLogic;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.purpleAdmin.qa.pages.Kiosk;
import com.purpleAdmin.qa.pages.WebDirectoryPage;
import com.purpleAdmin.qa.pages.WebHamburgerPage;
import com.purpleAdmin.qa.pages.WebLoginPage;
import com.purpleAdmin.qa.pages.WebMapPage;
import com.purpleAdmin.qa.util.TestUtil;

public class WebBL {
	WebLoginPage loginPage = new WebLoginPage();
	WebDirectoryPage dirPage = new WebDirectoryPage();
	WebMapPage mapPage = new WebMapPage();
	WebHamburgerPage webHamburgerPage = new WebHamburgerPage();  
	Boolean isMapDisplayed = false;
	Boolean isBlueDotDisplayed = false;
	Boolean isNavigationStepsDisplayed = false;
	HashMap<String, String> outputMap = new HashMap<String, String>();
	ExtentTest extentTest = null;


	public HashMap<String , String> performOnisteDirections(WebDriver driver, HashMap<String, String> dataMap) {
		performPrerequisites(driver, dataMap);
		isNavigationStepsDisplayed = dirPage.clickViewOnMap();
		isMapDisplayed = mapPage.verifyOnsiteMapPresence();
		isBlueDotDisplayed = mapPage.verifyBlueDotPresence();
		outputMap.put("NAVIGATION_STATUS", String.valueOf(isNavigationStepsDisplayed));
		outputMap.put("MAP_STATUS", String.valueOf(isMapDisplayed));
		outputMap.put("BLUEDOT_STATUS", String.valueOf(isBlueDotDisplayed));
		return outputMap;
	}

	public HashMap<String , String> performOnisteOffsiteDirections(WebDriver driver, HashMap<String, String> dataMap) {
		performPrerequisites(driver, dataMap);
		dirPage.selectParkingFromMenu();
		isNavigationStepsDisplayed = dirPage.clickViewOnMap();
		isMapDisplayed = mapPage.verifyOnsiteOffsiteMapPresence();
		isBlueDotDisplayed = mapPage.verifyBlueDotPresence();
		outputMap.put("NAVIGATION_STATUS", String.valueOf(isNavigationStepsDisplayed));
		outputMap.put("MAP_STATUS", String.valueOf(isMapDisplayed));
		outputMap.put("BLUEDOT_STATUS", String.valueOf(isBlueDotDisplayed));
		return outputMap;
	}

	public HashMap<String , String> performOffsiteOnisteDirectionsReverse(WebDriver driver, HashMap<String, String> dataMap) {
		performPrerequisites(driver, dataMap);
		dirPage.selectParkingFromMenu();
		dirPage.clickViewOnMap();
		dirPage.clickReverseDirection();	
		dirPage.selectParkingFromMenu();
		isMapDisplayed = mapPage.verifyOffsiteOnsiteMapPresence();
		isNavigationStepsDisplayed = dirPage.clickViewOnMapForOffiste();
		isBlueDotDisplayed = mapPage.verifyBlueDotPresence();
		//mapPage.verifyPointAB();
		outputMap.put("NAVIGATION_STATUS", String.valueOf(isNavigationStepsDisplayed));
		outputMap.put("MAP_STATUS", String.valueOf(isMapDisplayed));	
		outputMap.put("BLUEDOT_STATUS", String.valueOf(isBlueDotDisplayed));
		return outputMap;
	}

	public HashMap<String, String> performClearRoute(WebDriver driver, HashMap<String, String> dataMap){
		try{
			Boolean isTextCleared = false;
			performPrerequisites(driver, dataMap);
			webHamburgerPage.clickHamburger();
			webHamburgerPage.clickClearRoute();
			isTextCleared = TestUtil.compareText(loginPage.startingPoint, "");
			System.out.print(isTextCleared);
			outputMap.put("CLEARROUTE_STATUS", String.valueOf(isTextCleared));
		}catch(Exception e){
			System.out.println(e);
		}
		return outputMap;
	}
	
	public HashMap<String, String> performAppOverview(WebDriver driver, HashMap<String, String> dataMap) {
		try{
			Boolean isSkipTutorial = false;
			driver.get(dataMap.get("URL"));
			acceptTermsDisplayed();
			webHamburgerPage.clickHamburger();
			webHamburgerPage.clickAppOverview();
			isSkipTutorial = loginPage.skipTutorial();
			System.out.print(isSkipTutorial);
			outputMap.put("APPOVERVIEW_STATUS", String.valueOf(isSkipTutorial));
		}catch(Exception e){
			System.out.println(e);
		}
		return outputMap;
	}
	
	public HashMap<String, String> performPrivacyPolicyBtn(WebDriver driver, HashMap<String, String> dataMap) {
		try{
			Boolean isPPolicyTextLoaded = false;
			driver.get(dataMap.get("URL"));
			acceptTermsDisplayed();
			webHamburgerPage.clickHamburger();
			webHamburgerPage.clickPrivacyPolicy();
			isPPolicyTextLoaded = webHamburgerPage.isPrivacyPolicyLoaded();
			System.out.print(isPPolicyTextLoaded);
			outputMap.put("PRIVACYPOLICY_STATUS", String.valueOf(isPPolicyTextLoaded));
		}catch(Exception e){
			System.out.println(e);
		}
		return outputMap;
	}
	
	public HashMap<String, String> performEULA(WebDriver driver, HashMap<String, String> dataMap) {
		try{
			Boolean isEULATextLoaded = false;
			driver.get(dataMap.get("URL"));
			acceptTermsDisplayed();
			webHamburgerPage.clickHamburger();
			webHamburgerPage.clickEULAFromHamburger();
			isEULATextLoaded = webHamburgerPage.isEULALoaded();
			System.out.print(isEULATextLoaded);
			outputMap.put("EULA_STATUS", String.valueOf(isEULATextLoaded));
		}catch(Exception e){
			System.out.println(e);
		}
		return outputMap;
	}

	public HashMap<String, String> performMapZoomIn(WebDriver driver, HashMap<String, String> dataMap) {
		try{
			Boolean isMapZoomedIn = false;
			performPrerequisites(driver, dataMap);
			isMapZoomedIn = mapPage.verifyMapZoomIn();
			System.out.print(isMapZoomedIn);
			outputMap.put("ZoomIn_STATUS", String.valueOf(isMapZoomedIn));
		}catch(Exception e){
			System.out.println(e);
		}
		return outputMap;
	}
	
	public HashMap<String, String> performMapZoomOut(WebDriver driver, HashMap<String, String> dataMap) {
		try{
			Boolean isMapZoomedOut = false;
			performPrerequisites(driver, dataMap);
			isMapZoomedOut = mapPage.verifyMapZoomOut();
			System.out.print(isMapZoomedOut);
			outputMap.put("ZoomOut_STATUS", String.valueOf(isMapZoomedOut));
		}catch(Exception e){
			System.out.println(e);
		}
		return outputMap;
	}
	
	public HashMap<String, String> performMapRecenter(WebDriver driver, HashMap<String, String> dataMap) {
		try{
			Boolean isMapRecentered = false;
			performPrerequisites(driver, dataMap);
			isMapRecentered = mapPage.verifyMapRecenter();
			System.out.print(isMapRecentered);
			outputMap.put("MapRecenter_STATUS", String.valueOf(isMapRecentered));
		}catch(Exception e){
			System.out.println(e);
		}
		return outputMap;
	}
	
	public HashMap<String, String> performMapRotationLeft(WebDriver driver, HashMap<String, String> dataMap) {
		try{
			Boolean isMapRotatedLeft = false;
			performPrerequisites(driver, dataMap);
			isMapRotatedLeft = mapPage.verifyMapRotateLeft();
			System.out.print(isMapRotatedLeft);
			outputMap.put("MapRotateLeft_STATUS", String.valueOf(isMapRotatedLeft));
		}catch(Exception e){
			System.out.println(e);
		}
		return outputMap;
	}
	
	public HashMap<String, String> performMapRotationRight(WebDriver driver, HashMap<String, String> dataMap) {
		try{
			Boolean isMapRotatedRight = false;
			performPrerequisites(driver, dataMap);
			isMapRotatedRight = mapPage.verifyMapRotateLeft();
			System.out.print(isMapRotatedRight);
			outputMap.put("MapRotateRight_STATUS", String.valueOf(isMapRotatedRight));
		}catch(Exception e){
			System.out.println(e);
		}
		return outputMap;
	}
	
	public HashMap<String, String> performKeyLegends(WebDriver driver, HashMap<String, String> dataMap) {
		try{
			Boolean isKeyLegendLoaded = false;
			performPrerequisites(driver, dataMap);
			isKeyLegendLoaded = mapPage.verifyKeyLegends();
			System.out.print(isKeyLegendLoaded);
			outputMap.put("KeyLegends_STATUS", String.valueOf(isKeyLegendLoaded));
		}catch(Exception e){
			System.out.println(e);
		}
		return outputMap;
	}


	public void acceptTermsDisplayed() {
		try{
			acceptEULATerms(); //This method handles EULA popup
			//loginPage.skipTutorial(); //This method handles Skip Tutorial popup
		}catch(Exception e){
			System.out.print("EULA and Skip turorial is not configured ");
		}
	}

	public void acceptEULATerms() {
		try{
			loginPage.acceptEULAChkBox();
			loginPage.acceptEULABtn();
		}catch(Exception e){
			System.out.print("no EULA popup displayed");
		}
	}

	public void performPrerequisites(WebDriver driver, HashMap<String, String> dataMap)  {
		try{
			System.out.println(dataMap);
			driver.get(dataMap.get("URL"));
			acceptTermsDisplayed();
			loginPage.clickStartingPoint();
			dirPage.enterStartingPoint(dataMap.get("STARTING_POINT"));
			Thread.sleep(5000);
			dirPage.ExpandIconPoint();
			dirPage.clickMapIt();
			dirPage.enterDestinationPoint(dataMap.get("DESTINATION_POINT"));
			//dirPage.selectParkingFromMenu();
			dirPage.ExpandIconPoint();
			dirPage.clickMapIt();	
		}catch(Exception e){
			System.out.println(e);
		}
	}

	public void validateResults(ExtentTest test, HashMap<String, String> outputMap) {
		System.out.println(outputMap);
		for (HashMap.Entry<String, String> entry : outputMap.entrySet()) {
			String key = entry.getKey();
			String value = entry.getValue();
			System.out.println(key +"||||"+value+"||||"+key.replace("_STATUS", "")+"||||"+test);
			new TestUtil().verifyText(value, "true", key.replace("_STATUS", "") +" LOAD VALIDATION", test);
		}	
	}
}


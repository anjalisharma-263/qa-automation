package businessLogic;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.purpleAdmin.qa.pages.Kiosk;
import com.purpleAdmin.qa.pages.KioskHomePage;
import com.purpleAdmin.qa.util.TestUtil;

public class KioskHomePageBL {
	KioskHomePage khp = new KioskHomePage();
	HashMap<String, String> outputMap = new HashMap<String, String>();
	ExtentTest extentTest = null;


	public HashMap<String , String> performKioskLoadWithSplashActions(WebDriver driver, HashMap<String, String> dataMap){
		String actualTitleMainMenu = "";
		System.out.println(dataMap);
		try{
		driver.get(dataMap.get("URL"));
		//Thread.sleep(15000);
		khp.clickBeginBtn();
		actualTitleMainMenu = khp.getTitleMainMenu();
		
		if(dataMap.get("CAMPUS_NAME").contains("Summahealth")){
		khp.clickSkipIntro();
		}
		outputMap.put("ACTUAL_TITLE_STATUS", String.valueOf(actualTitleMainMenu));
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return outputMap;
	}

	public HashMap<String , String> performKioskLoadWithoutSplashActions(WebDriver driver, HashMap<String, String> dataMap){
		String actualTitleMainMenu = "";
		System.out.println(dataMap);
		driver.get(dataMap.get("URL"));
		actualTitleMainMenu = khp.getTitleMainMenu();
		dataMap.put("ACTUAL_TITLE", actualTitleMainMenu);
		outputMap.put("ACTUAL_TITLE_STATUS", String.valueOf(actualTitleMainMenu));
		return dataMap;
	}
	
	public void validateResults(ExtentTest test, HashMap<String, String> outputMap) {
		System.out.println(outputMap);
		for (HashMap.Entry<String, String> entry : outputMap.entrySet()) {
			String key = entry.getKey();
			String value = entry.getValue();
			new TestUtil().verifyText(value, "true", key.replace("_STATUS", "") +" LOAD VALIDATION", test);
		}	
	}


}

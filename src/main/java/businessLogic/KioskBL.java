package businessLogic;

import java.util.HashMap;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.purpleAdmin.qa.pages.Kiosk;
import com.purpleAdmin.qa.util.TestUtil;

public class KioskBL {
	Kiosk kp = new Kiosk();
	HashMap<String, String> outputMap = new HashMap<String, String>();
	ExtentTest extentTest = null;


	public HashMap<String , String> performKioskWithSplashActions(WebDriver driver, HashMap<String, String> dataMap){
		String actualTitleMainMenu = "";
		String mapDisplayed = "";
		String directoryDispalyed = "";
		System.out.println(dataMap);
		try{
		driver.get(dataMap.get("URL"));
		Thread.sleep(15000);
		//driver.navigate().refresh();
		kp.clickBeginBtn();
		actualTitleMainMenu = kp.getTitleMainMenu();
		mapDisplayed = String.valueOf(kp.getMapFloor());
		directoryDispalyed = String.valueOf(kp.getDirectoryWithSplash());
		outputMap.put("ACTUAL_TITLE_STATUS", String.valueOf(actualTitleMainMenu));
		outputMap.put("MAP_VISIBLE_STATUS", String.valueOf(mapDisplayed));
		outputMap.put("DIRECTORY_VISIBLE_STATUS", String.valueOf(directoryDispalyed));
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return outputMap;
	}

	public void validateResults(ExtentTest test, HashMap<String, String> outputMap) {
		System.out.println(outputMap);
		for (HashMap.Entry<String, String> entry : outputMap.entrySet()) {
			String key = entry.getKey();
			String value = entry.getValue();
			new TestUtil().verifyText(value, "true", key.replace("_STATUS", "") +" LOAD VALIDATION", test);
		}	
	}

	public HashMap<String , String> performKioskWithoutSplashActions(WebDriver driver, HashMap<String, String> dataMap){
		String actualTitleMainMenu = "";
		System.out.println(dataMap);
		driver.get(dataMap.get("URL"));
		actualTitleMainMenu = kp.getTitleMainMenu();
		dataMap.put("ACTUAL_TITLE", actualTitleMainMenu);
		return dataMap;
	}
}

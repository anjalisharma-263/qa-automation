package businessLogic;

import java.util.HashMap;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import com.purpleAdmin.qa.pages.Kiosk;

public class KioskBL {
	Kiosk kp = new Kiosk();


	public HashMap<String , String> performKioskWithSplashActions(WebDriver driver, HashMap<String, String> dataMap){
		String actualTitleMainMenu = "";
		String mapDisplayed = "";
		String directoryDispalyed = "";
		System.out.println(dataMap);
		driver.get(dataMap.get("URL"));
		kp.clickBeginBtn();
		actualTitleMainMenu = kp.getTitleMainMenu();
		mapDisplayed = String.valueOf(kp.getMapFloor());
		directoryDispalyed = String.valueOf(kp.getDirectoryWithSplash());
		dataMap.put("ACTUAL_TITLE", actualTitleMainMenu);
		dataMap.put("MAP_VISIBLE", mapDisplayed);
		dataMap.put("DIRECTORY_VISIBLE", directoryDispalyed);
		return dataMap;
	}

	public void validateResults(HashMap<String, String> dataMap){
		Assert.assertEquals(dataMap.get("ACTUAL_TITLE"), dataMap.get("EXPECTED_TITLE"));
		Assert.assertEquals(dataMap.get("MAP_VISIBLE"), String.valueOf("true"));
		Assert.assertEquals(dataMap.get("DIRECTORY_VISIBLE"), String.valueOf("true") );
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

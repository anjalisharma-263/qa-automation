package businessLogic;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.purpleAdmin.qa.pages.Kiosk;
import com.purpleAdmin.qa.pages.KioskDirectoryPage;
import com.purpleAdmin.qa.pages.KioskHomePage;
import com.purpleAdmin.qa.util.TestUtil;

public class KioskDirectoryPageBL {
	KioskDirectoryPage kdp = new KioskDirectoryPage();
	KioskHomePage khp =new KioskHomePage();
	HashMap<String, String> outputMap = new HashMap<String, String>();
	ExtentTest extentTest = null;

	public void performKioskPrerequisites(WebDriver driver, HashMap<String, String> dataMap) {
		try {
			driver.get(dataMap.get("URL"));
		    Thread.sleep(15000);
			khp.clickBeginBtn();
			if (dataMap.get("CAMPUS_NAME").contains("Summahealth")) {
				khp.clickSkipIntro();
			} else {
				System.out.println("Intro Video Not Present");

			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public HashMap<String, String> performKioskDirectoryValidation(WebDriver driver, HashMap<String, String> dataMap) {
		performKioskPrerequisites(driver, dataMap);
		// System.out.println(dataMap.get("FromDirectoryMenu"));
		// System.out.println(dataMap.get("FromSubMenu1"));
		// System.out.println(dataMap.get("FromSubMenu2"));

		kdp.clickOnDirectoryMenuFrom(dataMap.get("FromDirectoryMenu"));
		kdp.clickOnDirectorySubMenuFrom(dataMap.get("FromSubMenu1"));
		kdp.clickOnDirectorySubMenu2From(dataMap.get("FromSubMenu2"));

		return outputMap;
	}

	public HashMap<String, String> performKioskLoadWithoutSplashActions(WebDriver driver,
			HashMap<String, String> dataMap) {
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
			new TestUtil().verifyText(value, "true", key.replace("_STATUS", "") + " LOAD VALIDATION", test);
		}
	}

}

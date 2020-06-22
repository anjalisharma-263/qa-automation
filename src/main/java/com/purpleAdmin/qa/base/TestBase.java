package com.purpleAdmin.qa.base;
//hello
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.aventstack.extentreports.ExtentReports;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;
import com.purpleAdmin.qa.util.TestUtil;
import com.purpleAdmin.qa.util.WebEventListener;
import com.qa.ExtentReportListener.ExtentManager;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	static String path = System.getProperty("user.dir");
	protected static ExtentReports extent;


	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("/Users/user/Downloads/PurpleAuto/PurpleAdminPortal/src/main/java/com/purpleAdmin/qa/config/config.properties");	
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@BeforeSuite
	public void setExtentReport() {
		extent = ExtentManager.getExtent(System.getProperty("user.dir") + "/src/main/resources/reports/WebLogin.html", "Web Automation",
				Platform.ANY.name());
	}

	public static void initialization() {
		String browserName = prop.getProperty("browser");

		if (browserName.equals("Chrome")) {
		System.setProperty("webdriver.chrome.driver",path+ "/src/main/resources/browserSetup/chromedrivernew");
		driver = new ChromeDriver();
		} /*else if (browserName.equals("FF")) {
			System.setProperty("webdriver.gecko.driver", "C://purple//Drivers//geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browserName.equals("IE")) {
			System.setProperty("webdriver.ie.driver", "C://purple//Drivers//IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}*/

		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;

		driver.manage().window().maximize();
		//driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

		//driver.get(prop.getProperty("url"));
	}

	//--------------//
	@DataProvider
	public Object[][] getData(Method testMethod) throws Exception {
		Object[][] hashMapObject = null;
		Class<?> subclass = testMethod.getDeclaringClass();
		String methodName = testMethod.getName();
		try {
			String dataSheet = subclass.getField("DETAIL_PAGE_DATA_SHEET").get(null).toString();
			String sheetName = subclass.getField("SHEET_NAME").get(null).toString();
			hashMapObject = getDataForDataProvider(dataSheet, sheetName, methodName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return hashMapObject;
	}


	public static Object[][] getDataForDataProvider(String dataSheet, String sheetName, String methodName) {
		List<HashMap<String, String>> arrayMapList = new ArrayList<HashMap<String, String>>();
		try {
			Fillo fillo = new Fillo();
			Connection connection = fillo.getConnection(dataSheet);
			String strQuery = "Select * from " + sheetName + " where TEST_CASE_NAME='" + methodName  + "'";
			System.out.print(strQuery);
			Recordset recordset = connection.executeQuery(strQuery);

			ArrayList<String> fieldsName = recordset.getFieldNames();
			while (recordset.next()) {
				HashMap<String, String> dataMap = new HashMap<String, String>();
				for (int j = 0; j < fieldsName.size(); j++) {
					String colName = fieldsName.get(j);
					String colValue = recordset.getField(colName);
					dataMap.put(colName, colValue);
				}
				arrayMapList.add(dataMap);
			}
			recordset.close();
			connection.close();
		} catch (Exception e) {
			System.out.println("NO DATA");
		}
		return getHashMapObject(arrayMapList);
	}

	public static Object[][] getHashMapObject(List<HashMap<String, String>> arrayMapList){
		Object[][] hashMapObject = new Object[arrayMapList.size()][1];
		for(int i = 0; i < arrayMapList.size() ; i++) {
			hashMapObject[i][0] = arrayMapList.get(i);
		}
		return hashMapObject;
	}
	@AfterSuite
	public void tearDown() {
		extent.flush();
	}
	}
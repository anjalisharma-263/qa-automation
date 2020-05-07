package com.purpleAdmin.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Demo {
	public static Properties prop;

	
	public Demo() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("/Users/user/Downloads/PurpleAuto/PurpleAdminPortal/src/main/java/com/purpleAdmin/qa/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(prop.getProperty("url"));
	}

	public static void main(String[] args) {
		
        Demo d=new Demo();

	}

}

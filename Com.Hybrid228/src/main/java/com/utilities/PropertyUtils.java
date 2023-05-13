package com.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyUtils {

	public static String readProperty(String key)throws Exception {
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/main/resources/config.properties");
		prop.load(fis);
		
		return prop.getProperty(key);
	}
	
	
}

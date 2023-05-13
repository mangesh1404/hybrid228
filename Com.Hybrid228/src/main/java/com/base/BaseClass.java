package com.base;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.utilities.PropertyUtils;

public class BaseClass {

	public static WebDriver driver =null;
	public static ExtentReports report= null;
	public static ExtentSparkReporter spark=null;
	public static ExtentTest test=null;
	
	Logger log = Logger.getLogger(BaseClass.class);
	
	public void initialization()throws Exception {
		
		System.out.println("Reading property file for browser");// console
		log.info("Reading property file for browser");// file 
		
		String browserName= PropertyUtils.readProperty("browser");
		
		if(browserName.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "D:/chromedriver.exe");
			driver= new ChromeDriver();
		}
		if(browserName.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "D:/geckodriver.exe");
			driver= new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.get(PropertyUtils.readProperty("url"));
		
	}
	
	public void reportInit() {
		report = new ExtentReports();
		spark = new ExtentSparkReporter(System.getProperty("user.dir")+"/target/ExtentReports.html");
		report.attachReporter(spark);
	}
	
}

package com.company.project.BaseClasses;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumBaseClass {
	
	public static  WebDriver setUp()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\George\\Documents\\Meera Work\\chromedriver\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.kayak.com/");
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		return driver;
		
	}
	
	public static void tearDown(WebDriver driver)
	{
		driver.close();
	}
	
	public static String getPropertiesValue(String key)
	{
		String value= null;
		try
		{
		File f= new File("src\\main\\java\\com\\company\\project\\resource\\QaEnvironment.properties");
		
		Properties prop=new Properties();
		FileInputStream fs= new FileInputStream(f.getAbsoluteFile());
		prop.load(fs);
		value=prop.getProperty(key);

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return value;
	}
	

}

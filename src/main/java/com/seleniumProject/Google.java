package com.seleniumProject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Google {

	public static void main(String[] args) {
		System.setProperty("webdriver.ie.driver", "C:\\Drivers\\IEDriverServer.exe");
		WebDriver driver=new InternetExplorerDriver();
		
//		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
//		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	    
	   		 
		driver.get("https://www.google.com/#spf=1635167671733");	
		driver.findElement(By.name("q")).sendKeys("Selenium");
	}

}

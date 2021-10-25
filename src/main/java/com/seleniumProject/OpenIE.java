package com.seleniumProject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class OpenIE {

	public static void main(String[] args) {
		System.setProperty("webdriver.ie.driver", "C:\\Drivers\\IEDriverServer.exe");
		WebDriver driver=new InternetExplorerDriver();
		
		driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	    
		driver.get("http://10.138.108.44/MCKWFX5TEST/Main.aspx");
	}

}

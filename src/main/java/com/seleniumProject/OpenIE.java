package com.seleniumProject;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;

public class OpenIE {
	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		navigateToURL();
		login("nas.csa", "fx5test");
		
		driver.findElement(By.cssSelector("td.menuNavigateIcon")).click();
		
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@id='mainMenuItemVertical_Manifest']//a[text()='Cargo']")).click();


//		
//		WebElement cargoMenu=driver.findElement(By.xpath("//div[@id='mainMenuItemVertical_Manifest']//a[text()='Cargo']"));
//		
//		Actions myAction= new Actions(driver);
//		
//	
//		myAction.moveToElement(cargoMenu).perform();
		
//		WebElement manifestSubMenu=driver.findElement(By.linkText("Manifest"));
//		
//		myAction.moveToElement(manifestSubMenu).click().build().perform();
		
	}

	public static void navigateToURL() {
		System.setProperty("webdriver.ie.driver", "C:\\Drivers\\IEDriverServer.exe");
		driver = new InternetExplorerDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("http://10.138.108.44/MCKWFX5TEST/Main.aspx");
		System.out.println(driver.getTitle());

		String MainWindow = driver.getWindowHandle();
		
		Set<String> s1 = driver.getWindowHandles();
		Iterator<String> i1 = s1.iterator();

		while (i1.hasNext()) {
			String ChildWindow = i1.next();
			
			if (!MainWindow.equalsIgnoreCase(ChildWindow)) {
				// Switching to Child window
				driver.switchTo().window(ChildWindow);

			}

		}
	}

	public static void login(String Id, String Password) {
		driver.findElement(By.cssSelector("input.FX50loginPanelTextBox")).sendKeys(Id);

		driver.findElement(By.cssSelector("input#sUserPassword")).sendKeys(Password);

		driver.findElement(By.cssSelector("input.FX50loginPanelLoginButton")).click();
		driver.switchTo().alert().accept();
		driver.switchTo().alert().accept();

	}
}

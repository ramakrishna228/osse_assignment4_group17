package com.vm.SeAutomationTraining;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleShadowRootOnWeb {
	public WebDriver driver;
	
	@BeforeTest
	public void startSession() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
	}
	
	@AfterTest
	public void killSession() {
		driver.quit();
	}
	
	@Test
	public void testBasicAuth() throws InterruptedException {
		
		driver.get("https://books-pwakit.appspot.com/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		

		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		// find the base element of first shadowroot
		WebElement shadowRootElement = driver.findElement(By.tagName("book-app"));
		// cast the base element to JSE
		WebElement shadown0 = (WebElement)js.executeScript("return arguments[0].shadowRoot", shadowRootElement);
		
		// find 2nd shadow base using 1st shadowroot
		WebElement shadow1 = shadown0.findElement(By.tagName("app-header"));
		WebElement shadow2 = shadow1.findElement(By.cssSelector(".toolbar-bottom"));
		WebElement shadow3 = shadow2.findElement(By.tagName("book-input-decorator"));
		shadow3.findElement(By.cssSelector("#input")).sendKeys("ShadowRoot Testing");
		
	}


}

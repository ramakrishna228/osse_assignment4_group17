package com.vm.SeAutomationTraining;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ElementBackendValue {
	WebDriver driver;
	@Test
	public void webElementValues() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("https://www.myntra.com/men-tshirts");
		
		WebElement nextButton = driver.findElement(By.xpath("//a[normalize-space()='Next']"));
		
		System.out.println("loginButton === " + nextButton);
		nextButton.click();
		
		String pageNumber = driver.findElement(By.cssSelector(".pagination-active > a")).getText();
		System.out.println("pageNumber == " + pageNumber);
//		driver.navigate().refresh();
//		Thread.sleep(5000);
//		WebElement loginButton1 = driver.findElement(By.cssSelector("input[value='Log In']"));
//		System.out.println("loginButton === " + loginButton1);
		nextButton.click();
		
		String pageNumber1 = driver.findElement(By.cssSelector(".pagination-active > a")).getText();
		System.out.println("pageNumber == " + pageNumber1);
		
		nextButton.click();
//		driver.navigate().back();
//		
//		driver.navigate().forward();
		
		
		driver.quit();
	}
	
	

}

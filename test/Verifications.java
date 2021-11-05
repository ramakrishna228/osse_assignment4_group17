package com.vm.SeAutomationTraining;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Verifications  extends LaunchApplication{

	//@Test
	public void verifications() {
		driver.findElement(By.xpath("//input[@value='Log In']")).click();
		
		WebElement logInButton = driver.findElement(By.xpath("//input[@value='Log I']"));
		boolean value = logInButton.isDisplayed();
		
		System.out.println("value ==== " + value);
	}
	
	@Test
	public void isSelectedCheckBox() {
		driver.get("https://www.salesforce.com/in/form/signup/freetrial-sales/?d=topnav2-btn-ft");
		jsE(driver.findElement(By.xpath("//a[text()='Master Subscription Agreement']/parent::*/../input")));
		
		boolean selected = driver.findElement(By.xpath("//a[text()='Master Subscription Agreement']/parent::*/../input")).isSelected();
				
				System.out.println("selected === " + selected);
	}
	
	public void jsE(WebElement element) {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click()", element);
	}
}

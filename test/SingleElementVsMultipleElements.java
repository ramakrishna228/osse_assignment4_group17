package com.vm.SeAutomationTraining;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SingleElementVsMultipleElements extends LaunchApplication{

	@Test
	public void verifyMultipleElements() throws InterruptedException {
		//driver.navigate().to("http://the-internet.herokuapp.com/add_remove_elements/");
		driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
		WebElement singleButton = driver.findElement(By.xpath("//*[@onclick='addElement()']"));
		
		
		System.out.println("singleButton ========" + singleButton);
		System.out.println("Number of Add/Remove ELement ====== " + singleButton.getSize());
		
		for(int i=0; i<5; i++) {
			Thread.sleep(1000);
			singleButton.click();
		}
		
		List<WebElement> deleteButtons = driver.findElements(By.xpath("//*[@onclick='deleteElement()']"));
		
		
		System.out.println("deleteButtons ========== " + deleteButtons);
		System.out.println("Number of Delete button ELement ====== " + deleteButtons.size());
		
		Assert.assertEquals(deleteButtons.size(), 5);
		
		driver.navigate().refresh();
		WebElement addButton = driver.findElement(By.xpath("//*[@onclick='addElement()']"));
		
		for(int i=0; i<5; i++) {
			Thread.sleep(1000);
			//singleButton.click();
			addButton.click();
			
		}
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.stalenessOf(singleButton));
		
		//List<WebElement> deleteButton = driver.findElements(By.xpath("//*[@onclick='deleteElement()']"));
		
		for(int i=0; i<deleteButtons.size(); i++) {
			Thread.sleep(1000);
			deleteButtons.get(i).click();
		}
		
		
	}
	
	
	//@Test
	public void verifyNavigations() throws InterruptedException {
		driver.get("http://the-internet.herokuapp.com/");
		driver.findElement(By.xpath("//*[@href='/abtest']")).click();
		
		Thread.sleep(3000);
		
		driver.navigate().back();
		Assert.assertEquals("The Internet", driver.getTitle());
		
		driver.navigate().forward();
		
		Assert.assertTrue(driver.findElement(By.cssSelector(".example")).isDisplayed());
		
		driver.navigate().refresh();
		
		
		
	}
}

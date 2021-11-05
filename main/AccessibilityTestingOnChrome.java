package com.vm.SeAutomationTraining;

import java.io.File;
import java.io.FileWriter;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AccessibilityTestingOnChrome {
	WebDriver driver;
	@Test
	public void allyTesting() throws Exception {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://192.168.1.5:8080/src/html/");

		 JavascriptExecutor jse = (JavascriptExecutor)driver;
		 Path path = Paths.get(System.getProperty("user.dir")+ "/cdnjs/axe.min.js");

		 String content = new String(Files.readAllBytes(path));
		 jse.executeScript(content);

		 File output = new File(System.getProperty("user.dir")+"/accessibilityReport.json");
		 FileWriter writer = new FileWriter(output);
		 String result = (String) jse.executeScript("let result; await axe.run().then((r)=> {result=r}); return JSON.stringify(result);");
		 writer.write(result);
		 writer.flush();
		 writer.close();
		 driver.quit();
	}
}

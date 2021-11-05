package com.vm.SeAutomationTraining;

import java.io.File;
import java.io.FileWriter;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class AccessibilityTesting {
	public static final String AUTOMATE_USERNAME = "siva266";
	public static final String AUTOMATE_ACCESS_KEY = "7Wfwz8qNKAn9X4XyNTXE";
	public static final String URL = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";
	
	@Test
	public void allyTesting() throws Exception {
		 DesiredCapabilities caps = new DesiredCapabilities();
		 caps.setCapability("os_version", "10");
		 caps.setCapability("browser", "chrome");
		 caps.setCapability("browser_version", "latest");
		 caps.setCapability("os", "Windows");
		 caps.setCapability("name", "Accessibility Test - Google"); // test name
		 caps.setCapability("build", "Accessibility Test on HeroKU Build"); // CI/CD job or build name
		 WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
		 driver.get("http://the-internet.herokuapp.com/");

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

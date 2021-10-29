package com.testing;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestSuiteSetup {
	
	WebDriver driver;
	public String baseUrl = "https://www.google.com/";
	String driverPath = System.getProperty("user.dir")+"/drivers/chromedriver.exe";
	

	@BeforeSuite(alwaysRun = true)
	public void setupSuite() {
		System.out.println("This is BeforeSuite annotation method  in TestSuiteSetup Class");

		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
	}

	@AfterSuite(alwaysRun = true)
	public void tearDown() {
		System.out.println("This is AfterSuite annotation method  in TestSuiteSetup Class");

		driver.close();
	}

	@BeforeClass(description = "Set capabilities for your Chrome browser and set time it should wait for a page to load.")
	public void chromeSetUp(){
		//System.setProperty("webdriver.chrome.driver", driverPath);
		//driver = new ChromeDriver();
		System.out.println("This is BeforeClass annotation method  in TestSuiteSetup Class");

		driver.manage().window().setSize(new Dimension(1920, 1080));
		driver.navigate().to("http://facebook.com");

	}

	@AfterClass(description = "close your chrome driver")
	public void afterclass() {
		System.out.println("This is AfterClass  annotation method  in TestSuiteSetup Class");

		driver.close();
	}

	@BeforeTest(description = "set your chrome profile preferences according to your project requirement")
	public void single_run() {
		//driver = new ChromeDriver();
		System.out.println("This is BeforeTest annotation method  in TestSuiteSetup Class");

		String url1 = "http://www.gmail.com";
		driver.get(url1);
	}
	
	@Test
	public void testCase1() {
		System.out.println("This is my First Test Case in TestSuiteSetup Class");
	}


	@AfterTest(description = "")
	public void closeDriver() {
		System.out.println("This is AfterTest annotation method  in TestSuiteSetup Class");
		//driver.close();
	}

}
package com.testing;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class TestSuiteSetup {
	WebDriver driver;

	@BeforeSuite(alwaysRun = true)
	public void setupSuite() {
		driver = new FirefoxDriver();
	}

	@AfterSuite(alwaysRun = true)
	public void tearDown() {
		driver.close();
	}

	@BeforeClass(description = "Set capabilities for your Firefox browser and set time it should wait for a page to load.")
	public void firefoxSetUp() throws MalformedURLException {

		// DesiredCapabilities capability = new DesiredCapabilities..firefox();
		driver = new ChromeDriver();
		// driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().window().setSize(new Dimension(1920, 1080));

	}

	@AfterClass(description = "close your firefox driver")
	public void afterclass() {
		driver.close();
	}

	@BeforeTest(description = "set your firefox profile preferences according to your project requirement")
	public void single_run() {
		FirefoxProfile firefoxProfile = new FirefoxProfile();
		firefoxProfile.setPreference("browser.download.folderList", 2);
		firefoxProfile.setPreference("browser.download.manager.showWhenStarting", false);
		firefoxProfile.setPreference("browser.download.dir", "E:\\reports\\");
		firefoxProfile.setPreference("browser.helperApps.neverAsk.saveToDisk", "csv");
		driver = new FirefoxDriver();
		String baseUrl = "www.gmail.com";
	}

	@AfterTest(description = "")
	public void teardown() {
		// a code which will send the test details report
	}

}
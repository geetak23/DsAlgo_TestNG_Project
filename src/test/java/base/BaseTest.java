package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import driver.BrowserFactory;
import driver.DriverFactory;
import report.ExtentFactory;
import utilities.ConfigLoader;
//import utilities.LoggerLoad;
import utilities.TestDataLoader;

public class BaseTest {

	@BeforeSuite
	public void setUP() {

		WebDriver driver = BrowserFactory.createBrowserInstance(ConfigLoader.getInstnace().getPropertyValue("browser"));

		DriverFactory.getInstance().setDriver(driver);
		
		DriverFactory.getInstance().getDriver().get(TestDataLoader.getInstance().getAppUrl());

	}

	@AfterSuite
	public void tearDown() {
		System.out.println("In Teardown");
		DriverFactory.getInstance().getDriver().quit();
	}
	public void reportLogProcess(String message)
	{
		ExtentFactory.getInstance().passTest(message);
    	//LoggerLoad.info(message);
	}
	
}

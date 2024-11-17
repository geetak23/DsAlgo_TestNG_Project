package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import driver.BrowserFactory;
import driver.DriverFactory;
import pageObjects.SignInPage;
import report.ExtentFactory;
import utilities.ConfigLoader;
//import utilities.LoggerLoad;
import utilities.TestDataLoader;

public class BaseTest {

	@Parameters("browser")
	@BeforeTest
	public void setUP(@Optional("chrome") String browser) 
	{
		if(browser.trim()=="")
			browser = ConfigLoader.getInstnace().getPropertyValue("browser");
		WebDriver driver = BrowserFactory.createBrowserInstance(browser);
		System.out.println("In broswer"+browser);
		DriverFactory.getInstance().setDriver(driver);		
		DriverFactory.getInstance().getDriver().get(TestDataLoader.getInstance().getAppUrl());
		DriverFactory.getInstance().getDriver().manage().deleteAllCookies();	
		DriverFactory.getInstance().getDriver().manage().window().maximize();
	}

	@AfterTest
	public void tearDown() {
		System.out.println("In Teardown");
		DriverFactory.getInstance().getDriver().quit();
	}
	
	public void logIntoDsPortal()
	{		
		System.out.println("userSignIn");
		SignInPage signIn = new SignInPage();
		signIn.openSignInPage();
		signIn.signinpage(TestDataLoader.getInstance().getUserName(), TestDataLoader.getInstance().getPassword());	
		
	}
	
}

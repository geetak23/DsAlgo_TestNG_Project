package pageTestEvents;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import driver.DriverFactory;
import pageObjects.LandingPage;
import utilities.TestDataLoader;

public class LandingPageEvents extends BaseTest {

	private boolean chktestHomePageTitle = false;
	LandingPage landingPage;
	String pageTitle;

	@BeforeClass
	public void openLandingPage()
	{
		landingPage = new LandingPage();
		System.out.println("before method");
	}

	@Test(priority = 1)
	public void testHomePageTitle() {
		System.out.println("LandingPageEvents : test1");
		pageTitle = landingPage.getPageTitle();
		Assert.assertEquals(pageTitle, "Numpy Ninja", "Page title does not match!");
	}

	@Test(priority = 2)
	public void getStartedBtn() 
	{		
		System.out.println("test2");
		chktestHomePageTitle = true;
		landingPage.clickGetStarted();		 
	}
	@AfterClass
	public void checknav_dsportal() 
	{
		if(chktestHomePageTitle == true)
		{
			System.out.println("after method");
			boolean isAtDashboard = landingPage.isAtDashboard("https://dsportalapp.herokuapp.com/home");
			Assert.assertTrue(isAtDashboard, "User is not on the expected DS Algo dashboard");
			Assert.assertEquals(landingPage.getPageTitle(), "NumpyNinja");
		}
		return;
	}
}

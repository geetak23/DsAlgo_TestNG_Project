package pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import driver.DriverFactory;
import report.ExtentFactory;
import utilities.LoggerLoad;

public class LandingPage{
	private WebDriver driver;

	    // Locator for the "Get Started" button		
		
	    private By getStartedButton = By.xpath("//button[text()='Get Started']");

	    // Constructor to initialize the WebDriver
	    public LandingPage() 
	    {	    	
	    	System.out.println("LandingPage Initializing");
	    	//PageFactory.initElements(DriverFactory.getInstance().getDriver(), driver);
	    	driver = DriverFactory.getInstance().getDriver();
	    	//ExtentFactory.getInstance().passTest("LandingPage Initializing");
	    	LoggerLoad.info("LandingPage Initializing");
	    }

	    // Method to click on the "Get Started" button
	    public void clickGetStarted() {
	    	System.out.println("clickGetStarted");
	        driver.findElement(getStartedButton).click();
	    }

	    // Method to verify the current URL
	    public boolean isAtDashboard(String expectedUrl) {
	    	System.out.println("isAtDashboard");
	        return driver.getCurrentUrl().equals(expectedUrl);
	    }

	    // Method to navigate to the home page
	    public void golandingPage() {
	        driver.get("https://dsportalapp.herokuapp.com");
	    }
	    public String getPageTitle() {
	    	System.out.println("getPageTitle");
	        return driver.getTitle();
	    }
}

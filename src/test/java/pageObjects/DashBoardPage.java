package pageObjects;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import driver.DriverFactory;

public class DashBoardPage{
	 // Locators for home page elements

	By dsDropDown=By.xpath(("//a[text()='Data Structures']"));
	By errorMsg=By.xpath(("//div[@class='alert alert-primary']"));
	By registerLink=By.xpath(("//a[contains(text(),' Register ')]"));
	By loginLink=By.xpath(("//a[contains(text(),'Sign in')]"));
	
	By menuList=By.xpath(("//div[@class='dropdown-menu show']//a[@class='dropdown-item']"));
	By dsGetStartBtn=By.xpath("//a[contains(text(),'Get Started')]");
	By dropdownitemslist=By.xpath("//div[@class='dropdown-menu show']");
	
	By signOutbtn=By.xpath("//a[text()='Sign out']");
	
	private WebDriver driver;

	public DashBoardPage() {
		//PageFactory.initElements(driver, this);
		//this.driver = driver;
		driver = DriverFactory.getInstance().getDriver();
	}
	
	// Open home page
    public void openDashBoardPage() {
        driver.get("https://dsportalapp.herokuapp.com/home");
    }

    // Get page title
    public String getPageTitle() {
        return driver.getTitle();
    }

    // Get current URL
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
   // Click on a link based on text
    public void clickOnLink(String linkText) {
        driver.findElement(By.linkText(linkText)).click();
    }
    // Method to verify the current URL
    public boolean isSignInPage(String expectedUrl) {
        return driver.getCurrentUrl().equals(expectedUrl);
    }
    public void clickDropDown() {
    	driver.findElement(dsDropDown).click();
    }
     
    public void GetStartBtnList(int index){
 		List<WebElement> getbtnListIP= driver.findElements(dsGetStartBtn);
 		getbtnListIP.get(index).click();	
 	}
    
    public int getTotaldropDownOptions() {
    	driver.findElement(dsDropDown).click();
    	List<WebElement> list = driver.findElements(By.className("dropdown-item")); 
    	System.out.println("size items:"+ list.size());
    	return list.size();
    }
    public int getStartBtnList(){
 		List<WebElement> getbtnListIP= driver.findElements(dsGetStartBtn);
 		return getbtnListIP.size();
 	}
 	  
    public void clickDropdownitem(int i){
    	driver.findElement(dsDropDown).click();
    	List<WebElement> list = driver.findElements(By.className("dropdown-item")); 
    	if (list.size() > 0) {    	
    		System.out.println(list.get(i).getText()+" : webelement selected");
    	    //list.get(i).click();
    	} else {
    	    System.out.println("The dropdown does not contain enough items.");
    	}
     }

    public String errorMessage()
    {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1000));
    	wait.until(ExpectedConditions.presenceOfElementLocated(errorMsg)); 
    	return driver.findElement(dsGetStartBtn).getText();
    }
     
    public void clickRegisterLink(){
    	driver.findElement(registerLink).click();
    }
    
    public void registerPage(){
    	 System.out.println("User is on Register Page with Login at the bottom of the page");
    }
    
    public void clickSignInPage(){
    	driver.findElement(loginLink).click();
    }

    public void loginLinkPage(){
    	 System.out.println("User is on SignIn Page with Register link at the bottom of the page");
    }
    public void signoutBtn() {
  		driver.findElement(signOutbtn).click();
  	}
}

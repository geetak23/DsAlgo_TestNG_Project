package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import driver.DriverFactory;

public class SignInPage 
{
	 By start = By.xpath("//button[@class='btn']");
	 By SignInButton = By.linkText("Sign in");
	 By UserNameText= By.id("id_username");
	 By PassWord= By.id("id_password");
	 By LoginButton = By.xpath("//input[@value='Login']");
	 By ErrorMsg = By.xpath("//div[contains(text(),'Invalid Username and Password')]");
	 By register = By.linkText(" Register!");
	 
	 WebDriver driver;
	 public SignInPage() 
	 {
		 //PageFactory.initElements(DriverFactory.getInstance().getDriver(), this.driver);
		 this.driver = DriverFactory.getInstance().getDriver();  
	 }
	
	 public void openSignInPage()
	 {
		 driver.get("https://dsportalapp.herokuapp.com/login");
	 }
	
	 public String getSignInPageTitle()
	 {
		 return driver.getTitle();
	 }
	 public void checkresgisterlink()
	 {
		 
	 }
	 public void enteruserName(String userName) {
		System.out.println("User : " + userName);
		driver.findElement(UserNameText).sendKeys(userName);
	 }

	 public void enterpwd(String pwd) {
		System.out.println("Password : " + pwd);
		driver.findElement(PassWord).sendKeys(pwd);
	 }

	 public void clickonSignIn() {
		 driver.findElement(LoginButton).click();
	 }

	public String LoginBtnError() 
	{
		String errormsg = driver.findElement(ErrorMsg).getText();
		System.out.println("Expected message " + errormsg);
		return errormsg;
	}
	 
	 public WebDriver signinpage(String UserName,String Password)
	 {
		 System.out.print("In SignIn page");	
		 driver.findElement(UserNameText).sendKeys(UserName);
		 driver.findElement(PassWord).sendKeys(Password);
		 driver.findElement(LoginButton).click();
	    System.out.print("Landed on Main page");	
	    return driver;//DriverFactory.getInstance().getDriver(); 
	 }

	 public void navigateToDashBoard()
	 {
		 driver.get("https://dsportalapp.herokuapp.com/home");
	 }
}
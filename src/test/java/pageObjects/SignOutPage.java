package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import driver.DriverFactory;



public class SignOutPage {
	By dropDownArray=By.linkText("Arrays");
	By dropDownLinkedList=By.linkText("Linked List");
	By dropDownStack=By.linkText("Stack");
	By dropDownQueue=By.linkText("Queue");
	By dropDownTree=By.linkText("Tree");
	By dropDownGraph= By.linkText("Graph");
	By dropDownbtn=By.xpath("//a[@class='nav-link dropdown-toggle']");
	By userName = By.id("id_username");
	By passWord = By.id("id_password");
	By loginBtn =By.xpath("//input[@value='Login']");
	By SigninBtn= By.linkText("Sign in");
	By signOutBtn=By.linkText("Sign out");
	
private WebDriver driver;
	
	
	public  SignOutPage() {
		this.driver =  DriverFactory.getInstance().getDriver();
	}
	
	public void goSigninPage() {
		driver.get("https://dsportalapp.herokuapp.com/login");
	}
	public void goHomePage() {
		driver.get("https://dsportalapp.herokuapp.com/home");
	}
	public void enterUserName(String UserName) {
		driver.findElement(userName).sendKeys(UserName);

	}
	public void enterPassWord(String PassWord) {
		driver.findElement(passWord).sendKeys(PassWord);
	}
	public void signIn() {

		//Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50) );
		wait.until(ExpectedConditions.visibilityOfElementLocated(loginBtn));
		driver.findElement(loginBtn).click();
	}
	public String getPageTitle() {
		return driver.getTitle();
	}
	public void driverBack() {
		driver.navigate().back();
	}
	public void signOut() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50) );
		wait.until(ExpectedConditions.visibilityOfElementLocated(signOutBtn));
		driver.findElement(signOutBtn).click();
	}
	public void validatesignOut() {
		driver.getPageSource().contains("Logged out successfully");
		
		
	}
	public void arrayPage() {
		driver.findElement(dropDownbtn).click();
		driver.findElement(dropDownArray).click();
	}
	public void linkedListPage() {
		driver.findElement(dropDownbtn).click();
		driver.findElement(dropDownLinkedList).click();
	}
	public void stackPage() {
		driver.findElement(dropDownbtn).click();
		driver.findElement(dropDownStack).click();
	}
	public void queuePage() {
		driver.findElement(dropDownbtn).click();
		driver.findElement(dropDownQueue).click();
	}
	public void treePage() {
		driver.findElement(dropDownbtn).click();
		driver.findElement(dropDownTree).click();
	}
	public void graphPage() {
		driver.findElement(dropDownbtn).click();
		driver.findElement(dropDownGraph).click();
	}

}

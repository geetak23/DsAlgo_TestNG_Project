package pageObjects;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import driver.DriverFactory;



public class LinkedListPage {
	By dropDownArray=By.linkText("Arrays");
	By dropDownLinkedList=By.linkText("Linked List");
	By dropDownStack=By.linkText("Stack");
	By dropDownQueue=By.linkText("Queue");
	By dropDownTree=By.linkText("Tree");
	By dropDownGraph= By.linkText("Graph");
	By dropDownbtn=By.xpath("//a[@class='nav-link dropdown-toggle']");
	By GetStartedQueue =By.xpath("//a[@href='queue']");
	By userName = By.id("id_username");
	By passWord = By.id("id_password");
	By loginBtn =By.xpath("//input[@value='Login']");
	By SigninBtn= By.linkText("Sign in");
	By signOutBtn=By.linkText("Sign out");
	By tryHere=By.linkText("Try here>>>");
	By practiceQuestion=By.linkText("Practice Questions");
	By codeBox=By.xpath("//form[@id='answer_form']/div/div/div/textarea");
	By runBtn=By.xpath("//button[@type='button']");
	By consoleOutput=By.id("output");
	By Topic1=By.linkText("Introduction");
	By Topic2=By.linkText("Creating Linked LIst");
	By Topic3=By.linkText("Types of Linked List");
	By Topic4=By.linkText("Implement Linked List in Python");
	By Topic5=By.linkText("Traversal");
	By Topic6=By.linkText("Insertion");
	By Topic7=By.linkText("Deletion");



	private WebDriver driver;


	public LinkedListPage() {
		this.driver =  DriverFactory.getInstance().getDriver();
	}


	public void openLinkedListPage() {

		driver.findElement(dropDownbtn).click();
		driver.findElement(dropDownLinkedList).click();

	}


	public void Topic(int index){
		List<WebElement> Topic =driver.findElements(By.className("list-group-item"));
		Topic.get(index).click();
		String topic=driver.getTitle();
		System.out.println("We are in "+topic);
	}
	public void goSigninPage() {
		driver.get("https://dsportalapp.herokuapp.com/login");
	}
	public void enterUserName(String UserName) {
		driver.findElement(userName).sendKeys(UserName);

	}
	public void goHomePage() {
		driver.get("https://dsportalapp.herokuapp.com/home");
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
	public String getPageURL() {
		return driver.getCurrentUrl();
	}
	public void driverBack() {
		driver.navigate().back();
	}
	public void backToLinkedList() {
		driver.findElement(dropDownbtn).click();
		driver.findElement(dropDownLinkedList).click();

	}
	public void tryHere() {
		driver.findElement(tryHere).click();
	}
public void codeEnter(String Code) {
		
		driver.findElement(codeBox).sendKeys(Code);

	}
	public void clearCode() {
		driver.findElement(codeBox).clear();
	}
	
	public void clickRun() {
		driver.findElement(runBtn).click();
	}
	public String consoleOutput() {
		return driver.findElement(consoleOutput).getText();
	}
	public void signOut() {
		driver.findElement(signOutBtn).click();
	}
	public void explicitWaitAlert() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50) );
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert =driver.switchTo().alert();
		
		alert.accept();
		
	}
	public void arrayPage() {
		driver.findElement(dropDownbtn).click();
		driver.findElement(dropDownArray).click();
	}
	public void linkedListPageDrop() {
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
	public void practiceQuestion() {
		driver.findElement(practiceQuestion).click();
	}
}

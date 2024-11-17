package pageObjects;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import driver.DriverFactory;
public class QueuePage {
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
	By ImplementationofQueueinPythonTopic= By.linkText("Implementation of Queue in Python");
	By ImplementationusingcollectionsdequeTopic= By.linkText("Implementation using collections.deque");
	By ImplementationusingarrayTopic= By.linkText("Implementation using array");
	By QueueOperationsTopic= By.linkText("Queue Operations");
	//By ValidatePractice= By.xpath("");

	private WebDriver driver;


	public QueuePage() {
		this.driver =  DriverFactory.getInstance().getDriver();
	}

	public void goHomePage() {
		driver.get("https://dsportalapp.herokuapp.com/home");
	}
	public void goSigninPage() {
		driver.get("https://dsportalapp.herokuapp.com/login");
	}
	public void enterUserName(String UserName) {
		driver.findElement(userName).sendKeys(UserName);

	}
	public void enterPassWord(String PassWord) {
		driver.findElement(passWord).sendKeys(PassWord);
	}
	public void signIn() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50) );
		wait.until(ExpectedConditions.visibilityOfElementLocated(loginBtn));
		driver.findElement(loginBtn).click();
	}

	public void openQueuePage() {
		driver.findElement(dropDownbtn).click();
		driver.findElement(dropDownQueue).click();
	}
	public void implementationofQueueinPythonTopic() {
		driver.findElement(ImplementationofQueueinPythonTopic).click();
	}

	public void implementationusingcollectionsdequeTopic() {
		driver.findElement(ImplementationusingcollectionsdequeTopic).click();
	}

	public void implementationusingarrayTopic() {
		driver.findElement(ImplementationusingarrayTopic).click();
	}

	public void queueOperationsTopic() {
		driver.findElement(QueueOperationsTopic).click();
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
	public void backToQueue() {
		driver.findElement(dropDownbtn).click();
		driver.findElement(dropDownQueue).click();

	}
	public void tryHere() {
		driver.findElement(tryHere).click();
	}
	public void codeEnter(String Code) {

		//driver.findElement(codeBox).sendKeys(Code);
		WebElement activeElement = driver.switchTo().activeElement();
		Actions action = new Actions(driver);
		action.moveToElement(activeElement).click().perform();
		activeElement.sendKeys(Code);

	}
	public void clearCode() {
		driver.findElement(codeBox).clear();
	}
	public void alerAccept() throws InterruptedException {
		//WebDriver wait = new WebDriver(driver,java.time.Du

		//((Wait<WebDriver>) wait).until(ExpectedConditions.alertIsPresent());

		Alert alert =driver.switchTo().alert();
		//Thread.sleep(2000);
		alert.accept();

	}
	public void clickRun() {
		driver.findElement(runBtn).click();
	}
	public String consoleOutput() {
		return driver.findElement(consoleOutput).getText();
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
	public void queuePageDrop() {
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
	public void signOut() {
		driver.findElement(signOutBtn).click();
	}
	public String validatePractice() {


		return driver.getTitle();
	}
	public void explicitWait() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50) );
		wait.until(ExpectedConditions.visibilityOfElementLocated(codeBox));
	}
}

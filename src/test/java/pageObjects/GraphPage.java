package pageObjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;

import driver.DriverFactory;

import java.time.Duration;
import java.util.List;


public class GraphPage {




	By userName = By.id("id_username");
	By passWord = By.id("id_password");
	By loginBtn =By.xpath("//input[@value='Login']");
	By GraphTopic=By.linkText("Graph");
	By GraphRepresentationTopic=By.linkText("Graph Representations");
	By SigninBtn= By.linkText("Sign in");
	By dropDownbtn=By.xpath("//a[@class='nav-link dropdown-toggle']");
	By GetStartedGraph =By.xpath("//a[@href='graph']");
	By dropDownGraph= By.linkText("Graph");
	By signOutBtn=By.linkText("Sign out");
	By tryHere=By.linkText("Try here>>>");
	By practiceQuestion=By.linkText("Practice Questions");
	By codeBox=By.xpath("//form[@id='answer_form']/div/div/div/textarea");
	By runBtn=By.xpath("//button[@type='button']");
	By consoleOutput=By.id("output");
	By dropDownArray=By.linkText("Arrays");
	By dropDownLinkedList=By.linkText("Linked List");
	By dropDownStack=By.linkText("Stack");
	By dropDownQueue=By.linkText("Queue");
	By dropDownTree=By.linkText("Tree");
	
	

	private WebDriver driver;
	
	public GraphPage() {
		this.driver =  DriverFactory.getInstance().getDriver();
	}

	public void signIn() {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50) );
		wait.until(ExpectedConditions.visibilityOfElementLocated(loginBtn));
		driver.findElement(loginBtn).click();
	}
	public void enterUserName(String UserName) {
		driver.findElement(userName).sendKeys(UserName);

	}
	public void enterPassWord(String PassWord) {
		driver.findElement(passWord).sendKeys(PassWord);
	}
public void goHomePage() {
driver.get("https://dsportalapp.herokuapp.com/home");
}
	public void goSigninPage() {
		driver.get("https://dsportalapp.herokuapp.com/login");
	}

	public void openGraphPage() {
		driver.findElement(dropDownbtn).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50) );
		wait.until(ExpectedConditions.visibilityOfElementLocated(dropDownGraph));
		driver.findElement(dropDownGraph).click();


	}
	public void graphTopic() {

		driver.findElement(GraphTopic).click();
	}
	public void graphRepresentation() {

		driver.findElement(GraphRepresentationTopic).click();
	}
	public void backTograph() {
		driver.findElement(dropDownbtn).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50) );
		wait.until(ExpectedConditions.visibilityOfElementLocated(dropDownGraph));
		driver.findElement(dropDownGraph).click();

	}
	public void signOut() {
		driver.findElement(signOutBtn).click();
	}
	public String getPageTitle() {
		return driver.getTitle();
	}
	public void tryHere() {
		driver.findElement(tryHere).click();
	}
	public String getPageURL() {
		return driver.getCurrentUrl();
	}
	public void driverBack() {
		driver.navigate().back();
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
	public void queuePage() {
		driver.findElement(dropDownbtn).click();
		driver.findElement(dropDownQueue).click();
	}
	public void treePage() {
		driver.findElement(dropDownbtn).click();
		driver.findElement(dropDownTree).click();
	}
	public void graphPageDrop() {
		driver.findElement(dropDownbtn).click();
		driver.findElement(dropDownGraph).click();
	}
	public void practiceQuestion() {
		driver.findElement(practiceQuestion).click();
	}
public boolean validatePractice() {
		
		boolean value=driver.getPageSource().contains("graphquestions");
		//return driver.getTitle();
		System.out.println(value);
		return value;
	}
public void explicitWaitGraph() {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50) );
	wait.until(ExpectedConditions.visibilityOfElementLocated(dropDownGraph));
	driver.findElement(dropDownGraph).click();
}
	
}

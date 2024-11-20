package pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import driver.DriverFactory;

public class DatastructuresPage {
	
	By getStartBtn1 = By.xpath("//a[text()='Get Started']");
	By Topic1=By.linkText("Time Complexity");
	By tryhere = By.linkText("Try here>>>");
	By runbtn = By.xpath("//button[text()='Run']");
	By txt_prq = By.xpath("//form[@id='answer_form']/div/div/div/textarea");
	By signOutbtn=By.xpath("//a[text()='Sign out']");
	
	private WebDriver driver;
	
	public DatastructuresPage() 
	{
		this.driver =  DriverFactory.getInstance().getDriver();;
	}
		
	public void openDSPage() 
	{		
		driver.get("https://dsportalapp.herokuapp.com/home");

		GetStartBtnList();
	}
	public void Topic(String topic){
		List<WebElement> Topic = driver.findElements(By.linkText(topic));
		Topic.get(0).click();
		String title = driver.getTitle();		
	}
	public void tryHere() {
		driver.findElement(tryhere).click();
	}
	
	public void GetStartBtnList() {
		List<WebElement> getbtnList = driver.findElements(getStartBtn1);
		getbtnList.get(0).click();// for data structures
		System.out.println("ds inro page");
		
	}
	
	 // Get page title
    public String getPageTitle() {
        return driver.getTitle();
    }
    public String dsPageURL() {
		return driver.getCurrentUrl();
	}
    public void driverBack() {
		driver.navigate().back();
	}
    public void clickRun() {
		driver.findElement(runbtn).click();
	}
    public String alertwin() {
    	System.out.println("In alert1");
		Alert alert = driver.switchTo().alert();
		String alrttxt = alert.getText();
		return alrttxt;
	}

	public void alertwin1() {
		System.out.println("In alert2");
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
	public void clear_texteditor() throws InterruptedException {
		driver.findElement(txt_prq);
		new Actions(driver).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.DELETE).perform();
	}
	public void copyCode(String pycode) throws InterruptedException {
		clear_texteditor();
		WebElement arraylinkcode = driver.findElement(txt_prq);

		String[]lines=pycode.split("\n");
		Thread.sleep(1000);
		for(int i=0;i<lines.length;i++) {

			if(lines[i].equalsIgnoreCase("\\b")) {
				new Actions(driver).sendKeys(Keys.BACK_SPACE).perform();
			}
			else
			{
				arraylinkcode.sendKeys(lines[i].trim());
				new Actions(driver).sendKeys(Keys.RETURN).perform();			
			}
		}
	}
	
	public void explicitWaitAlert() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20) );
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();		
		alert.accept();		
	}
public void codeEnter(String Code) throws InterruptedException {
		
		texteditorData(Code);
	}
public void texteditorData(String textarea) throws InterruptedException {

	WebElement activeElement = driver.switchTo().activeElement();
	Actions action = new Actions(driver);
	action.moveToElement(activeElement).click().perform();
	activeElement.sendKeys(textarea);
}

    public void	practicDS_ExcelPythonCode(String Practice_Topic,  String pythonCode, String result, String url) throws InterruptedException
	{
    	String actualresult="";
		driver.get(url);
		copyCode(pythonCode);			
		clickRun(); 
		if(pythonCode.trim()!="Invalid")
		{			
			actualresult = result;
			System.out.println("Valid py code");
		}else
		{
			System.out.println("Invalid py code");
			explicitWaitAlert();
			actualresult="";
		}
		driverBack();			
	}
    public void signOut() {
		driver.findElement(signOutbtn).click();
	}
}

package pageObjects;
import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import constants.Constants;
import driver.DriverFactory;


public class ArrayPage {
	private WebDriver driver;

	// 1.By Locators
	By dsDropDn = By.xpath("//a[text()='Data Structures']");
	By dsMList = By.xpath("//div[@class='dropdown-menu show']/a");
	By getStartBtn1 = By.xpath("//a[text()='Get Started']");
	By ArrPgeURL = By.linkText("Arrays in Python");
	By tryhere = By.linkText("Try here>>>");
	By runbtn = By.xpath("//button[text()='Run']");
	By txtarea = By.xpath("//div//pre[@class='CodeMirror-line-like']/span");
	By txt_prq = By.xpath("//form[@id='answer_form']/div/div/div/textarea");

	By consolemsg = By.xpath("//div//pre[@id='output']");

	By getStartBtn=By.xpath("//a[contains(text(),'Get Started')]");
	By dsintroURL = By.linkText("Time Complexity");
	By signOutbtn=By.xpath("//a[text()='Sign out']");
	By dropDownArray=By.linkText("Arrays");
	By dropDownbtn=By.xpath("//a[@class='nav-link dropdown-toggle']");

	By consoleOutput=By.id("output");
	By Topic1=By.linkText("Arrays in Python");
	By Topic2=By.linkText("Arrays Using List");
	By Topic3=By.linkText("Basic Operations in Lists");
	By Topic4=By.linkText("Applications of Array");

	//Constructor
	public ArrayPage() {
		this.driver =  DriverFactory.getInstance().getDriver();;
	}
	public void openArrayPage() {
		driver.findElement(dropDownbtn).click();
		driver.findElement(dropDownArray).click();

	}
	public void goSigninPage() {
		driver.get("https://dsportalapp.herokuapp.com/login");
	}
	public void Topic(int index){
		List<WebElement> Topic =driver.findElements(By.className("list-group-item"));
		Topic.get(index).click();
		String topic=driver.getTitle();
		System.out.println("We are in "+topic);
	}
	public void tryHere() {
		driver.findElement(tryhere).click();
	}
	public void codeEnter(String Code) throws InterruptedException {
		
		texteditorData(Code);
	}
	public void clearCode() {
		driver.findElement(txt_prq).clear();
	}

	public void clickRun() {
		driver.findElement(runbtn).click();
	}
	public String consoleOutput() {
		return driver.findElement(consoleOutput).getText();
	}
	public String getPageTitle() {
		return driver.getTitle();
	}

	public String ArrayPageURL() {
		//driver.get("https://dsportalapp.herokuapp.com/home");
		return driver.getCurrentUrl();
	}

	public void DropDownClick() {
		driver.findElement(dsDropDn).click();
	}

	public void DropDownList(int index) {
		List<WebElement> getbtnList = driver.findElements(dsMList);
		getbtnList.get(index).click();
	}

	public void GetStartBtnList(int index) {
		List<WebElement> getbtnList1 = driver.findElements(getStartBtn1);
		getbtnList1.get(index).click();
	}

	public void isValidTopic(String topic2) throws Exception {

		List<WebElement> Topic = driver.findElements(By.linkText(topic2));
		if (Topic.isEmpty() == true) {
			System.out.println(topic2 + " (Link is not present)");
			throw new Exception(topic2 + " (Link is not present)");
		} else {
			System.out.println(topic2 + " (Link is present)");
		}
	}

	public void ClickTopic(String topic2) throws Exception {

		List<WebElement> Topic = driver.findElements(By.linkText(topic2));
		Topic.get(0).click();
	}

	public void ClickTopic1(String topic2) throws Exception {
		List<WebElement> Topic = driver.findElements(By.linkText(topic2));
		Topic.get(0).click();
	}

	public void ArrayinPython() {
		driver.findElement(ArrPgeURL).click();
	}

	public void try_here() {
		driver.findElement(tryhere).click();
	}

	public void runbtn() {
		driver.findElement(runbtn).click();
	}
	public void signoutBtn() {
		driver.findElement(signOutbtn).click();
	}

	public void txtbox_copy(String code) {
		WebElement activeElement = driver.findElement(txtarea);
		activeElement.sendKeys(code);
	}

	public String alertwin() {
		Alert alert = driver.switchTo().alert();
		String alrttxt = alert.getText();
		return alrttxt;
	}

	public void alertwin1() {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	public String tryeditormsg() {
		WebElement ele = driver.findElement(consolemsg);
		return ele.getText();
	}

	public void texteditorData(String textarea) throws InterruptedException {

		WebElement activeElement = driver.switchTo().activeElement();
		Actions action = new Actions(driver);
		action.moveToElement(activeElement).click().perform();
		activeElement.sendKeys(textarea);
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
	public void driverBack() {
		driver.navigate().back();
	}
	public void explicitWait() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50) );
		wait.until(ExpectedConditions.visibilityOfElementLocated(txtarea));
	}
	public void explicitWaitAlert() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3) );
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert =driver.switchTo().alert();		
		alert.accept();		
	}
	public void backToArray() {
		driver.findElement(dsDropDn).click();
		driver.findElement(dropDownArray).click();		
	}
	public String navigatetoPythonPracticeCode() {

		driver.get("https://dsportalapp.herokuapp.com/array/practice");
		return getPageTitle();		
	}
	public void	practiceArrayDS_JsonPythonCode(Map<String, String> data) throws InterruptedException
	{
		System.out.println("Type: " + data.get("type") + ", Index: " + data.get("index")+ ", url: " + data.get("url")+ ", Index: " + data.get("index")+ ", code: " + data.get("code"));
		driver.get(data.get("url"));
		if(data.get("code").trim()!="")
		{			
			clear_texteditor();
			WebElement arraylinkcode = driver.findElement(txt_prq);

			String[]lines = data.get("code").split("\n");
			System.out.println(arraylinkcode.getText());
			for(int i=0;i<lines.length;i++)
			{	 
				if(lines[i].contains("\b")) {
					new Actions(driver).sendKeys(Keys.BACK_SPACE).perform();
				}
				else
				{
					arraylinkcode.sendKeys(lines[i].trim());
					new Actions(driver).sendKeys(Keys.RETURN).perform();			
				}
			}
		}
		//clickRun();
		driver.navigate().back();
	}
	public void	practiceArrayDS_ExcelPythonCode(String Practice_Topic,  String pythonCode, String result, String url) throws InterruptedException
	{
		driver.get(url);
		if(pythonCode.trim()!="")
		{
			copyCode(pythonCode);
			clickRun();
			Assert.assertEquals(tryeditormsg(),result); 

		}else
		{
			clickRun();
			alertwin();
			alertwin1();
		}
		driver.navigate().back();
	}
public void tryEditorCode(int topicnumber,String validcode) throws InterruptedException
{
	Topic(topicnumber);
	tryHere();
	driver.get("https://dsportalapp.herokuapp.com/tryEditor");
	texteditorData(validcode);
	//codeEnter(validcode);
	clickRun();
}
	public void signOut() {
		driver.findElement(signOutbtn).click();
	}
}
package pageTestEvents;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.Select;

import com.beust.jcommander.Parameters;

import base.BaseTest;


import driver.DriverFactory;
import io.cucumber.messages.types.Duration;
import pageObjects.GraphPage;
import pageObjects.SignInPage;
import utilities.Excel_DataProvider;

public class GraphPageEvents extends BaseTest {


	WebDriver driver;
	GraphPage graphPage;
	/*@BeforeSuite
	public void launchBrowser() {
		graph.launchBrowser();
	}*/
	//@Parameters({"Scrutinizers","Numpysdet176"})
	@BeforeClass 
	public void Login() {
		graphPage= new GraphPage();
		graphPage.goHomePage();
		graphPage.goSigninPage();
		graphPage.enterUserName("Scrutinizers");
		graphPage.enterPassWord("Numpysdet176");
		graphPage.signIn();
	}
	@BeforeMethod()
	public void graphPage(){
		graphPage.openGraphPage();
	}
	@Test (priority=1)
	public void graphTopic() {
		graphPage.graphTopic();
		String actualTitle=graphPage.getPageTitle();
		String expectedTitle="Graph";

		Assert.assertEquals(actualTitle,expectedTitle );

		System.out.println(actualTitle);
	}
	@Test (priority=2)
	public void graphRepresentationTopic() {
		graphPage.graphRepresentation();
		String actualTitle=graphPage.getPageTitle();
		String expectedTitle="Graph Representations";
		Assert.assertEquals(actualTitle,expectedTitle );
		System.out.println(actualTitle);
	}
	@Test
	public void tryHereGraph() {
		graphPage.graphTopic();
		graphPage.tryHere();
		String actualURL=graphPage.getPageURL();
		String expectedURL="https://dsportalapp.herokuapp.com/tryEditor";
		Assert.assertEquals(actualURL,expectedURL );
		graphPage.driverBack();
	}
	@Test
	public void tryHereGraphRepresentation() {
		graphPage.graphRepresentation();
		graphPage.tryHere();
		String actualURL=graphPage.getPageURL();
		String expectedURL="https://dsportalapp.herokuapp.com/tryEditor";
		Assert.assertEquals(actualURL,expectedURL );
		graphPage.driverBack();

	}
	@Test
	public void nocodeGraph() {
		graphPage.graphTopic();
		graphPage.tryHere();
		graphPage.clickRun();
		String actualURL=graphPage.getPageURL();
		String expectedURL="https://dsportalapp.herokuapp.com/tryEditor";
		Assert.assertEquals(actualURL,expectedURL );
		graphPage.driverBack();
	}
	@Test
	public void nocodeGraphRepresentation() {
		graphPage.graphRepresentation();
		graphPage.tryHere();
		graphPage.clickRun();
		String actualURL=graphPage.getPageURL();
		String expectedURL="https://dsportalapp.herokuapp.com/tryEditor";
		Assert.assertEquals(actualURL,expectedURL );
		graphPage.driverBack();
	}
	@Test(dataProvider="codeDp", dataProviderClass = Excel_DataProvider.class)

	public void validCodeGraph(String validcode,String invalidcode) {
		graphPage.graphTopic();
		graphPage.tryHere();
		graphPage.codeEnter(validcode);
		graphPage.clickRun();
		String actualOutput=graphPage.consoleOutput();
		String expectedoutput="Hello";
		Assert.assertEquals(actualOutput, expectedoutput);
		graphPage.driverBack();
	}
	//@Test(dataProvider="Python Code")
	@Test(dataProvider="codeDp", dataProviderClass = Excel_DataProvider.class)
	public void validCodeGraphRep(String validcode,String invalidcode) {
		graphPage.graphRepresentation();
		graphPage.tryHere();
		graphPage.codeEnter(validcode);
		graphPage.clickRun();
		String actualOutput=graphPage.consoleOutput();
		String expectedoutput="Hello";
		Assert.assertEquals(actualOutput, expectedoutput);
		graphPage.driverBack();
	}
	@Test(dataProvider="codeDp", dataProviderClass = Excel_DataProvider.class)
	public void invalidCodeGraph(String validcode,String invalidcode) throws InterruptedException {
		graphPage.graphTopic();
		graphPage.tryHere();
		//graphPage.clearCode();
		graphPage.codeEnter(invalidcode);
		graphPage.clickRun();

		//WebDriverWait wait = new WebDriverWait(driver,30);

		//wait.until(ExpectedConditions.alertIsPresent());
		graphPage.alerAccept();
		graphPage.driverBack();
	}
	//@Test(dataProvider="Python Code")
	@Test(dataProvider="codeDp", dataProviderClass = Excel_DataProvider.class)
	public void invalidCodeGraphRep(String validcode,String invalidcode) throws InterruptedException {
		graphPage.graphRepresentation();
		graphPage.tryHere();
		//graphPage.clearCode();
		graphPage.codeEnter(invalidcode);
		graphPage.clickRun();

		//WebDriverWait wait = new WebDriverWait(driver,30);

		//wait.until(ExpectedConditions.alertIsPresent());
		graphPage.alerAccept();
		graphPage.driverBack();
	}
	@Test
	public void practiceQueT1() {
		graphPage.graphTopic();
		graphPage.practiceQuestion();
		Assert.assertTrue(graphPage.validatePractice());
		
		graphPage.backTograph();
		
		
		
	}
	@Test
	public void practiceQueT2() {
		graphPage.graphRepresentation();
		graphPage.practiceQuestion();
		Assert.assertTrue(graphPage.validatePractice());
		//String Actual=graphPage.validatePractice();
		//String Expected="Graph";
		//Assert.assertEquals(Actual, Expected);
		
		graphPage.backTograph();
		
		
		
	}
	@Test 
	public void arrayPage() {
		graphPage.arrayPage();
		String actualTitle=graphPage.getPageTitle();
		String expectedTitle="Array";
		Assert.assertEquals(actualTitle, expectedTitle);
		
	}
	@Test 
	public void arrayPageT1() {
		graphPage.graphTopic();
		graphPage.arrayPage();
		String actualTitle=graphPage.getPageTitle();
		String expectedTitle="Array";
		Assert.assertEquals(actualTitle, expectedTitle);
		
	}
	@Test 
	public void arrayPageT2() {
		graphPage.graphRepresentation();
		graphPage.arrayPage();
		String actualTitle=graphPage.getPageTitle();
		String expectedTitle="Array";
		Assert.assertEquals(actualTitle, expectedTitle);
		
	}
	
	@Test
	public void linkedListPage() {
		graphPage.linkedListPage();
		String actualTitle=graphPage.getPageTitle();
		String expectedTitle="Linked List";
		Assert.assertEquals(actualTitle, expectedTitle);	
	}
	@Test
	public void linkedListPageT1() {
		graphPage.graphTopic();
		graphPage.linkedListPage();
		String actualTitle=graphPage.getPageTitle();
		String expectedTitle="Linked List";
		Assert.assertEquals(actualTitle, expectedTitle);	
	}
	@Test
	public void linkedListPageT2() {
		graphPage.graphRepresentation();
		graphPage.linkedListPage();
		String actualTitle=graphPage.getPageTitle();
		String expectedTitle="Linked List";
		Assert.assertEquals(actualTitle, expectedTitle);	
	}
	@Test
	public void stackPage() {
		graphPage.stackPage();
		String actualTitle=graphPage.getPageTitle();
		String expectedTitle="Stack";
		Assert.assertEquals(actualTitle, expectedTitle);
		
	}
	@Test
	public void stackPageT1() {
		graphPage.graphTopic();
		graphPage.stackPage();
		String actualTitle=graphPage.getPageTitle();
		String expectedTitle="Stack";
		Assert.assertEquals(actualTitle, expectedTitle);
		
	}
	@Test
	public void stackPageT2() {
		graphPage.graphRepresentation();
		graphPage.stackPage();
		String actualTitle=graphPage.getPageTitle();
		String expectedTitle="Stack";
		Assert.assertEquals(actualTitle, expectedTitle);
		
	}
	
	@Test
	public void queuePage() {
		graphPage.queuePage();
		String actualTitle=graphPage.getPageTitle();
		String expectedTitle="Queue";
		Assert.assertEquals(actualTitle, expectedTitle);
		
	}
	@Test
	public void queuePageT1() {
		graphPage.graphTopic();
		graphPage.queuePage();
		String actualTitle=graphPage.getPageTitle();
		String expectedTitle="Queue";
		Assert.assertEquals(actualTitle, expectedTitle);
		
	}
	@Test
	public void queuePageT2() {
		graphPage.graphRepresentation();
		graphPage.queuePage();
		String actualTitle=graphPage.getPageTitle();
		String expectedTitle="Queue";
		Assert.assertEquals(actualTitle, expectedTitle);
		
	}
	@Test
	public void treePage() {
		graphPage.treePage();
		String actualTitle=graphPage.getPageTitle();
		String expectedTitle="Tree";
		Assert.assertEquals(actualTitle, expectedTitle);
		
		
	}
	@Test
	public void treePageT1() {
		graphPage.graphTopic();
		graphPage.treePage();
		String actualTitle=graphPage.getPageTitle();
		String expectedTitle="Tree";
		Assert.assertEquals(actualTitle, expectedTitle);
		
		
	}
	@Test
	public void treePageT2() {
		graphPage.graphRepresentation();
		graphPage.treePage();
		String actualTitle=graphPage.getPageTitle();
		String expectedTitle="Tree";
		Assert.assertEquals(actualTitle, expectedTitle);
		
		
	}
	@Test
	public void graphDdropDown() {
		graphPage.graphPageDrop();
		String actualTitle=graphPage.getPageTitle();
		String expectedTitle="Graph";
		Assert.assertEquals(actualTitle, expectedTitle);
	}
	@Test
	public void graphDdropDownT1() {
		graphPage.graphTopic();
		graphPage.graphPageDrop();
		String actualTitle=graphPage.getPageTitle();
		String expectedTitle="Graph";
		Assert.assertEquals(actualTitle, expectedTitle);
	}
	@Test
	public void graphDdropDownT2() {
		graphPage.graphRepresentation();
		graphPage.graphPageDrop();
		String actualTitle=graphPage.getPageTitle();
		String expectedTitle="Graph";
		Assert.assertEquals(actualTitle, expectedTitle);
	}
	@AfterMethod()
	public void backtograph(){
		graphPage.backTograph();
		System.out.println("User is back to Graph page");
	}

	@AfterClass
	public void Logout() {
		graphPage.signOut();
		System.out.println("User loggedout");
	}
	@DataProvider(name="SignInData")
	public Object[][] getSignInData(){
		return new Object[][] {
			{
				"Scrutinizers","Numpysdet176"
			}
		};


	}
	@DataProvider(name="Python Code")
	public Object[][] pythonCode() {
		return new Object[][] {
			{
				"print'Hello'" ,"printhello"
			}
		};
	}
}
/*@AfterSuite 
public void quitBrowser() {
	driver.quit();
}*/


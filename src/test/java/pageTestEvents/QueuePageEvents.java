package pageTestEvents;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import pageObjects.QueuePage;
import utilities.Excel_DataProvider;

public class QueuePageEvents extends BaseTest {
	WebDriver driver;
	QueuePage queuePage;
	@BeforeClass 
	public void Login() throws InterruptedException {
		queuePage= new QueuePage();
		queuePage.goHomePage();
		queuePage.goSigninPage();
		queuePage.enterUserName("Scrutinizers");
		queuePage.enterPassWord("Numpysdet176");
		queuePage.signIn();
	}
	@BeforeMethod()
	public void queuePage(){
		
		queuePage.openQueuePage();
		
	}
	@Test
	public void implementationofQueueinPythonTopic() {
		queuePage.implementationofQueueinPythonTopic();
		String actualTitle=queuePage.getPageTitle();
		String expectedTitle="Implementation of Queue in Python";
		Assert.assertEquals(actualTitle, expectedTitle);
	}
	@Test
	public void implementationusingcollectionsdequeTopic() {
		queuePage.implementationusingcollectionsdequeTopic();
		String actualTitle=queuePage.getPageTitle();
		String expectedTitle="Implementation using collections.deque";
		Assert.assertEquals(actualTitle, expectedTitle);
	}
	@Test
	public void implementationusingarrayTopic() {
		queuePage.implementationusingarrayTopic();
		String actualTitle=queuePage.getPageTitle();
		String expectedTitle="Implementation using array";
		Assert.assertEquals(actualTitle, expectedTitle);
		
	}
	@Test 
	public void queueOperationsTopic() {
		queuePage.queueOperationsTopic();
		String actualTitle=queuePage.getPageTitle();
		String expectedTitle="Queue Operations";
		Assert.assertEquals(actualTitle, expectedTitle);
		
	}
	@Test 
	public void tryHereTopic1() {
		queuePage.implementationofQueueinPythonTopic();
		queuePage.tryHere();
		String actualURL=queuePage.getPageURL();
		String expectedURL="https://dsportalapp.herokuapp.com/tryEditor";
		Assert.assertEquals(actualURL,expectedURL );
		queuePage.driverBack();
		
	}
	@Test 
	public void tryHereTopic2() {
		queuePage.implementationusingcollectionsdequeTopic();
		queuePage.tryHere();
		String actualURL=queuePage.getPageURL();
		String expectedURL="https://dsportalapp.herokuapp.com/tryEditor";
		Assert.assertEquals(actualURL,expectedURL );
		queuePage.driverBack();
		
	}
	@Test 
	public void tryHereTopic3() {
		queuePage.implementationusingarrayTopic();
		queuePage.tryHere();
		String actualURL=queuePage.getPageURL();
		String expectedURL="https://dsportalapp.herokuapp.com/tryEditor";
		Assert.assertEquals(actualURL,expectedURL );
		queuePage.driverBack();
		
	}
	@Test 
	public void tryHereTopic4() {
		queuePage.queueOperationsTopic();
		queuePage.tryHere();
		String actualURL=queuePage.getPageURL();
		String expectedURL="https://dsportalapp.herokuapp.com/tryEditor";
		Assert.assertEquals(actualURL,expectedURL );
		queuePage.driverBack();
		
	}
	@Test
	public void practiceQueTopic1() {
		queuePage.implementationofQueueinPythonTopic();
		queuePage.practiceQuestion();
		String Actual=queuePage.validatePractice();
		String Expected="Queue";
		Assert.assertEquals(Actual, Expected);
		queuePage.backToQueue();
		
		
	}
	@Test
	public void nocodeTopic1() {
		queuePage.implementationofQueueinPythonTopic();
		queuePage.tryHere();
		queuePage.clickRun();
		String actualURL=queuePage.getPageURL();
		String expectedURL="https://dsportalapp.herokuapp.com/tryEditor";
		Assert.assertEquals(actualURL,expectedURL );
		queuePage.driverBack();
	}
	@Test
	public void nocodeTopic2() {
		queuePage.implementationusingcollectionsdequeTopic();
		queuePage.tryHere();
		queuePage.clickRun();
		String actualURL=queuePage.getPageURL();
		String expectedURL="https://dsportalapp.herokuapp.com/tryEditor";
		Assert.assertEquals(actualURL,expectedURL );
		queuePage.driverBack();
		
	}
	@Test
	public void nocodeTopic3() {
		queuePage.implementationusingarrayTopic();
		queuePage.tryHere();
		queuePage.clickRun();
		String actualURL=queuePage.getPageURL();
		String expectedURL="https://dsportalapp.herokuapp.com/tryEditor";
		Assert.assertEquals(actualURL,expectedURL );
		queuePage.driverBack();
		
	}
	@Test
	public void nocodeTopic4() {
		queuePage.queueOperationsTopic();
		queuePage.tryHere();
		queuePage.clickRun();
		String actualURL=queuePage.getPageURL();
		String expectedURL="https://dsportalapp.herokuapp.com/tryEditor";
		Assert.assertEquals(actualURL,expectedURL );
		queuePage.driverBack();
		
	}
	//@Test(dataProvider="Python Code")
	@Test(dataProvider="codeDp", dataProviderClass = Excel_DataProvider.class)
	public void validCodeT1(String validcode,String invalidcode) {
		queuePage.implementationofQueueinPythonTopic();
		queuePage.tryHere();
		queuePage.codeEnter(validcode);
		queuePage.clickRun();
		String actualOutput=queuePage.consoleOutput();
		String expectedoutput="Hello";
		Assert.assertEquals(actualOutput, expectedoutput);
		queuePage.driverBack();
		
	}
	@Test(dataProvider="codeDp", dataProviderClass = Excel_DataProvider.class)
	public void invalidCodeT1(String validcode,String invalidcode) throws InterruptedException {
		queuePage.implementationofQueueinPythonTopic();
		queuePage.tryHere();
		queuePage.codeEnter(invalidcode);
		queuePage.clickRun();
		queuePage.alerAccept();
		queuePage.driverBack();
		
	}
	@Test(dataProvider="codeDp", dataProviderClass = Excel_DataProvider.class)
	public void validCodeT2(String validcode,String invalidcode) {
		queuePage.implementationusingcollectionsdequeTopic();
		queuePage.tryHere();
		queuePage.codeEnter(validcode);
		queuePage.clickRun();
		String actualOutput=queuePage.consoleOutput();
		String expectedoutput="Hello";
		Assert.assertEquals(actualOutput, expectedoutput);
		queuePage.driverBack();
		
	}
	@Test(dataProvider="codeDp", dataProviderClass = Excel_DataProvider.class)
	public void invalidCodeT2(String validcode,String invalidcode) throws InterruptedException {
		queuePage.implementationusingcollectionsdequeTopic();
		queuePage.tryHere();
		queuePage.codeEnter(invalidcode);
		queuePage.clickRun();
		queuePage.alerAccept();
		queuePage.driverBack();
		
	}
	@Test(dataProvider="codeDp", dataProviderClass = Excel_DataProvider.class)
	public void validCodeT3(String validcode,String invalidcode) {
		queuePage.implementationusingarrayTopic();
		queuePage.tryHere();
		queuePage.codeEnter(validcode);
		queuePage.clickRun();
		String actualOutput=queuePage.consoleOutput();
		String expectedoutput="Hello";
		Assert.assertEquals(actualOutput, expectedoutput);
		queuePage.driverBack();
		
	}
	@Test(dataProvider="codeDp", dataProviderClass = Excel_DataProvider.class)
	public void invalidCodeT3(String validcode,String invalidcode) throws InterruptedException {
		queuePage.implementationusingarrayTopic();
		queuePage.tryHere();
		queuePage.codeEnter(invalidcode);
		queuePage.clickRun();
		queuePage.alerAccept();
		queuePage.driverBack();
		
	}
	@Test(dataProvider="codeDp", dataProviderClass = Excel_DataProvider.class)
	public void validCodeT4(String validcode,String invalidcode) {
		queuePage.queueOperationsTopic();
		queuePage.tryHere();
		queuePage.codeEnter(validcode);
		queuePage.clickRun();
		String actualOutput=queuePage.consoleOutput();
		String expectedoutput="Hello";
		Assert.assertEquals(actualOutput, expectedoutput);
		queuePage.driverBack();
		
	}
	@Test(dataProvider="codeDp", dataProviderClass = Excel_DataProvider.class)
	public void invalidCodeT4(String validcode,String invalidcode) throws InterruptedException {
		queuePage.queueOperationsTopic();
		queuePage.tryHere();
		queuePage.codeEnter(invalidcode);
		queuePage.clickRun();
		queuePage.alerAccept();
		queuePage.driverBack();
		
	}
	@Test 
	public void arrayPage() {
		queuePage.arrayPage();
		String actualTitle=queuePage.getPageTitle();
		String expectedTitle="Array";
		Assert.assertEquals(actualTitle, expectedTitle);
		
	}
	@Test 
	public void arrayPageT1() {
		queuePage.implementationofQueueinPythonTopic();
		queuePage.arrayPage();
		String actualTitle=queuePage.getPageTitle();
		String expectedTitle="Array";
		Assert.assertEquals(actualTitle, expectedTitle);
		
	}
	@Test 
	public void arrayPageT2() {
		queuePage.implementationusingcollectionsdequeTopic();
		queuePage.arrayPage();
		String actualTitle=queuePage.getPageTitle();
		String expectedTitle="Array";
		Assert.assertEquals(actualTitle, expectedTitle);
		
	}
	@Test 
	public void arrayPageT3() {
		queuePage.implementationusingarrayTopic();
		queuePage.arrayPage();
		String actualTitle=queuePage.getPageTitle();
		String expectedTitle="Array";
		Assert.assertEquals(actualTitle, expectedTitle);
		
	}
	@Test 
	public void arrayPageT4() {
		queuePage.queueOperationsTopic();
		queuePage.arrayPage();
		String actualTitle=queuePage.getPageTitle();
		String expectedTitle="Array";
		Assert.assertEquals(actualTitle, expectedTitle);
		
	}
	@Test 
	public void linkedListPage() {
		queuePage.linkedListPage();
		String actualTitle=queuePage.getPageTitle();
		String expectedTitle="Linked List";
		Assert.assertEquals(actualTitle, expectedTitle);
		
	}
	@Test 
	public void linkedListPageT1() {
		queuePage.implementationofQueueinPythonTopic();
		queuePage.linkedListPage();
		String actualTitle=queuePage.getPageTitle();
		String expectedTitle="Linked List";
		Assert.assertEquals(actualTitle, expectedTitle);
		
	}
	@Test 
	public void linkedListPageT2() {
		queuePage.implementationusingcollectionsdequeTopic();
		queuePage.linkedListPage();
		String actualTitle=queuePage.getPageTitle();
		String expectedTitle="Linked List";
		Assert.assertEquals(actualTitle, expectedTitle);
		
	}
	@Test 
	public void linkedListPageT3() {
		queuePage.implementationusingarrayTopic();
		queuePage.linkedListPage();
		String actualTitle=queuePage.getPageTitle();
		String expectedTitle="Linked List";
		Assert.assertEquals(actualTitle, expectedTitle);
		
	}
	@Test 
	public void linkedListPageT4() {
		queuePage.queueOperationsTopic();
		queuePage.linkedListPage();
		String actualTitle=queuePage.getPageTitle();
		String expectedTitle="Linked List";
		Assert.assertEquals(actualTitle, expectedTitle);
		
	}
	
	@Test 
	public void stackPage() {
		queuePage.stackPage();
		String actualTitle=queuePage.getPageTitle();
		String expectedTitle="Stack";
		Assert.assertEquals(actualTitle, expectedTitle);
		
	}
	@Test 
	public void stackPageT1() {
		queuePage.implementationofQueueinPythonTopic();
		queuePage.stackPage();
		String actualTitle=queuePage.getPageTitle();
		String expectedTitle="Stack";
		Assert.assertEquals(actualTitle, expectedTitle);
		
	}
	@Test 
	public void stackPageT2() {
		queuePage.implementationusingcollectionsdequeTopic();
		queuePage.stackPage();
		String actualTitle=queuePage.getPageTitle();
		String expectedTitle="Stack";
		Assert.assertEquals(actualTitle, expectedTitle);
		
	}
	@Test 
	public void stackPageT3() {
		queuePage.implementationusingarrayTopic();
		queuePage.stackPage();
		String actualTitle=queuePage.getPageTitle();
		String expectedTitle="Stack";
		Assert.assertEquals(actualTitle, expectedTitle);
		
	}
	@Test 
	public void stackPageT4() {
		queuePage.queueOperationsTopic();
		queuePage.stackPage();
		String actualTitle=queuePage.getPageTitle();
		String expectedTitle="Stack";
		Assert.assertEquals(actualTitle, expectedTitle);
		
	}
	
	@Test 
	public void queueDropPage() {
		queuePage.queuePageDrop();
		String actualTitle=queuePage.getPageTitle();
		String expectedTitle="Queue";
		Assert.assertEquals(actualTitle, expectedTitle);
		
	}
	@Test 
	public void queueDropPageT1() {
		queuePage.implementationofQueueinPythonTopic();
		queuePage.queuePageDrop();
		String actualTitle=queuePage.getPageTitle();
		String expectedTitle="Queue";
		Assert.assertEquals(actualTitle, expectedTitle);
		
	}
	@Test 
	public void queueDropPageT2() {
		queuePage.implementationusingcollectionsdequeTopic();
		queuePage.queuePageDrop();
		String actualTitle=queuePage.getPageTitle();
		String expectedTitle="Queue";
		Assert.assertEquals(actualTitle, expectedTitle);
		
	}
	@Test 
	public void queueDropPageT3() {
		queuePage.implementationusingarrayTopic();
		queuePage.queuePageDrop();
		String actualTitle=queuePage.getPageTitle();
		String expectedTitle="Queue";
		Assert.assertEquals(actualTitle, expectedTitle);
		
	}
	@Test 
	public void queueDropPageT4() {
		queuePage.queueOperationsTopic();
		queuePage.queuePageDrop();
		String actualTitle=queuePage.getPageTitle();
		String expectedTitle="Queue";
		Assert.assertEquals(actualTitle, expectedTitle);
		
	}
	
	@Test 
	public void treePage() {
		queuePage.treePage();
		String actualTitle=queuePage.getPageTitle();
		String expectedTitle="Tree";
		Assert.assertEquals(actualTitle, expectedTitle);
		
	}
	@Test 
	public void treePageT1() {
		queuePage.implementationofQueueinPythonTopic();
		queuePage.treePage();
		String actualTitle=queuePage.getPageTitle();
		String expectedTitle="Tree";
		Assert.assertEquals(actualTitle, expectedTitle);
		
	}
	@Test 
	public void treePageT2() {
		queuePage.implementationusingcollectionsdequeTopic();
		queuePage.treePage();
		String actualTitle=queuePage.getPageTitle();
		String expectedTitle="Tree";
		Assert.assertEquals(actualTitle, expectedTitle);
		
	}
	@Test 
	public void treePageT3() {
		queuePage.implementationusingarrayTopic();
		queuePage.treePage();
		String actualTitle=queuePage.getPageTitle();
		String expectedTitle="Tree";
		Assert.assertEquals(actualTitle, expectedTitle);
		
	}
	@Test 
	public void treePageT4() {
		queuePage.queueOperationsTopic();
		queuePage.treePage();
		String actualTitle=queuePage.getPageTitle();
		String expectedTitle="Tree";
		Assert.assertEquals(actualTitle, expectedTitle);
		
	}
	
	@Test 
	public void graphPage() {
		queuePage.graphPage();
		String actualTitle=queuePage.getPageTitle();
		String expectedTitle="Graph";
		Assert.assertEquals(actualTitle, expectedTitle);
		
	}
	@Test 
	public void graphPageT1() {
		queuePage.implementationofQueueinPythonTopic();
		queuePage.graphPage();
		String actualTitle=queuePage.getPageTitle();
		String expectedTitle="Graph";
		Assert.assertEquals(actualTitle, expectedTitle);
		
	}
	@Test 
	public void graphPageT2() {
		queuePage.implementationusingcollectionsdequeTopic();
		queuePage.graphPage();
		String actualTitle=queuePage.getPageTitle();
		String expectedTitle="Graph";
		Assert.assertEquals(actualTitle, expectedTitle);
		
	}
	@Test 
	public void graphPageT3() {
		queuePage.implementationusingarrayTopic();
		queuePage.graphPage();
		String actualTitle=queuePage.getPageTitle();
		String expectedTitle="Graph";
		Assert.assertEquals(actualTitle, expectedTitle);
		
	}
	@Test 
	public void graphPageT4() {
		queuePage.queueOperationsTopic();
		queuePage.graphPage();
		String actualTitle=queuePage.getPageTitle();
		String expectedTitle="Graph";
		Assert.assertEquals(actualTitle, expectedTitle);
		
	}
	@AfterMethod()
	public void backtoQueue(){
		queuePage.backToQueue();
		System.out.println("User is back to Queue page");
	}

	@AfterClass
	public void Logout() {
		queuePage.signOut();
		System.out.println("User loggedout");
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

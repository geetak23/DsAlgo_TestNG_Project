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

import pageObjects.LinkedListPage;
import utilities.RetryAnalyzer;

public class LinkedListPageEvents extends BaseTest {
	WebDriver driver;
	LinkedListPage linkedlistPage;
	@BeforeClass 
	public void Login() throws InterruptedException {
		linkedlistPage= new LinkedListPage();
		linkedlistPage.goHomePage();
		linkedlistPage.goSigninPage();
		linkedlistPage.enterUserName("Scrutinizers");
		linkedlistPage.enterPassWord("Numpysdet176");
		linkedlistPage.signIn();
	}
	@BeforeMethod()
	public void linkedListPage(){

		linkedlistPage.openLinkedListPage();

	}
	@Test(dataProvider="LinkedList Topics",retryAnalyzer = RetryAnalyzer.class,priority=0)
	public void topicsLinkedList(int topicnumber,String Title) {
		linkedlistPage.Topic(topicnumber);

		String ActualOutput=linkedlistPage.getPageTitle();
		String Expected=Title;
		Assert.assertEquals(ActualOutput, Expected);

	}
	@Test(dataProvider="LinkedList Topics",retryAnalyzer = RetryAnalyzer.class,priority=1)
	public void tryHereTopics(int topicnumber,String Title) {
		linkedlistPage.Topic(topicnumber);
		linkedlistPage.tryHere();
		String actualURL=linkedlistPage.getPageURL();
		String expectedURL="https://dsportalapp.herokuapp.com/tryEditor";
		Assert.assertEquals(actualURL,expectedURL );
		linkedlistPage.driverBack();

	}
	@Test(dataProvider="LinkedList Topics",retryAnalyzer = RetryAnalyzer.class,dependsOnMethods= {"tryHereTopics"},priority=2)
	public void nocodeTopics(int topicnumber,String Title) {
		linkedlistPage.Topic(topicnumber);
		linkedlistPage.tryHere();
		linkedlistPage.clickRun();
		String actualURL=linkedlistPage.getPageURL();
		String expectedURL="https://dsportalapp.herokuapp.com/tryEditor";
		Assert.assertEquals(actualURL,expectedURL );
		linkedlistPage.driverBack();



	}
	@Test(dataProvider="validcode Topics",retryAnalyzer = RetryAnalyzer.class,dependsOnMethods= {"tryHereTopics"},priority=3)
	public void validcodeTopics(int topicnumber,String validcode) {
		linkedlistPage.Topic(topicnumber);
		linkedlistPage.tryHere();
		linkedlistPage.codeEnter(validcode);
		linkedlistPage.clickRun();
		String actualOutput=linkedlistPage.consoleOutput();
		String expectedoutput="Hello";
		Assert.assertEquals(actualOutput, expectedoutput);
		linkedlistPage.driverBack();
	}
	@Test(dataProvider="invalidcode Topics",retryAnalyzer = RetryAnalyzer.class,dependsOnMethods= {"tryHereTopics"},priority=4)
	public void invalidTopics(int topicnumber, String invalidcode) {
		linkedlistPage.Topic(topicnumber);
		linkedlistPage.tryHere();
		linkedlistPage.codeEnter(invalidcode);
		linkedlistPage.clickRun();
		linkedlistPage.explicitWaitAlert();
		linkedlistPage.driverBack();
	}
	@Test (dataProvider="LinkedList Topics",retryAnalyzer = RetryAnalyzer.class)
	public void arrayPage(int topicnumber,String Title) {
		linkedlistPage.Topic(topicnumber);
		linkedlistPage.arrayPage();
		String actualTitle=linkedlistPage.getPageTitle();
		String expectedTitle="Array";
		Assert.assertEquals(actualTitle, expectedTitle);


	}
	@Test (dataProvider="LinkedList Topics",retryAnalyzer = RetryAnalyzer.class)
	public void linkedListPageDropdn(int topicnumber,String Title) {
		linkedlistPage.Topic(topicnumber);
		linkedlistPage.linkedListPageDrop();
		String actualTitle=linkedlistPage.getPageTitle();
		String expectedTitle="Linked List";
		Assert.assertEquals(actualTitle, expectedTitle);


	}
	@Test (dataProvider="LinkedList Topics",retryAnalyzer = RetryAnalyzer.class)
	public void stackPage(int topicnumber,String Title) {
		linkedlistPage.Topic(topicnumber);
		linkedlistPage.stackPage();
		String actualTitle=linkedlistPage.getPageTitle();
		String expectedTitle="Stack";
		Assert.assertEquals(actualTitle, expectedTitle);


	}
	@Test (dataProvider="LinkedList Topics",retryAnalyzer = RetryAnalyzer.class)
	public void queuePage(int topicnumber,String Title) {
		linkedlistPage.Topic(topicnumber);
		linkedlistPage.queuePage();
		String actualTitle=linkedlistPage.getPageTitle();
		String expectedTitle="Queue";
		Assert.assertEquals(actualTitle, expectedTitle);


	}
	@Test (dataProvider="LinkedList Topics",retryAnalyzer = RetryAnalyzer.class)
	public void treePage(int topicnumber,String Title) {
		linkedlistPage.Topic(topicnumber);
		linkedlistPage.treePage();
		String actualTitle=linkedlistPage.getPageTitle();
		String expectedTitle="Tree";
		Assert.assertEquals(actualTitle, expectedTitle);


	}
	@Test (dataProvider="LinkedList Topics",retryAnalyzer = RetryAnalyzer.class)
	public void graphPage(int topicnumber,String Title) {
		linkedlistPage.Topic(topicnumber);
		linkedlistPage.graphPage();
		String actualTitle=linkedlistPage.getPageTitle();
		String expectedTitle="Graph";
		Assert.assertEquals(actualTitle, expectedTitle);


	}



	@AfterMethod()
	public void backtoQueue(){
		linkedlistPage.backToLinkedList();
		System.out.println("User is back to LinkedList page");
	}

	@AfterClass
	public void Logout() {
		linkedlistPage.signOut();
		System.out.println("User loggedout");
	}
	@DataProvider(name="LinkedList Topics")
	public Object[][] topicsLinkedlist() {
		return new Object[][] {
			{0,"Introduction"},
			{1,"Creating Linked LIst"},
			{2,"Types of Linked List"},
			{3,"Implement Linked List in Python"},
			{4,"Traversal"},
			{5,"Insertion"},
			{6,"Deletion"},


		};

	}
	@DataProvider(name="validcode Topics")
	public Object[][] validcodeTopics() {
		return new Object[][] {
			{0,"print'Hello'"},
			{1,"print'Hello'"},
			{2,"print'Hello'"},
			{3,"print'Hello'"},
			{4,"print'Hello'"},
			{5,"print'Hello'"},
			{6,"print'Hello'"},


		};

	}
	@DataProvider(name="invalidcode Topics")
	public Object[][] invalidcodeTopics() {
		return new Object[][] {
			{0,"printhello"},
			{1,"printhello"},
			{2,"printhello"},
			{3,"printhello"},
			{4,"printhello"},
			{5,"printhello"},
			{6,"printhello"},


		};

	}

}

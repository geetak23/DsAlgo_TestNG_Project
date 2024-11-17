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
import pageObjects.TreePage;

public class TreePageEvents extends BaseTest{
	WebDriver driver;
	TreePage treePage;
	@BeforeClass 
	public void Login() {
		treePage= new TreePage();
		treePage.goHomePage();
		treePage.goSigninPage();
		treePage.enterUserName("Scrutinizers");
		treePage.enterPassWord("Numpysdet176");
		treePage.signIn();
	}
	@BeforeMethod()
	public void treePage(){
		
		treePage.openTreePage();
		
	}
	@Test(dataProvider="Tree Topics")
	public void topicsTree(int topicnumber,String Title) {
		treePage.Topic(topicnumber);
		
		String ActualOutput=treePage.getPageTitle();
		String Expected=Title;
		Assert.assertEquals(ActualOutput, Expected);
			
	}
	
	@Test(dataProvider="Tree Topics")
	public void tryHereTopics(int topicnumber,String Title) {
		treePage.Topic(topicnumber);
		treePage.tryHere();
		String actualURL=treePage.getPageURL();
		String expectedURL="https://dsportalapp.herokuapp.com/tryEditor";
		Assert.assertEquals(actualURL,expectedURL );
		treePage.driverBack();
		
	}
	@Test(dataProvider="Tree Topics")
	public void nocodeTopics(int topicnumber,String Title) {
		treePage.Topic(topicnumber);
		treePage.tryHere();
		treePage.clickRun();
		String actualURL=treePage.getPageURL();
		String expectedURL="https://dsportalapp.herokuapp.com/tryEditor";
		Assert.assertEquals(actualURL,expectedURL );
		treePage.driverBack();
		
		
		
	}
	@Test(dataProvider="validcode Topics")
	public void validcodeTopics(int topicnumber,String validcode) {
		treePage.Topic(topicnumber);
		treePage.tryHere();
		treePage.codeEnter(validcode);
		treePage.clickRun();
		String actualOutput=treePage.consoleOutput();
		String expectedoutput="Hello";
		Assert.assertEquals(actualOutput, expectedoutput);
		treePage.driverBack();
	}
	@Test(dataProvider="invalidcode Topics")
	public void invalidTopics(int topicnumber, String invalidcode) {
		treePage.Topic(topicnumber);
		treePage.tryHere();
		treePage.codeEnter(invalidcode);
		treePage.clickRun();
		treePage.explicitWaitAlert();
		treePage.driverBack();
	}
	
	@Test
	public void practiceQue() {
		treePage.topic1();
		treePage.practiceQuestion();
		Assert.assertTrue(treePage.validatePractice());
		treePage.driverBack();
		
		
	}
	
	@AfterMethod()
	public void backtostack(){
		treePage.backToTree();
		System.out.println("User is back to Tree page");
	}

	@AfterClass
	public void Logout() {
		treePage.signOut();
		System.out.println("User loggedout");
	}
	@DataProvider(name="Tree Topics")
	public Object[][] topicsLinkedlist() {
		return new Object[][] {
			{0,"Overview of Trees"},
			{1,"Terminologies"},
			{2,"Types of Trees"},
			{3,"Tree Traversals"},
			{4,"Traversals-Illustration"},
			{5,"Binary Trees"},
			{6,"Types of Binary Trees"},
			{7,"Implementation in Python"},
			{8,"Binary Tree Traversals"},
			{9,"Implementation of Binary Trees"},
			{10,"Applications of Binary trees"},
			{11,"Binary Search Trees"},
			{12,"Implementation Of BST"},
			
			
			
			
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
			{7,"print'Hello'"},
			{8,"print'Hello'"},
			{9,"print'Hello'"},
			{10,"print'Hello'"},
			{11,"print'Hello'"},
			{12,"print'Hello'"},
			
			
			
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
			{7,"printhello"},
			{8,"printhello"},
			{9,"printhello"},
			{10,"printhello"},
			{11,"printhello"},
			{12,"printhello"},
			
			
			
		};
		
	}
	
	
}

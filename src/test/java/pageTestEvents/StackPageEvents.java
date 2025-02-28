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

import pageObjects.StackPage;
import utilities.Excel_DataProvider;
import utilities.RetryAnalyzer;

public class StackPageEvents  extends BaseTest {
	WebDriver driver;
	StackPage stackPage;
	@BeforeClass 
	public void Login() throws InterruptedException {
		stackPage= new StackPage();
		stackPage.goHomePage();
		stackPage.goSigninPage();
		stackPage.enterUserName("Scrutinizers");
		stackPage.enterPassWord("Numpysdet176");
		stackPage.signIn();
	}
	@BeforeMethod()
	public void stackPage(){

		stackPage.openStackPage();

	}
	@Test(dataProvider="Stack Topics",retryAnalyzer = RetryAnalyzer.class)
	public void topicsStack(int topicnumber,String Title) {
		stackPage.Topic(topicnumber);

		String ActualOutput=stackPage.getPageTitle();
		String Expected=Title;
		Assert.assertEquals(ActualOutput, Expected);

	}

	@Test(dataProvider="Stack Topics",retryAnalyzer = RetryAnalyzer.class)
	public void tryHereTopics(int topicnumber,String Title) {
		stackPage.Topic(topicnumber);
		stackPage.tryHere();
		String actualURL=stackPage.getPageURL();
		String expectedURL="https://dsportalapp.herokuapp.com/tryEditor";
		Assert.assertEquals(actualURL,expectedURL );
		stackPage.driverBack();

	}
	@Test(dataProvider="Stack Topics",retryAnalyzer = RetryAnalyzer.class)
	public void nocodeTopics(int topicnumber,String Title) {
		stackPage.Topic(topicnumber);
		stackPage.tryHere();
		stackPage.clickRun();
		String actualURL=stackPage.getPageURL();
		String expectedURL="https://dsportalapp.herokuapp.com/tryEditor";
		Assert.assertEquals(actualURL,expectedURL );
		stackPage.driverBack();



	}
	@Test(dataProvider="Valid code topic no", dataProviderClass = Excel_DataProvider.class,retryAnalyzer = RetryAnalyzer.class)
	public void validcodeTopics(String topicnumber,String validcode) {

		int topicnumber1 = 0; 
		if (topicnumber.contains("0")){

			topicnumber1=0;
		}
		else 
			if(topicnumber.contains("1")) {
				topicnumber1=1;
			}
			else
				if(topicnumber.contains("2")) {
					topicnumber1=2;
				}


		stackPage.Topic(topicnumber1);
		stackPage.tryHere();
		stackPage.codeEnter(validcode);
		stackPage.clickRun();
		String actualOutput=stackPage.consoleOutput();
		String expectedoutput="Hello";
		Assert.assertEquals(actualOutput, expectedoutput);
		stackPage.driverBack();
	}
	//@Test(dataProvider="invalidcode Topics")
	@Test(dataProvider="Invalid code topic no", dataProviderClass = Excel_DataProvider.class,retryAnalyzer = RetryAnalyzer.class)
	public void invalidTopics(String topicnumber,String invalidcode) {
		int topicnumber1 = 0; 
		if (topicnumber.contains("0")){

			topicnumber1=0;
		}
		else 
			if(topicnumber.contains("1")) {
				topicnumber1=1;
			}
			else
				if(topicnumber.contains("2")) {
					topicnumber1=2;
				}

		stackPage.Topic(topicnumber1);
		stackPage.tryHere();
		stackPage.codeEnter(invalidcode);
		stackPage.clickRun();
		stackPage.explicitWaitAlert();
		stackPage.driverBack();
	}



	@AfterMethod()
	public void backtostack(){
		stackPage.backToStack();
		System.out.println("User is back to Stack page");
	}

	@AfterClass
	public void Logout() {
		stackPage.signOut();
		System.out.println("User loggedout");
	}
	@DataProvider(name="Stack Topics")
	public Object[][] topicsLinkedlist() {
		return new Object[][] {
			{0,"Operations in Stack"},
			{1,"Implementation"},
			{2,"Applications"},



		};

	}
	@DataProvider(name="validcode Topics")
	public Object[][] validcodeTopics() {
		return new Object[][] {
			{0,"print'Hello'"},
			{1,"print'Hello'"},
			{2,"print'Hello'"},



		};

	}
	@DataProvider(name="invalidcode Topics")
	public Object[][] invalidcodeTopics() {
		return new Object[][] {
			{"Operations in Stack","printhello"},
			{"Implementation","printhello"},
			{"Applications","printhello"},



		};

	}


}

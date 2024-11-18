package pageTestEvents;

import java.util.Map;

import org.apache.poi.hssf.model.ConvertAnchor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import pageObjects.SignInPage;
import pageObjects.ArrayPage;
import utilities.DataProvider_Inputs;
import utilities.TestDataLoader;

public class ArrayPageEvents extends BaseTest{

	
	ArrayPage arrpage;

	@BeforeClass
	public void userSignIn() {
		System.out.println("@BeforeClass");
		arrpage = new ArrayPage();	
		logIntoDsPortal();
	}
	@BeforeMethod()
	public void arrayPage(){		
		arrpage.openArrayPage();	
	}

	@Test(priority = 1, dataProvider="Array Topics", dataProviderClass = DataProvider_Inputs.class)
	public void topicsArray(int topicnumber,String Title) {
		arrpage.Topic(topicnumber);

		String ActualOutput=arrpage.getPageTitle();
		String Expected=Title;
		Assert.assertEquals(ActualOutput, Expected);			
	}	

	@Test(priority = 2, dataProvider="Array Topics", dataProviderClass = DataProvider_Inputs.class)
	public void tryHereTopics(int topicnumber,String Title) {
		arrpage.Topic(topicnumber);
		arrpage.tryHere();
		String actualURL = arrpage.ArrayPageURL();
		String expectedURL = "https://dsportalapp.herokuapp.com/tryEditor";
		Assert.assertEquals(actualURL,expectedURL );
		arrpage.driverBack();		
	}

@Test(priority = 4, dataProvider="Array Topics", dataProviderClass = DataProvider_Inputs.class)
	public void nocodeTopics(int topicnumber,String Title) {
		arrpage.Topic(topicnumber);
		arrpage.tryHere();
		arrpage.clickRun();
		String actualURL=arrpage.ArrayPageURL();
		String expectedURL="https://dsportalapp.herokuapp.com/tryEditor";
		Assert.assertEquals(actualURL,expectedURL );
		arrpage.driverBack();
	}

	@Test(priority = 5, dataProvider="validcode Arrays Topics", dataProviderClass = DataProvider_Inputs.class)
	public void validcodeTopics(int topicnumber,String validcode) throws InterruptedException {
		arrpage.Topic(topicnumber);
		arrpage.tryHere();
		System.out.println(validcode);
		arrpage.codeEnter(validcode);
		arrpage.clickRun();
		String actualOutput=arrpage.consoleOutput();
		String expectedoutput="Hello";
		System.out.println(actualOutput+"    :   actualOutput");
		if(actualOutput!="")
			Assert.assertEquals(actualOutput, expectedoutput);
		arrpage.driverBack();
	}
	@Test(dataProvider="invalidcode Arrays Topics", dataProviderClass = DataProvider_Inputs.class)
	public void invalidTopics(int topicnumber, String invalidcode) throws InterruptedException {
		arrpage.Topic(topicnumber);
		arrpage.tryHere();
		arrpage.codeEnter(invalidcode);
		arrpage.clickRun();
		arrpage.explicitWaitAlert();
		arrpage.driverBack();
	}

	@Test(priority = 9, dataProvider = "getArrayTopicCodeExcelData", dataProviderClass = DataProvider_Inputs.class)
	public void getArrayTopicCodeExcelData(String topic, String code, String result) throws InterruptedException {
		int topicIndex=0;
		if(topic.toLowerCase()=="Arrays in Python")topicIndex=1;
		else if (topic.trim().toLowerCase()=="Arrays Using List")topicIndex=2;
		else if (topic.trim().toLowerCase()=="Basic Operations in Lists")topicIndex=3;
		else if(topic.trim().toLowerCase()=="Applications of Array")topicIndex=4;
		
			arrpage.Topic(topicIndex);
			arrpage.tryHere();
			System.out.println(code);
			arrpage.codeEnter(code);
			arrpage.clickRun();
			String actualOutput=arrpage.consoleOutput();
			String expectedoutput="Hello";
			System.out.println(actualOutput+"    :   actualOutput");
			if(actualOutput!="")
				Assert.assertEquals(actualOutput, expectedoutput);
			arrpage.driverBack();
	}

@Test(priority =10, dataProvider = "arrayPracticeCode", dataProviderClass = DataProvider_Inputs.class)
	public void arrayPracticeCode(Map<String, String> data) throws InterruptedException {		
		arrpage.Topic(1);
		arrpage.practiceArrayDS_JsonPythonCode(data);
	}

	@Test(priority =11, dataProvider = "arrayPracticeCodeExcel", dataProviderClass = DataProvider_Inputs.class)
	public void practiceArrayDS_ExcelPythonCode(String Practice_Topic,String pythonCode,String result,String url) throws InterruptedException {	
		int topicIndex=0;
		if(Practice_Topic==" Search the array ")topicIndex=1;
		else if (Practice_Topic.trim().toLowerCase()=="max consecutive ones")topicIndex=2;
		else if (Practice_Topic.trim().toLowerCase()=="find numbers with even number of digits")topicIndex=3;
		else if(Practice_Topic.trim().toLowerCase()=="squares of a sorted array")topicIndex=4;

		arrpage.Topic(topicIndex);
		arrpage.practiceArrayDS_ExcelPythonCode(Practice_Topic,pythonCode,result,url);	

	}



	@AfterMethod()
	public void backtoArray(){
		arrpage.backToArray();
		System.out.println("User is back to Array page");
	}

	@AfterClass
	public void Logout() {
		arrpage.signOut();
		System.out.println("User loggedout");
	}
}
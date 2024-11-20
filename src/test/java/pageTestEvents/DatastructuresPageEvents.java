package pageTestEvents;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import pageObjects.DatastructuresPage;
import utilities.DataProvider_Inputs;
import utilities.RetryAnalyzer;

public class DatastructuresPageEvents extends BaseTest{
	DatastructuresPage dspage;

	@BeforeClass
	public void userSignIn() {		
		dspage = new DatastructuresPage();	
		logIntoDsPortal();
	}
	@BeforeMethod()
	public void DatastructuresPage(){		
		dspage.openDSPage();	
	}
	
	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void chkDSPageTitle()	
	{
		String stringExpected = "Data Structures-Introduction";
		Assert.assertEquals(dspage.getPageTitle(), stringExpected); 
	}	
	@Test(priority = 2, dataProvider="topicsDS", dataProviderClass = DataProvider_Inputs.class)
	public void tryHereTopics(int topicindex , String topic) {
		dspage.Topic(topic);
		dspage.tryHere();
		String actualURL = dspage.dsPageURL();
		String expectedURL = "https://dsportalapp.herokuapp.com/tryEditor";
		Assert.assertEquals(actualURL,expectedURL );
		System.out.println(expectedURL);
		System.out.println(actualURL);		
		dspage.driverBack();		
	}
	@Test(priority = 2, dataProvider="topicsDS", dataProviderClass = DataProvider_Inputs.class)
	public void tryHereCode(int topicindex , String topic) {
		dspage.Topic(topic);
		dspage.tryHere();
		dspage.clickRun();
		String actualURL = dspage.dsPageURL();
		String expectedURL = "https://dsportalapp.herokuapp.com/tryEditor";
		Assert.assertEquals(actualURL,expectedURL );
		System.out.println(expectedURL);
		System.out.println(actualURL);		
		dspage.driverBack();		
	}
	@Test(priority =11, dataProvider = "topicsDSValidExcelCode", dataProviderClass = DataProvider_Inputs.class)
	public void topicsDSExcel(String Practice_Topic,String pythonCode,String result,String url) throws InterruptedException {			

		String errormsg=result;		
			dspage.practicDS_ExcelPythonCode(Practice_Topic,pythonCode,result,url);
		Assert.assertEquals(errormsg,result );
		dspage.driverBack();			
	}
	@Test(priority =11, dataProvider = "topicsDSInvalidExcelCode", dataProviderClass = DataProvider_Inputs.class)
	public void topicsDSInvalidExcelCode(String Practice_Topic,String pythonCode,String result,String url) throws InterruptedException {		

		dspage.Topic(Practice_Topic);
		dspage.tryHere();
		dspage.codeEnter(pythonCode);
		dspage.clickRun();
		dspage.explicitWaitAlert();
		Assert.assertEquals("",result );
		dspage.driverBack();
	}
		
	@AfterMethod()
	public void backtoArray(){
		dspage.driverBack();
		System.out.println("User is back to Array page");
	}

	@AfterClass
	public void Logout() {
		dspage.signOut();
		System.out.println("User loggedout");
	}
}

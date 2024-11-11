package pageTestEvents;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import driver.DriverFactory;
import pageObjects.DashBoardPage;
import pageObjects.SignInPage;
import utilities.DataProvider_Inputs;
import utilities.TestDataLoader;

public class DashBoardPageEvents extends BaseTest {

	private boolean boolsignIn = false;
	SignInPage signIn;
	DashBoardPage dsDBPage;

	@BeforeClass
	public void dsportalDashBoardWithoutSignIn() {
		System.out.println("@BeforeClass");
		dsDBPage = new DashBoardPage();
		dsDBPage.openDashBoardPage();
	}

	@Test(priority = 3)
	public void chkPageTitle()
	{
		System.out.println("@Test3");
		String stringExpected = "NumpyNinja";
		Assert.assertEquals(dsDBPage.getPageTitle(), stringExpected); 
	}

	@Test(priority = 4)
	public void validateDsAlgoDropdownItems() {		
		System.out.println("@Test4");
		int totalItems= dsDBPage.getTotaldropDownOptions();		
		Assert.assertEquals(totalItems, 6);
	}
	@Test(priority = 5)
	public void validateDsAlgoButtons() {	
		System.out.println("@Test5");
		int totBtns= dsDBPage.getStartBtnList();		
		Assert.assertEquals(totBtns, 7);
	}
	@Test(priority = 6) 
	public void validateRegister() {	
		System.out.println("validateRegister");
		dsDBPage.clickRegisterLink();
	}
	
	@Test(priority =7, dataProvider = "dataStructuresProvider", dataProviderClass = DataProvider_Inputs.class)
	public void testDSwithoutSignIn(Map<String, String> data) {
		System.out.println("Type: " + data.get("type") + ", Index: " + data.get("index"));		
		dsDBPage.clickDropdownitem(Integer.parseInt(data.get("index")));	
		
	}
	
	@Test(priority = 8)
	public void validateSignIn() {	
		System.out.println("validateSignIn");
		dsDBPage.clickSignInPage();			
	}
	@Test(priority = 9)
	public void userSignIn() {
		System.out.println("userSignIn");

		signIn = new SignInPage();
		boolsignIn = true;
		signIn.signinpage(TestDataLoader.getInstance().getUserName(), TestDataLoader.getInstance().getPassword());		
	}

	//Sign In user Test cases	

	@Test(priority =10, dataProvider = "dataStructuresProvider", dataProviderClass = DataProvider_Inputs.class)
	public void testDataStructures(Map<String, String> data) {
		System.out.println("Type: " + data.get("type") + ", Index: " + data.get("index"));		
		dsDBPage.clickDropdownitem(Integer.parseInt(data.get("index")));		
	}
}

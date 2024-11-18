package pageTestEvents;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.BaseTest;
import pageObjects.*;
import utilities.DataProvider_Inputs;
import utilities.RetryAnalyzer;

public class SignInPageEvents extends BaseTest{
	SignInPage signIn;
	@BeforeClass
	public void userSignIn() {
		System.out.println("@BeforeClass");
		signIn = new SignInPage();
		signIn.openSignInPage();
	}

	@Test(priority = 10,retryAnalyzer = RetryAnalyzer.class)
	public void testPageTitle()
	{
		String stringExpected = "Login";
		System.out.println("chk SignIn PageTitle: " + signIn.getSignInPageTitle().trim() +" and checked with : "+ stringExpected );	
		Assert.assertEquals(signIn.getSignInPageTitle().trim(), stringExpected); 
	}
	@Test(priority = 11, dataProvider = "getSignInInvalidData", dataProviderClass = DataProvider_Inputs.class,retryAnalyzer = RetryAnalyzer.class)
	public void testSignInInvalidData(String username, String password, String ExpectedMsg) {	
		System.out.println("invalid data");
		signIn.signinpage(username,password);

		if((username.trim()==""&& password.trim()=="")||(password.trim()=="")||username.trim()=="")
		{
			Assert.assertEquals("Please fill out this field.", "Please fill out this field.");
		}
		else {
			Assert.assertEquals(signIn.LoginBtnError().trim(), ExpectedMsg); 
		}
	}

	@Test(priority = 12, dataProvider = "getSignInValidData", dataProviderClass = DataProvider_Inputs.class,retryAnalyzer = RetryAnalyzer.class)
	public void testSignInData(String username, String password, String ExpectedMsg) {	
		System.out.println("valid data");
		signIn.signinpage(username,password);	
	}
}

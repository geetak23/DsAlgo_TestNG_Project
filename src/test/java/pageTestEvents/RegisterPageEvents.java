package pageTestEvents;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.BaseTest;
import pageObjects.DashBoardPage;
import pageObjects.RegisterPage;
import utilities.DataProvider_Inputs;
import utilities.RetryAnalyzer;

public class RegisterPageEvents extends BaseTest 
{	
	RegisterPage regPage;

	public void registerUser(String userName,String password,String ConfirmPwd,String ExpectedMsg)
	{			       
		try {
			regPage.userName(userName);
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		try {
			regPage.passWord(password);
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		try {
			regPage.confirmPassword(ConfirmPwd);
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}        
		regPage.clickReg();	
		if((userName.trim()==""&& password.trim()==""&& ConfirmPwd.trim()=="")||(password.trim()==""&& ConfirmPwd.trim()=="")||(ConfirmPwd.trim()=="")||userName.trim()=="")
		{
			Assert.assertEquals("Please fill out this field.", "Please fill out this field.");
		}
		else {
			Assert.assertEquals(regPage.pwdErrMsg(), ExpectedMsg);
			System.out.println("Testing registration with Username: " + userName + 
					", Password: " + password + 
					", Confirm Password: " + ConfirmPwd +
					", ExpectedMsg: " + regPage.pwdErrMsg() );
		}
	}

	@BeforeClass
	public void registerWithoutSignIn() {
		System.out.println("@BeforeClass");
		regPage = new RegisterPage();
		regPage.openRegisterPage();
	}

	@Test(priority = 8,retryAnalyzer = RetryAnalyzer.class)
	public void testPageTitle()
	{
		System.out.println("chk Register PageTitle");
		String stringExpected = "Registration";
		Assert.assertEquals(regPage.pageTitle().trim(), stringExpected); 
	}

	@Test(priority = 9, dataProvider = "getRegistrationExcelData", dataProviderClass = DataProvider_Inputs.class,retryAnalyzer = RetryAnalyzer.class)
	public void testUserRegistration(String username, String password, String confirmPassword, String ExpectedMsg) {	
		
		registerUser(username,password,confirmPassword,ExpectedMsg);		
	}
	@Test(priority = 9, dataProvider = "getInvalidRegistrationStaticData", dataProviderClass = DataProvider_Inputs.class,retryAnalyzer = RetryAnalyzer.class)
	public void testUserRegistrationjson(String username, String password, String confirmPassword, String ExpectedMsg) {	
		System.out.println("Testing registration with Username: " + username + 
				", Password: " + password + 
				", Confirm Password: " + confirmPassword +
				", ExpectedMsg: "+ ExpectedMsg);
		registerUser(username,password,confirmPassword,ExpectedMsg);		
	}
}

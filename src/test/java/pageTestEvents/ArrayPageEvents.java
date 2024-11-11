package pageTestEvents;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;

import base.BaseTest;
import pageObjects.SignInPage;
import pageObjects.ArrayPage;
import utilities.TestDataLoader;

public class ArrayPageEvents extends BaseTest{
	
	SignInPage signIn;
	WebDriver driver;
	ArrayPage Arpage;
	
	@BeforeClass
	public void userSignIn() {
		System.out.println("@BeforeClass");
		
		signIn = new SignInPage();
		signIn.signinpage(TestDataLoader.getInstance().getUserName(), TestDataLoader.getInstance().getPassword());		
	}
	
	
	
	
}

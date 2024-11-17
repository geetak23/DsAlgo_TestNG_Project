package pageTestEvents;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import pageObjects.SignOutPage;


public class SignOutPageEvents extends BaseTest{
	WebDriver driver;
	SignOutPage signOutPage;
	@BeforeMethod
	public void Login() {
		signOutPage= new SignOutPage();
		signOutPage.goHomePage();
		signOutPage.goSigninPage();
		signOutPage.enterUserName("Scrutinizers");
		signOutPage.enterPassWord("Numpysdet176");
		signOutPage.signIn();
	}
	@Test
	public void signOuthome() {
		signOutPage.signOut();
		signOutPage.validatesignOut();

	}
	@Test
	public void signOutArray() {
		signOutPage.arrayPage();
		signOutPage.signOut();
		signOutPage.validatesignOut();

	}
	@Test
	public void signOutLinkedList() {
		signOutPage.linkedListPage();
		signOutPage.signOut();
		signOutPage.validatesignOut();

	}
	@Test
	public void signOutStack() {
		signOutPage.stackPage();
		signOutPage.signOut();
		signOutPage.validatesignOut();

	}
	@Test
	public void signOutQueue() {
		signOutPage.queuePage();
		signOutPage.signOut();
		signOutPage.validatesignOut();

	}
	@Test
	public void signOutTree() {
		signOutPage.treePage();
		signOutPage.signOut();
		signOutPage.validatesignOut();

	}
	@Test
	public void signOutGraph() {
		signOutPage.graphPage();
		signOutPage.signOut();
		signOutPage.validatesignOut();

	}
	@AfterMethod
	public void backtoHome() {
		signOutPage.driverBack();
	}


}

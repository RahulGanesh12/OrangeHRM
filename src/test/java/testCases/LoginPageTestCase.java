package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import base.BaseClass;
import pageObjects.ForgotPasswordPage;
import pageObjects.HomePage;
import pageObjects.Login;

public class LoginPageTestCase extends BaseClass {
	Login login;
	HomePage homepage;
	ForgotPasswordPage forgotpasswordpage;

	public LoginPageTestCase() throws IOException {
	}

	@BeforeMethod
	public void setUp() throws IOException {
		initialization();
		login = new Login();
	}

	@Test(priority = 1)
	public void loginTestCase() throws InterruptedException {
		homepage = login.verifyLogin(properties.getProperty("UserName"), properties.getProperty("Password"));
	}

	@Test(priority = 2)
	public void loginTestCaseUsingKeyBoardOnly() throws InterruptedException {
		homepage = login.verifyLoginUsingKeyBoardKeys(properties.getProperty("UserName"),
				properties.getProperty("Password"));
	}

	@Test(priority = 3)
	public void verifyTitleTestCase() {
		Assert.assertEquals(login.verifyTitle(), "OrangeHRM");
	}

	@Test(priority = 4)
	public void verifyLogoTestCase() {
		Assert.assertTrue(login.verifyImage());
	}

	@Test(priority = 5)
	public void verifyForgotPasswordFunctionality() throws InterruptedException, IOException {
		forgotpasswordpage = login.verifyForgotPasswordLink();
	}

	@AfterMethod
	public void tearDown() {
		driverQuitMethod();
	}

}

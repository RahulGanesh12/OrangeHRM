package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseClass;
import pageObjects.ForgotPasswordPage;
import pageObjects.Login;

public class ForgotPasswordPageTestCase extends BaseClass {

	public ForgotPasswordPageTestCase() throws IOException {
		super();
	}

	Login login;
	ForgotPasswordPage forgotpassword;

	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		initialization();
		login = new Login();
		forgotpassword = login.verifyForgotPasswordLink();
	}

	@Test(priority = 1)
	public void verifyPageHeaderTestCase() {
		Assert.assertEquals(forgotpassword.verifyPageHeader(), "Reset Password");
	}

	@Test(priority = 2)
	public void verifyErrorMessageTestCase() {
		Assert.assertEquals(forgotpassword.verifyErrorMessage(),
				"The OrangeHRM system is not configured to receive email notifications. Please contact your OrangeHRM administrator to reset your password");
	}

	@Test(priority = 3)
	public void verifyBackToLoginPageLinkTestCase() throws IOException {
		forgotpassword.verifyBackToLoginPageLink();
	}

	@AfterMethod
	public void tearDown() {
		driverQuitMethod();
	}

}

package testCases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseClass;
import pageObjects.Login;

public class LoginPageTestCase extends BaseClass {
	Login login;

	public LoginPageTestCase() throws IOException {
	}

	@BeforeMethod
	public void setUp() throws IOException {
		initialization();
		login = new Login();
	}

	@Test(priority = 1)
	public void loginTestCase() throws InterruptedException {
		login.verifyLogin(properties.getProperty("UserName"), properties.getProperty("Password"));
	}

	@AfterMethod
	public void tearDown() {
		driverQuitMethod();
	}

}

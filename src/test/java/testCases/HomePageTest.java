package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseClass;
import pageObjects.HomePage;
import pageObjects.Login;
import pageObjects.OrangeHRMSoftwarePage;
import utils.SearchPageDataProvider;

public class HomePageTest extends BaseClass {
	public HomePageTest() throws IOException {
	}

	Login login;
	HomePage homepage;
	OrangeHRMSoftwarePage ohs;

	@DataProvider
	public Object[][] searchFunctionalityDataProvider() throws IOException {
		return SearchPageDataProvider.searchPageValues();
	}

	@BeforeMethod
	public void setUp() throws InterruptedException, IOException {
		initialization();
		login = new Login();
		login.verifyLogin(properties.getProperty("UserName"), properties.getProperty("Password"));
		Thread.sleep(3000);
		homepage = new HomePage();
	}

//	@Test(priority = 1)
	public void verifyImageLogoTestCase() throws InterruptedException {
		Assert.assertTrue(homepage.verifyLogoDisplayed());
	}

//	@Test(priority = 2)
	public void verifyImageLeadsToSoftwarePageTestCase() throws InterruptedException {
		ohs = homepage.verifyIfClickingLogoLeadsToSoftwarePage();
		Assert.assertNotNull(ohs);
	}

//	@Test(priority = 3)
	public void verifyMenuButtonFunctionalityTestCase() throws InterruptedException {
		Assert.assertTrue(homepage.verifyMenuButtonFunctionality());
	}

	@Test(priority = 1, dataProvider = "searchFunctionalityDataProvider")
	public void verifySearchFunctionTestCase(String Values) throws InterruptedException {
		Assert.assertTrue(homepage.verifySearchFunction(Values));
	}

	@AfterMethod
	public void tearDown() {
		driverQuitMethod();
	}
}

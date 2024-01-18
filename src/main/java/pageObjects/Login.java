package pageObjects;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseClass;

public class Login extends BaseClass {

	public Login() throws IOException {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//img[@alt='company-branding']")
	WebElement Logo;
	@FindBy(xpath = "//input[@placeholder='Username']")
	WebElement UserName;
	@FindBy(xpath = "//input[@placeholder='Password']")
	WebElement Password;
	@FindBy(xpath = "//button[normalize-space()='Login']")
	WebElement LoginButton;

	public Boolean verifyImage() {
		return Logo.isDisplayed();
	}

	public void verifyLogin(String userName, String password) throws InterruptedException {
		UserName.sendKeys(userName);
		Thread.sleep(1000);
		Password.sendKeys(password);
		Thread.sleep(1000);
		LoginButton.click();
	}

	public String verifyTitle() {
		return driver.getTitle();
	}
}

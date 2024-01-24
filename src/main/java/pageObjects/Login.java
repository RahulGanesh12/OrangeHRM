package pageObjects;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseClass;
import utils.KeyBoardActionsUtils;

public class Login extends BaseClass {
	Actions actions = KeyBoardActionsUtils.actionsMethod();

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
	@FindBy(xpath = "//p[@class='oxd-text oxd-text--p orangehrm-login-forgot-header']")
	WebElement ForgotPassword;

	public Boolean verifyImage() {
		return Logo.isDisplayed();
	}

	public HomePage verifyLogin(String userName, String password) throws InterruptedException, IOException {
		UserName.sendKeys(userName);
		Thread.sleep(1000);
		Password.sendKeys(password);
		Thread.sleep(1000);
		LoginButton.click();
		return new HomePage();
	}

	public HomePage verifyLoginUsingKeyBoardKeys(String userName, String password)
			throws InterruptedException, IOException {
		UserName.sendKeys(userName);
		Thread.sleep(1000);
		actions.keyDown(Keys.TAB).perform();
		Thread.sleep(1000);
		actions.keyUp(Keys.TAB).perform();
		Password.sendKeys(password);
		actions.keyDown(Keys.ENTER).perform();
		Thread.sleep(1000);
		actions.keyUp(Keys.ENTER).perform();
		return new HomePage();
	}

	public ForgotPasswordPage verifyForgotPasswordLink() throws InterruptedException, IOException {
		Thread.sleep(1000);
		ForgotPassword.click();
		Thread.sleep(4000);
		return new ForgotPasswordPage();

	}

	public String verifyTitle() {
		return driver.getTitle();
	}
}

package pageObjects;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseClass;

public class ForgotPasswordPage extends BaseClass {

	public ForgotPasswordPage() throws IOException {
		PageFactory.initElements(driver, this);
	}

	@FindBy(tagName = "h6")
	WebElement PageHeader;

	@FindBy(xpath = "//p[@class=\"oxd-text oxd-text--p orangehrm-card-note-text\"]")
	WebElement ErrorMessage;
	@FindBy(xpath = "//span[@class='oxd-text oxd-text--span orangehrm-forgot-password-reset--link']")
	WebElement ClickHereForLogin;

	public String verifyPageHeader() {
		return PageHeader.getText();
	}

	public String verifyErrorMessage() {
		return ErrorMessage.getText();
	}

	public Login verifyBackToLoginPageLink() throws IOException {
		ClickHereForLogin.click();
		return new Login();
	}
}

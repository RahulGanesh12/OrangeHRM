package pageObjects;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseClass;

public class HomePage extends BaseClass {
	public HomePage() throws IOException {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//img[@alt='client brand banner']")
	WebElement Logo;
	@FindBy(xpath = "//input[@placeholder='Search']")
	WebElement SearchOption;
	@FindBy(xpath = "//a[@class=\"oxd-main-menu-item\"]//span[text()='Admin']")
	WebElement AdminPageLink;
	@FindBy(xpath = "//p[@class='oxd-userdropdown-name']")
	WebElement UserName;
	@FindBy(xpath = "//button[@class='oxd-icon-button oxd-main-menu-button']")
	WebElement MenuButton;
	@FindBy(xpath = "//span[@class=\"oxd-text oxd-text--span oxd-main-menu-item--name\"]")
	List<WebElement> SideBarOptions;

	public boolean verifyLogoDisplayed() throws InterruptedException {
		return Logo.isDisplayed();
	}

	public OrangeHRMSoftwarePage verifyIfClickingLogoLeadsToSoftwarePage() throws InterruptedException {
		if (Logo.isEnabled() == true) {
			Logo.click();
			return new OrangeHRMSoftwarePage();
		} else {
			return null;
		}
	}

	public boolean verifyMenuButtonFunctionality() throws InterruptedException {
		if (MenuButton.isEnabled() == true) {
			MenuButton.click();
			return true;
		} else {
			return false;
		}
	}

	public boolean verifySearchFunction(String InputValues) throws InterruptedException {
		boolean status = true;
		SearchOption.sendKeys(InputValues);
		for (int i = 0; i < SideBarOptions.size(); i++) {
			Thread.sleep(1000);
			String options = SideBarOptions.get(i).getText();
			if (options.equalsIgnoreCase(InputValues)) {
				status = false;
				break;
			}
		}
		return status;
	}
}
package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage {
	public WebDriver driver;

	public LogInPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@name='username']")
	WebElement userNameField;
	@FindBy(name = ("password"))
	WebElement passWordField;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement signInTab;
	@FindBy(xpath = "//div[@class='container-fluid']//following::p[text()='Manage Pages']")
	WebElement managePagesTab;
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	WebElement alertText;

	public LogInPage enterUserNameOnUserNameField(String userName) {
		userNameField.sendKeys(userName);
		return this;
	}

	public LogInPage enterPasswordOnPasswordField(String passWord) {
		passWordField.sendKeys(passWord);
		return this;
	}

	public LogInPage clickOnTheSignInButton() {
		signInTab.click();
		return this;
	}

	public boolean isHomePageDisplayed() {
		return managePagesTab.isDisplayed();

	}

	public boolean isErrorMessageDisplayed() {
		return alertText.isDisplayed();
	}

}

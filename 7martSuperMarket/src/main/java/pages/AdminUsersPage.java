package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import utilities.PageUtility;
import utilities.WaitUtility;

public class AdminUsersPage {
	public WebDriver driver;
	
	public AdminUsersPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//div[@class='container-fluid']//child::a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin']") private WebElement moreInfoIcon;
	@FindBy(xpath="//a[@onclick='click_button(1)']")private WebElement newButton;
	@FindBy(xpath="//div[@class='form-group']//child::input[@type='text']") private WebElement usernameField;
	@FindBy(xpath="//input[@id='password']") private WebElement passwordField;
	@FindBy(xpath="//select[@id=\"user_type\"]") private WebElement userTypeDropDown;
	@FindBy(xpath="//button[@name='Create']") private WebElement saveButton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") private WebElement alertText;
	
	
	public AdminUsersPage clickOnThemoreInfoIcon() {
		moreInfoIcon.click();
		return this;
	}

	public AdminUsersPage clickOnNewButton() {
		WaitUtility.waitForElementToBeClickable(driver, newButton);
		newButton.click();
		return this;
	}
	public AdminUsersPage enterTextOnUsernameField(String userNameValue) {
		usernameField.sendKeys(userNameValue);
		
		return this;
	}
	public AdminUsersPage enterTextOnPasswordField(String passWordValue) {
		PageUtility.moveToElement(passwordField, driver);
		passwordField.sendKeys(passWordValue);
		return this;
	}
	
	public AdminUsersPage selectDropDownAdminFromList(String userType) {
		
		PageUtility.selectOptionFromDropDown(userTypeDropDown, driver);
		PageUtility.selectDropdownByValue(userTypeDropDown, driver, userType);
		WaitUtility.waitForElement(driver, userTypeDropDown);
		return this;
	}
	
	public AdminUsersPage clickOnSaveButton() {
		saveButton.click();
		return this;
	}
	public boolean isAlertDispayedForUserCreation() {
		WaitUtility .waitForAlertVisibility(driver, alertText);
		return alertText.isDisplayed();
		
	}
	

}

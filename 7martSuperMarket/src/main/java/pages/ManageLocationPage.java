package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;
import utilities.WaitUtility;

public class ManageLocationPage {
	public WebDriver driver;

	public ManageLocationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='small-box bg-info']//child::a[@href='https://groceryapp.uniqassosiates.com/admin/list-location']")
	private WebElement moreInfoIcon;
	@FindBy(xpath = "//table/tbody/tr[1]/td[6]")
	private WebElement deleteButton;
	@FindBy(xpath = "//table/tbody/tr[1]/td[6]//a[@href='https://groceryapp.uniqassosiates.com/admin/Location/edit?edit=1712&page_ad=1']")
	private WebElement editButton;
	@FindBy(xpath = "//input[@placeholder='Enter the Delivery Charge']")
	private WebElement deliveryChargeField;
	@FindBy(xpath = "//button[@name='update']")
	private WebElement updateButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement alertText;

	public ManageLocationPage clickOnThemoreInfoIcon() {
		moreInfoIcon.click();
		return this;
	}

	public ManageLocationPage clickOnEditButton() {
		editButton.click();
		return this;
	}

	public ManageLocationPage editTheDeliveryChargeOfFirstLocation() {
		deliveryChargeField.clear();
		return this;
	}

	public ManageLocationPage enterTheNewDeliveryCharge(String charge) {
		PageUtility.moveToElement(deliveryChargeField, driver);
		PageUtility.scroll(updateButton, driver);
		deliveryChargeField.sendKeys(charge);
		return this;
	}

	public ManageLocationPage clickOnUpdateButton() {
		WaitUtility.waitForElementToBeClickable(driver, updateButton);
		updateButton.click();
		return this;
	}

	public boolean isAlertDisplayed() {
		return alertText.isDisplayed();

	}

}

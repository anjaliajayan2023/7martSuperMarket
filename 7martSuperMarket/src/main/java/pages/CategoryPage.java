package pages;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.FileUploadUtility;
import utilities.GeneralUtility;
import utilities.PageUtility;
import utilities.WaitUtility;

public class CategoryPage {
	public WebDriver driver;

	public CategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@name='username']")
	private WebElement userNameField;
	@FindBy(name = ("password"))
	private WebElement passWordField;
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement signInTab;
	@FindBy(xpath = "//div[@class='container-fluid']//child::a[@href='https://groceryapp.uniqassosiates.com/admin/list-category']")
	private WebElement moreInfoIcon;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/Category/add']")
	private WebElement newButton;
	@FindBy(xpath = "//input[@id='category']")
	private WebElement categorytextfield;
	@FindBy(xpath = "//li[@id='134-selectable']")
	private WebElement discountfield;
	@FindBy(xpath = "//div[@class='ms-selection']//child::ul[@class='ms-list']")
	private WebElement discountDestinationField;
	@FindBy(xpath = "//input[@id='main_img']")
	private WebElement chooseFile;
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement saveButton;
	@FindBy(xpath = "//div[contains(@class,'alert-success')]")
	private WebElement alertText;

	public CategoryPage clickOnThemoreInfoIcon() {
		moreInfoIcon.click();
		return this;
	}

	public CategoryPage clickOnNewButton() {
		newButton.click();
		return this;
	}

	public CategoryPage enterTextOnCategoryField(String categoryItem) {

		categorytextfield.sendKeys(categoryItem);
		return this;
	}

	public CategoryPage clickOnDiscountField() {
		PageUtility.clickAndHoldOnElement(discountfield, driver);
		discountfield.click();
		return this;
	}

	public CategoryPage uploadImage() throws AWTException {
		String filePath = GeneralUtility.APPLEIMAGEFILE;
		FileUploadUtility fileuploadutility = new FileUploadUtility();
		fileuploadutility.fileUploadUsingSendKeys(chooseFile, filePath);
		return this;
	}

	public CategoryPage clickOnSaveButton() {

		PageUtility.javaScriptExecutorForClick(driver, saveButton);
		saveButton.click();
		return this;
	}

	public boolean isAlertMessageDisplayed() {
		WaitUtility.waitForAlertVisibility(driver, alertText);
		return alertText.isDisplayed();

	}

}

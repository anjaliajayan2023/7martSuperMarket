package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



import utilities.FileUploadUtility;
import utilities.GeneralUtility;
import utilities.PageUtility;
import utilities.WaitUtility;

public class MobileSliderPage {
	public WebDriver driver;
	public MobileSliderPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//div[@class='small-box bg-info']//child::a[@href='https://groceryapp.uniqassosiates.com/admin/list-mobileslider']") private WebElement moreInfoIcon;
@FindBy(xpath="//a[@onclick='click_button(1)']") private WebElement newButton;
@FindBy(xpath="//div[@class='form-group']//child::select") private WebElement categoryDropDown;
@FindBy(xpath="//span[@class='error']//following-sibling::input") private WebElement chooseFile;
@FindBy(xpath="//button[@type='submit']") private WebElement saveButton;
@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") private WebElement alertText;

public MobileSliderPage clickOnThemoreInfoIcon() {
	moreInfoIcon.click();
	return this;
}

public MobileSliderPage clickOnNewButton() {
	WaitUtility.waitForElementToBeClickable(driver, newButton);
	newButton.click();
	return this;
}

public MobileSliderPage selectTheDropDown(String category) {
	WaitUtility.waitForElement(driver, categoryDropDown);
	PageUtility.selectDropdownByValue(categoryDropDown, driver, category);
	return this;
}
public MobileSliderPage clickOnChooseFile() {
	String filepath=GeneralUtility.IMAGEFILE;
	FileUploadUtility fileuploadutility = new FileUploadUtility();
	fileuploadutility.fileUploadUsingSendKeys(chooseFile, filepath);

	return this;
}

public MobileSliderPage clickOnSaveButton() {
	WaitUtility.waitForElementToBeClickable(driver, saveButton);
	PageUtility.javaScriptExecutorForClick(driver, saveButton);
	return this;
}
public boolean isAlertDisplayed() {
	WaitUtility.waitForAlertVisibility(driver, alertText);
	return alertText.isDisplayed();

}



}

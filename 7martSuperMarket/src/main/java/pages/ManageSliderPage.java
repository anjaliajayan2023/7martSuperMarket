package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.FileUploadUtility;
import utilities.GeneralUtility;
import utilities.PageUtility;


public class ManageSliderPage {
	public WebDriver driver;
	public ManageSliderPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//div[@class='col-lg-3 col-6']//child::a[@href='https://groceryapp.uniqassosiates.com/admin/list-slider']") private WebElement moreInfoIcon;
	@FindBy(xpath="//div[@class='col-sm-12']//child::a[@class='btn btn-rounded btn-danger']") private WebElement newButton;
	@FindBy(xpath="//div[contains(@class,'form-group')]//following::input[@type='file']") private WebElement choosefile;
@FindBy(xpath="//div[@class='form-group']//following::input[@name='link']") private WebElement linkTextField;
@FindBy(xpath="//div[@class='card-footer']//following::button[@name='create']") private WebElement saveButton;
@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") private WebElement alertText;
@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/slider/delete?del=857&page_ad=1']") private WebElement deleteButton;


public ManageSliderPage clickOnMoreInfoIcon() {
	moreInfoIcon.click();
	return this;
}
public ManageSliderPage clickOnNewButton() {
	newButton.click();
	return this;
}
public ManageSliderPage clickOnChooseFileButtonToUploadImage() {
		String filepath=GeneralUtility.IMAGEFILE;
	FileUploadUtility fileuploadutility=new FileUploadUtility();
	fileuploadutility.fileUploadUsingSendKeys(choosefile, filepath);
	return this;
}
public ManageSliderPage enterTheLinkInLinkTextField(String link) {
	linkTextField.sendKeys(link);
	return this;
}


public ManageSliderPage clickOnSaveButton() {
	PageUtility.javaScriptExecutorForClick(driver, saveButton);
	
	return this;
}
public boolean isAlertDisplayed() {
return alertText.isDisplayed();
	}
public ManageSliderPage clickOnDeleteButton() {
	deleteButton.click();
	return this;
}
public boolean isDeleteButtonSelected() {
return deleteButton.isSelected();
}
}

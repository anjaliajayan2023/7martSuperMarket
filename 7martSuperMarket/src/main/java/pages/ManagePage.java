package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManagePage {
	public WebDriver driver;

	public ManagePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//input[@name='username']")
	WebElement userNameField;
	@FindBy(name = ("password"))
	WebElement passWordField;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement signInTab;
	@FindBy(xpath = "//div[@class='small-box bg-info']//child::a[@href='https://groceryapp.uniqassosiates.com/admin/list-page']")
	WebElement moreInfoButton;
	@FindBy(xpath = "//a[@onclick='click_button(2)']")
	WebElement searchButton;
	@FindBy(xpath = "//input[@placeholder='Title']")
	WebElement titletextBar;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement titleSearchbutton;
	@FindBy(xpath = "//div[@class='card-header']//following::h4[text()='List Pages']")
	WebElement listPages;
	@FindBy(xpath = "//center[contains(text(),'RESULT')]")
	WebElement resultNotFoundTextInListPage;
	@FindAll(@FindBy(xpath = "//tbody/tr/td[1]"))
	List<WebElement> listOfElements;
	@FindBy(xpath = "//tbody/tr[1]/td")
	WebElement tableRow;

	public ManagePage enterUserNameOnUserNameField(String userName) {
		userNameField.sendKeys(userName);
		return this;
	}

	public ManagePage enterPasswordOnPasswordField(String passWord) {
		passWordField.sendKeys(passWord);
		return this;

	}

	public ManagePage clickOnTheSignInButton() {
		signInTab.click();
		return this;
	}

	public ManagePage clickOnMoreInfoButton() {
		moreInfoButton.click();
		return this;
	}

	public ManagePage clickOnSearchButton() {
		searchButton.click();
		return this;
	}

	public ManagePage enterGroceryItemOnTitleBar(String title) {
		titletextBar.sendKeys(title);
		return this;
	}

	public ManagePage enterInvalidGroceryItemOnTitleBar(String inValidTitle) {

		titletextBar.sendKeys(inValidTitle);
		return this;
	}

	public ManagePage clickOnTitleSearchButton() {
		titleSearchbutton.click();
		return this;
	}

	public List<String> getAllListElementsInListPage() {
		List<String>listOfElementsInTable=new ArrayList<String>();
		for(WebElement listPage:listOfElements) {
			String listElement=listPage.getText();
			listOfElementsInTable.add(listElement);
		}
		return listOfElementsInTable;

	}

	public ManagePage isGroceryItemAvailableOnTheListPage() {
		titletextBar.getText();
		return this;
	}

	public boolean isListPagesDisplayedForTheSearchElement() {
		return listPages.isDisplayed();
	}

	public boolean isResultNotFoundDisplayedForTheSearchElement() {
		return resultNotFoundTextInListPage.isDisplayed();
	}

}

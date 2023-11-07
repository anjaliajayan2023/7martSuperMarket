package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageDeliveryBoyPage {
	public WebDriver driver;
	public ManageDeliveryBoyPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//table/tbody/tr[3]/td[6]")private WebElement statusButton;
	@FindBy(xpath="//div[@class='small-box bg-info']//child::a[@href='https://groceryapp.uniqassosiates.com/admin/list-deliveryboy']") private WebElement moreInfoIcon;
@FindBy(xpath="//a[@onclick='click_button(2)']") private WebElement searchButton;
@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']//following::h5") private WebElement alertText;


public ManageDeliveryBoyPage clickOnThemoreInfoIcon() {
	moreInfoIcon.click();
	return this;
}
public ManageDeliveryBoyPage statusOfTheButton() {
	statusButton.click();
	return this;
}
public String getTextOfAlert() {
	return alertText.getText();
}
public boolean isAlertDisplayed() {
	return alertText.isDisplayed();
}



}

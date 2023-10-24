package testscripts;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.obsqura.martSuperMarket.Base;

import pages.LogInPage;
import pages.MobileSliderPage;
import utilities.ExcelUtility;

public class MobileSliderTest extends Base {
	@Test
	public void verifyUserCanAddNewItemToMobileSliderList() {
		String userName = ExcelUtility.getString(0, 1, "LogInPage");
		String passWord = ExcelUtility.getString(1, 1, "LogInPage");

		String category = ExcelUtility.getNumeric(0, 1, "MobileSliderPage");
		LogInPage loginpage = new LogInPage(driver);
		loginpage.enterUserNameOnUserNameField(userName).enterPasswordOnPasswordField(passWord)
				.clickOnTheSignInButton();
		MobileSliderPage mobilesliderpage = new MobileSliderPage(driver);
		mobilesliderpage.clickOnThemoreInfoIcon().clickOnNewButton().selectTheDropDown(category).clickOnChooseFile()
				.clickOnSaveButton();
		boolean isListAddedsuccessfully = mobilesliderpage.isAlertDisplayed();
		assertTrue(isListAddedsuccessfully, "User is unable to add new item to mobileSlider List");
	}
}
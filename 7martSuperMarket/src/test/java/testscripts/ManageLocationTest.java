package testscripts;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.obsqura.martSuperMarket.Base;

import pages.LogInPage;
import pages.ManageLocationPage;
import utilities.ExcelUtility;

public class ManageLocationTest extends Base {
	@Test
	public void verifyUserIsAbleToEditTheDeliveryChargeAndUpdateNewChargeInTheField() {
		String userName = ExcelUtility.getString(0, 1, "LogInPage");
		String passWord = ExcelUtility.getString(1, 1, "LogInPage");
		String charge = ExcelUtility.getNumeric(0, 1, "ManageLocationPage");
		LogInPage loginpage = new LogInPage(driver);
		loginpage.enterUserNameOnUserNameField(userName).enterPasswordOnPasswordField(passWord)
				.clickOnTheSignInButton();
		ManageLocationPage managelocationpage = new ManageLocationPage(driver);
		managelocationpage.clickOnThemoreInfoIcon().clickOnEditButton().editTheDeliveryChargeOfFirstLocation()
				.enterTheNewDeliveryCharge(charge).clickOnUpdateButton();
		boolean isTheChargeUpdatedSuccessfully = managelocationpage.isAlertDisplayed();
		assertTrue(isTheChargeUpdatedSuccessfully, "User is unable to update the new deliverycharge in the field");
	}

}

package testscripts;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.obsqura.martSuperMarket.Base;

import pages.LogInPage;
import pages.ManageSliderPage;

import utilities.ExcelUtility;

public class ManageSliderTest extends Base {
	@Test
	public void verifyUserIsAbleToUploadImageInManageSlider() {
		String userName = ExcelUtility.getString(0, 1, "LogInPage");
		String passWord = ExcelUtility.getString(1, 1, "LogInPage");

		String link =ExcelUtility.getString(0, 1, "ManageSliderPage");
		LogInPage loginpage = new LogInPage(driver);
		loginpage.enterUserNameOnUserNameField(userName).enterPasswordOnPasswordField(passWord)
				.clickOnTheSignInButton();
		ManageSliderPage managesliderpage = new ManageSliderPage(driver);
		managesliderpage.clickOnMoreInfoIcon().clickOnNewButton().clickOnChooseFileButtonToUploadImage().enterTheLinkInLinkTextField(link).clickOnSaveButton();
		boolean isManageSliderCreatedSuccessfully=managesliderpage.isAlertDisplayed();
		assertTrue(isManageSliderCreatedSuccessfully, "User is unable to upload image in manage slider");
	}
	@Test
	public void verifyUserIsAbleToDeleteTheUploadedImageInManageSliderList() {
		String userName = ExcelUtility.getString(0, 1, "LogInPage");
		String passWord = ExcelUtility.getString(1, 1, "LogInPage");

		String link =ExcelUtility.getString(0, 1, "ManageSliderPage");
		LogInPage loginpage = new LogInPage(driver);
		loginpage.enterUserNameOnUserNameField(userName).enterPasswordOnPasswordField(passWord)
				.clickOnTheSignInButton();
		ManageSliderPage managesliderpage = new ManageSliderPage(driver);
		managesliderpage.clickOnMoreInfoIcon().clickOnNewButton().clickOnChooseFileButtonToUploadImage().enterTheLinkInLinkTextField(link).clickOnSaveButton().clickOnDeleteButton();
		boolean isTheUploadedImageDeleted=managesliderpage.isDeleteButtonSelected();
		assertTrue(isTheUploadedImageDeleted,"User is unable to delete the  uploaded image in list");
	}

}

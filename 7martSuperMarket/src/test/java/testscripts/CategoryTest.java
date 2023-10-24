package testscripts;

import static org.testng.Assert.assertTrue;

import java.awt.AWTException;

import org.testng.annotations.Test;

import com.obsqura.martSuperMarket.Base;

import pages.CategoryPage;
import pages.LogInPage;
import utilities.ExcelUtility;



public class CategoryTest extends Base {
	@Test
	public void verifyUserIsAbleToAddNewCategoryIntoListPage() throws AWTException {

		String userName = ExcelUtility.getString(0, 1, "LogInPage");
		String passWord =  ExcelUtility.getString(1, 1, "LogInPage");
		String categoryItem = ExcelUtility.getString(0, 1, "CategoryPage");

		LogInPage loginpage = new LogInPage(driver);
		loginpage.enterUserNameOnUserNameField(userName).enterPasswordOnPasswordField(passWord)
				.clickOnTheSignInButton();
		CategoryPage categorypage = new CategoryPage(driver);
		categorypage.clickOnThemoreInfoIcon().clickOnNewButton().enterTextOnCategoryField(categoryItem).clickOnDiscountField()
				.uploadImage().clickOnSaveButton();
		
		boolean isUserAbleToAddNewCategory = categorypage.isAlertMessageDisplayed();
		assertTrue(isUserAbleToAddNewCategory, "User is unable to add new category into List page");
	}
	

}

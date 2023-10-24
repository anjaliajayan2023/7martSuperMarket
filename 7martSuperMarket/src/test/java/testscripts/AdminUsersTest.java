package testscripts;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.obsqura.martSuperMarket.Base;

import pages.AdminUsersPage;
import pages.LogInPage;
import utilities.ExcelUtility;

public class AdminUsersTest extends Base{
	@Test
	public void verifyUserIsAbleToAddAdminUserTypeToList() {
		String userName = ExcelUtility.getString(0, 1, "LogInPage");
		String passWord =  ExcelUtility.getString(1, 1, "LogInPage");
		String userNameValue=ExcelUtility.getString(0, 1, "AdminUsersPage");
		String passWordValue=ExcelUtility.getString(1, 1, "AdminUsersPage");
		String userType=ExcelUtility.getString(2,1, "AdminUsersPage");
		LogInPage loginpage = new LogInPage(driver);
		loginpage.enterUserNameOnUserNameField(userName).enterPasswordOnPasswordField(passWord)
				.clickOnTheSignInButton();
		AdminUsersPage adminuserspage=new AdminUsersPage(driver);
		adminuserspage.clickOnThemoreInfoIcon().clickOnNewButton().enterTextOnUsernameField(userNameValue).enterTextOnPasswordField(passWordValue).selectDropDownAdminFromList(userType).clickOnSaveButton();
		boolean isUserAddedSuccessfully=adminuserspage.isAlertDispayedForUserCreation();
		assertTrue(isUserAddedSuccessfully,"User is unable  to add new usertype to list");
	}

}

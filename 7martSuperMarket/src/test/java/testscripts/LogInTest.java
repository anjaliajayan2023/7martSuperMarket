package testscripts;


import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.obsqura.martSuperMarket.Base;

import pages.LogInPage;
import utilities.ExcelUtility;

public class LogInTest extends Base {

	@Test
	public void verifyUserIsAbleToLoginWithValidCredentials() {
		String userName = ExcelUtility.getString(0, 1, "LogInPage");
		String passWord = ExcelUtility.getString(1, 1, "LogInPage");

		LogInPage loginpage = new LogInPage(driver);
		loginpage.enterUserNameOnUserNameField(userName).enterPasswordOnPasswordField(passWord)
				.clickOnTheSignInButton();
		boolean isHomePageAvailable = loginpage.isHomePageDisplayed();
		assertTrue(isHomePageAvailable, "User is unable to login with valid credentials");
	}

	@Test
	public void verifyUserIsUnableToLoginWithInvalidUsernameAndPassword() {
		String userName =ExcelUtility.getString(1, 1, "LogInPage");
		String passWord = ExcelUtility.getString(2, 1, "LogInPage");
		LogInPage loginpage = new LogInPage(driver);
		loginpage.enterUserNameOnUserNameField(userName).enterPasswordOnPasswordField(passWord)
				.clickOnTheSignInButton();
		boolean isErrorMessageDisplayedForInvalidCredentials = loginpage.isErrorMessageDisplayed();
		assertTrue(isErrorMessageDisplayedForInvalidCredentials, "User is able to login with invalid credentials");
	}

	@Test
	public void verifyUserIsunableToLoginWithValidUsernameAndInValidPassword() {
		String userName =ExcelUtility.getString(2, 1, "LogInPage");
		String passWord = ExcelUtility.getString(3, 1, "LogInPage");
		LogInPage loginpage = new LogInPage(driver);
		loginpage.enterUserNameOnUserNameField(userName).enterPasswordOnPasswordField(passWord)
				.clickOnTheSignInButton();
		boolean isErrorMessageDisplayedForInvalidPassword = loginpage.isErrorMessageDisplayed();
		assertTrue(isErrorMessageDisplayedForInvalidPassword, "User is able to login with invalid password");
	}

	@Test
	public void verifyUserIsUnableToLoginWithInvalidUsernameAndValidPassword() {
		String userName =ExcelUtility.getString(3, 1, "LogInPage");
		String passWord = ExcelUtility.getString(4, 1, "LogInPage");
		LogInPage loginpage = new LogInPage(driver);
		loginpage.enterUserNameOnUserNameField(userName).enterPasswordOnPasswordField(passWord)
				.clickOnTheSignInButton();
		boolean isErrorMessageDisplayedForInvalidUsername = loginpage.isErrorMessageDisplayed();
		assertTrue(isErrorMessageDisplayedForInvalidUsername, "User is able to login with invalid username");
	}
}

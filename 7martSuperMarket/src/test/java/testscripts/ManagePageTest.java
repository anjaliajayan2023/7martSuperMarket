package testscripts;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;


import org.testng.annotations.Test;

import com.obsqura.martSuperMarket.Base;

import pages.LogInPage;
import pages.ManagePage;
import utilities.ExcelUtility;

public class ManagePageTest extends Base {

	@Test
	public void verifyUserIsAbleToSearchTheGroceryItemInSearchButton() {
		String title = ExcelUtility.getString(0, 1, "ManagePage");
		String userName = ExcelUtility.getString(0, 1, "LogInPage");
		String passWord = ExcelUtility.getString(1, 1, "LogInPage");
		LogInPage loginpage = new LogInPage(driver);
		loginpage.enterUserNameOnUserNameField(userName).enterPasswordOnPasswordField(passWord)
				.clickOnTheSignInButton();
		ManagePage managepage = new ManagePage(driver);
		managepage.clickOnMoreInfoButton().clickOnSearchButton().enterGroceryItemOnTitleBar(title)
				.clickOnTitleSearchButton().isGroceryItemAvailableOnTheListPage();
		boolean isListPagesDisplayedForElement = managepage.isListPagesDisplayedForTheSearchElement();
		assertTrue(isListPagesDisplayedForElement, "User is unable to search the item using search button");

	}

	@Test

	public void verifyUserIsUnableToSearchInvalidIteminSearchButton() {
		String inValidTitle =ExcelUtility.getString(1, 1, "ManagePage");
		String userName = ExcelUtility.getString(0, 1, "LogInPage");
		String passWord = ExcelUtility.getString(1, 1, "LogInPage");
		LogInPage loginpage = new LogInPage(driver);
		loginpage.enterUserNameOnUserNameField(userName).enterPasswordOnPasswordField(passWord)
				.clickOnTheSignInButton();
		ManagePage managepage = new ManagePage(driver);
		managepage.clickOnMoreInfoButton().clickOnSearchButton().enterInvalidGroceryItemOnTitleBar(inValidTitle)
				.clickOnTitleSearchButton();

		boolean isResultNotFoundForTheSearchElement = managepage.isResultNotFoundDisplayedForTheSearchElement();
		assertTrue(isResultNotFoundForTheSearchElement, "User is able to search the invaliditem in ListPage");
	}

	@Test
	public void verifyUserIsableToFindAllListOfOptionsForTheElement() {
		String title = ExcelUtility.getString(0, 1, "ManagePage");
		String userName = ExcelUtility.getString(0, 1, "LogInPage");
		String passWord = ExcelUtility.getString(1, 1, "LogInPage");
		int expectedRows = 2;

		LogInPage loginpage = new LogInPage(driver);
		loginpage.enterUserNameOnUserNameField(userName).enterPasswordOnPasswordField(passWord)
				.clickOnTheSignInButton();
		ManagePage managepage = new ManagePage(driver);
		managepage.clickOnMoreInfoButton().clickOnSearchButton().enterGroceryItemOnTitleBar(title)
				.clickOnTitleSearchButton();

		List<String> actualRows = managepage.getAllListElementsInListPage();
		assertEquals(expectedRows, actualRows, "Expected List of Elements are anot available in the listPage");
	}
}

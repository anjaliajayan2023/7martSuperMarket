package utilities;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


public class PageUtility {
	
	public static void clickAndHoldOnElement(WebElement element, WebDriver driver) 
	{
		Actions actions = new Actions(driver);
		actions.clickAndHold(element).build().perform();
		
	}
	public static void moveToElement(WebElement element, WebDriver driver) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).click().perform();
	}
	public static void contextClick(WebElement element, WebDriver driver) {
		Actions actions = new Actions(driver);
		actions.contextClick(element);
	}
	public static void doubleClick(WebElement element, WebDriver driver) {
		Actions actions = new Actions(driver);
		actions.doubleClick(element);
	}
	public static void dragAndDrop(WebElement element, WebDriver driver) {
		Actions actions = new Actions(driver);
		actions.dragAndDrop(element, element);
	}
	public static void selectDropdownByIndex(WebElement element, WebDriver driver) {
		Select select=new Select(element);
		select.selectByIndex(0);
		
	}
	public static void selectDropdownByValue(WebElement element, WebDriver driver, String value) {
		Select select=new Select(element);
		select.selectByValue(value);
	}
	public static void selectDropDownByVisibleText(WebElement element, WebDriver driver, String text) {
		Select select=new Select(element);
		select.selectByVisibleText(text);
	}
	public static void selectOptionFromDropDown(WebElement element, WebDriver driver) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).click().perform();
		
	}
	
	public static void javaScriptExecutorForClick(WebDriver driver,WebElement element)
	{
		JavascriptExecutor executor=(JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
	}
	public static void acceptTheAlert(WebElement element, WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	public static void dismissTheAlert(WebElement element, WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	public static void getTextOfTheAlert(WebElement element, WebDriver driver) {
		driver.switchTo().alert().getText();
	}
	public static void scroll(WebElement element, WebDriver driver) {
		JavascriptExecutor executor = (JavascriptExecutor)driver;	
		executor.executeScript("window.scrollBy(0,100)", "");
	}
	 
	
	
}
	
	



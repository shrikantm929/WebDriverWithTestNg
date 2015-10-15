package common;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Page {

	public static WebDriver driver;
	
	protected WebElement findElement(String how, String what) {
		return null;
	//	return locator.findElement(how, what);
	}
	
	protected List<WebElement> findElements(String how, String what) {
		return null;
	//	return locator.findElements(how, what);
	}
	
	public boolean isElementDisplay(String locator, String expected_text)
			throws InterruptedException {
		WebElement label_field = findElement("cssSelector", locator);
		if (expected_text.equals(label_field.getText())) {
			return true;
		}
		return false;
	}
	
	abstract public Boolean waitForLoad();

	public static WebElement getElementByClassName(String locater){
		return driver.findElement(By.className(locater));
	}
	
	public static WebElement getElementByName(String locater){
		return driver.findElement(By.name(locater));
	}
	
	public static WebElement getElementById(String locater){
		return driver.findElement(By.id(locater));
	}
	
	public static WebElement getElementByTagName(String locater){
		return driver.findElement(By.tagName(locater));
	}
	
	public static WebElement getElementByXpath(String locater){
			return driver.findElement(By.xpath(locater));
	}
	
	public static WebElement getElementByCSS(String locater){
		return driver.findElement(By.cssSelector((locater)));
	}
	
}

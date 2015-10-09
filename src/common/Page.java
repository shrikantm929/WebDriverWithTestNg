package common;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Page {

	protected WebDriver driver;
	
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
/*
	protected Boolean waitForID(String locator) {
			return waitForID(locator, 180);
	}

	protected Boolean waitForXp(String locator) {
			return waitForXp(locator, 180);
	}

	protected Boolean waitForCss(String locator) {
		return waitForCss(locator, 180);
	}*/
	
	/*protected Boolean waitForXp(String locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		String wait_id = this.locator.get(locator);
		WebElement element = null;
		try {
			element = wait.until(ExpectedConditions.presenceOfElementLocated(By
					.xpath(wait_id)));
			System.out.println("element ::::::::::::" + element);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		if (element == null) {
			return false;
		}
		return true;
	}
*/
	/*protected Boolean waitForCss(String locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		String wait_id = this.locator.get(locator);
		WebElement element = null;
		try {
			element = wait.until(ExpectedConditions.presenceOfElementLocated(By
					.cssSelector(wait_id)));
		} catch (Exception e) {

			e.printStackTrace();
			return false;
		}
		if (element == null) {
			return false;
		}
		return true;
	}*/
	
	/*protected Boolean waitForID(String locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		String wait_id = this.locator.get(locator);
		WebElement element = null;
		try {
			element = wait.until(ExpectedConditions.presenceOfElementLocated(By
					.id(wait_id)));
		} catch (Exception e) {

			e.printStackTrace();
			return false;
		}
		if (element == null) {
			return false;
		}
		return true;
	}*/
	
}

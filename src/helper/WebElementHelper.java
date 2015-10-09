package helper;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class WebElementHelper extends SetUp {
 
	public static void typeInTextBox(String locater, String Value){
		WebElement element = getElement(locater);
		element.sendKeys(Value);		
	}
	
	public static void typeinTextusingXpath(String locater, String Value){
		WebElement element = getElementByXpath(locater);
		element.sendKeys(Value);
	}
	
	public static void ClickonElement(String LinkText){
		WebElement element = getElement(LinkText);
		element.click();
	}
	
	public static void ClickCheckBox(String locater){
		WebElement element = getElement(locater);
		element.click();
	}
	
	public static boolean isChecked(String locater){
		WebElement element = getElement(locater);
		boolean status = element.isSelected();
		return status;
	}
	public static void ClickButton(String locater){
		WebElement element = getElement(locater);
		element.click();
	}
	
}

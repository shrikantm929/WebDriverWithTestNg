package helper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import common.Page;


public class WebElementHelper extends Page {
 
	protected static Select select=null;
	protected static Alert alert=null;
	
	public static void typeInTextBox(String locater, String Value){
		WebElement element = getElementByXpath(locater);
		element.sendKeys(Value);		
	}
	
	
	public static void typeinTextusingCss(String locater, String Value){
		WebElement element = getElementByCSS(locater);
		element.sendKeys(Value);
	}
	
	public static void typeinTextusingXpath(String locater, String Value){
		WebElement element = getElementByXpath(locater);
		element.sendKeys(Value);
	}
	
	public static void ClickonElement(String xpath){
		WebElement element = getElementByXpath(xpath);
		element.click();
	}
	
	public static void ClickCheckBox(String locater){
		WebElement element = getElementByXpath(locater);
		element.click();
	}
	
	public static boolean isChecked(String locater){
		WebElement element = getElementByXpath(locater);
		boolean status = element.isSelected();
		return status;
	}
	public static void ClickButton(String locater){
		WebElement element = getElementByXpath(locater);
		element.click();
	}
	
	
	public static void select(String locater, int index){		
		select = new Select(getElementByXpath(locater));
		select.selectByIndex(index);
	}

	public static void select(String locater, String Value){		
		select = new Select(getElementByXpath(locater));
		select.selectByValue(Value);
	}

	public static void selectbyVisText(String locater, String text){		
		select = new Select(getElementByXpath(locater));
		select.selectByVisibleText(text);
	}
	
	public static void TakeScreenShot(String FileName) throws IOException{
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);		
		FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir")+"\\"+"test-output"+"\\"+FileName+".png"));
	}
	
	public static void switchTo(int Index){
		try {
			List<String> win = new ArrayList<String>(driver.getWindowHandles()); 			
			driver.switchTo().window(win.get(Index));
		} catch (IndexOutOfBoundsException e) {
			throw new IndexOutOfBoundsException("index out of bound exception : "+Index);
		}
	}
	
	
	public static void switchToParentWithClosingChild(){
		List<String> win = new ArrayList<String>(driver.getWindowHandles()); 
		
		for(int i=0; i<win.size();i++){
			driver.switchTo().window(win.get(i));
			driver.close();
		}
		driver.switchTo().window(win.get(0)); 
	}
	
	
	// Alert Helpers
	public static void clickOk(){
		alert=driver.switchTo().alert();
		alert.accept();
	}
	
	public static void clickCancel(){
		alert=driver.switchTo().alert();
		alert.dismiss();
	}
	public static String getText(){
		alert=driver.switchTo().alert();
		return alert.getText();
	}
	
	public static void sendKeys(String Value){
		alert=driver.switchTo().alert();
		alert.sendKeys(Value);
		alert.accept();
	}
	
	//Navigation
	
	public static void back(){
		driver.navigate().back();
	}
	
	public static void forward(){
		driver.navigate().forward();
	}
	
	public static void navigateToPage(String url){
		driver.navigate().to(url);
	}
	
	public static void refresh(){
		driver.navigate().refresh();
	}
	
	// handling tabs	
	public static void openNewTab(){
		Actions act = new Actions(driver);
		act.keyDown(Keys.CONTROL).sendKeys("t").keyUp(Keys.CONTROL).build().perform();
		
	}
	
	public static void executeScript(String script){
		JavascriptExecutor exe = (JavascriptExecutor)driver;
		exe.executeScript(script);
	}


	@Override
	public Boolean waitForLoad() {		
		return null;
	}
	
}

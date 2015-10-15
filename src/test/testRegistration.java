package test;

import java.io.IOException;
import java.time.zone.ZoneOffsetTransitionRule.TimeDefinition;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.testng.Assert;

import helper.SetUp;
import helper.WebElementHelper;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.google.common.base.Predicate;

public class testRegistration extends SetUp {
	
	

	/*@Test
	public void withValidDetails(){
		try {
			WebElementHelper.typeinTextusingXpath("//input[@name='first_name']", "First-Name");
			WebElementHelper.typeinTextusingXpath("//input[@name='last_name']", "First-Name");
			
			WebElementHelper.ClickonElement("//input[@value='single']");
			WebElementHelper.ClickCheckBox("//input[@value='dance']");
			
			WebElementHelper.select("//select[@id='dropdown_7']", 80);
			
			WebElementHelper.select(".//*[@id='mm_date_8']", 9);
			WebElementHelper.select(".//*[@id='dd_date_8']", 10);
			WebElementHelper.select(".//*[@id='yy_date_8']", "2000");
			
			WebElementHelper.typeinTextusingXpath("//*[@id='phone_9']", "9876543210");
			WebElementHelper.typeinTextusingXpath("//*[@id='username']", "hello127734");
			WebElementHelper.typeinTextusingXpath("//*[@id='email_1']", "automate.tem731723@gmail.com");
			
			WebElementHelper.typeinTextusingXpath("//*[@id='description']", "hello this is automation");
			WebElementHelper.typeinTextusingXpath("//*[@id='password_2']", "mercury@123");
			WebElementHelper.typeinTextusingXpath("//*[@id='confirm_password_password_2']", "mercury@123");
			WebElementHelper.TakeScreenShot("withValidDetails");			
			WebElementHelper.ClickButton("//input[@name='pie_submit']");
			
			Assert.assertTrue(WebElementHelper.driver.findElement(By.xpath(".//*[@class='piereg_message']")).getText().contains("Thank you"));
		
			
			System.out.println("Done");
		} catch (Exception e) {
			
			e.printStackTrace();
		}		
		
	}*/

	


	/*@Test
	public void checkMandatoryFields() throws IOException{
		
		
		WebElementHelper.typeinTextusingXpath("//input[@name='first_name']"," ");
		WebElementHelper.ClickonElement("//input[@value='single']");
		Assert.assertTrue(WebElementHelper.driver.findElement(By.xpath("//span[contains(text(),'This field is required')]")).getText().contains("field is required"));
	
		WebElementHelper.typeinTextusingXpath("//input[@name='first_name']", "First-helloName");
		WebElementHelper.typeinTextusingXpath("//input[@name='last_name']", "First-Name");
		
		WebElementHelper.typeinTextusingXpath("//*[@id='phone_9']", "9870");
		WebElementHelper.typeinTextusingXpath("//*[@id='username']", "hello12773");
		Assert.assertTrue(WebElementHelper.driver.findElement(By.xpath("//span[contains(text(),'* Minimum 10 Digits starting with Country Code')]")).getText().contains("starting with"));
		
		WebElementHelper.TakeScreenShot("checkValidation");
	}*/
	
	@Test
	public void testWait(){
		 
		
		WebElementHelper.typeinTextusingXpath("//input[@name='first_name']"," ");
		WebElementHelper.ClickonElement("//input[@value='single']");
		//Assert.assertTrue(WebElementHelper.driver.findElement(By.xpath("//span[contains(text(),'This field is required')]")).getText().contains("field is required"));
	
		
	/*	WebElementHelper.typeinTextusingXpath("//input[@name='first_name']", "s");
		WebElementHelper.typeinTextusingCss("#sb_ifc0", "s");*/
		
				
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.pollingEvery(1, TimeUnit.SECONDS);
		wait.ignoring(NoSuchElementException.class);
		
		Predicate<WebDriver> p = new Predicate<WebDriver>() {
			
			@Override
			public boolean apply(WebDriver arg0) {
				if (arg0.findElement(By.xpath("//span[contains(text(),'This field is required')]")).getText().equalsIgnoreCase("* This field is required")){
					return true;
				}
				else{
					System.out.println(arg0.findElement(By.xpath("//span[contains(text(),'This field is required')]")).getText());
					return false;
				}
			
			}
		};
		
		wait.until(p);
		System.out.println("element found");
		
	}
	
	@Test
	public void testAlert(){
		
		driver.get("http://www.w3schools.com/js/tryit.asp?filename=tryjs_alert");
		driver.switchTo().frame(driver.findElement(By.id("iframeResult")));
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.pollingEvery(1, TimeUnit.SECONDS);
		
		WebElementHelper.ClickButton("//*[text()='Try it']");
		wait.until(ExpectedConditions.alertIsPresent());
		
		System.out.println("Text is ");
		
		
		
	}
	
	
}

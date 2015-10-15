package test;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import helper.SetUp;
import helper.WebElementHelper;

public class Test123 extends SetUp {

	/*@Test
	public void testTextBox(){
			
		System.out.println("----------Inside testTextBox()--------------");
	
		WebElementHelper.ClickonElement("//div[@id='compose']/child::a");
		WebElementHelper.typeinTextusingXpath(".//*[@id='to_field_1']", "shrikantm929@gmail.com");
		WebElementHelper.typeinTextusingXpath(".//*[@id='subject_1']", "Hello");
		WebElementHelper.ClickButton(".//*[@id='sendtop_1']");
		WebElementHelper.ClickButton("//button[contains(text(),'OK')]");
		
		//Assert.assertEquals(driver.getTitle(), "Find a Flight: Mercury Tours:");
	}*/
		
	
	@Test 
	public void bookOneWayTicket(){
		System.out.println("----------Inside testTextBox()--------------");		
		
		driver.get("http://google.com");
		WebElementHelper.back();
		WebElementHelper.forward();
		WebElementHelper.refresh();
		WebElementHelper.navigateToPage("http://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_prompt");
		driver.switchTo().frame(driver.findElement(By.id("iframeResult")));
		WebElementHelper.ClickButton("//button[text()='Try it']");
		
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.sendKeys("Shrikant");
		alert.accept();
		
		
	}
	
}

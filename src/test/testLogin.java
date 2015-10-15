package test;

import helper.WebElementHelper;

import org.testng.Assert;
import org.testng.annotations.Test;

public class testLogin {

	@Test
	public void loginWithValidDetails(){
		
		WebElementHelper.ClickonElement("//a[@class='login']");
		WebElementHelper.typeinTextusingXpath("//input[@id='email']", "automate.temp@gmail.com");
		WebElementHelper.typeinTextusingXpath("//input[@id='passwd']", "mercury@123");
		WebElementHelper.ClickButton("//button[@id='SubmitLogin']");
		
		Assert.assertEquals(WebElementHelper.getElementByXpath("//a[@class='account']/span").getText().toString(), "automate temp", "login failed");
		
		WebElementHelper.ClickonElement("//a[@class='logout']");
		Assert.assertEquals(WebElementHelper.getElementByXpath("//a[@class='login']").getText().toString(), "Sign in", "logout Failed");
		
	}
	
}

package helper;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import common.ReadConfig;

public class SetUp {
	
	
	public static WebDriver driver = null;
	protected ProfilesIni ini = null; 
	protected FirefoxProfile profile =null;	
	
	@BeforeSuite
	public void setBrowser(){				
		
		System.out.println("----------Inside Set Browser--------------");
		
		try {
			ReadConfig config = new ReadConfig();
			if(("firefox").equalsIgnoreCase(config.getBrowser())){
				ini = new ProfilesIni();
				profile = ini.getProfile("Selenium");
				driver = new FirefoxDriver(profile);
			}else if(("chrome").equalsIgnoreCase(config.getBrowser())){
				System.setProperty("webdriver.chrome.driver",SetUp.class.getClassLoader().getResource("driver/chromedriver.exe").getPath());
				driver = new ChromeDriver();	
			}else if(("iexplore").equalsIgnoreCase(config.getBrowser())){
				System.setProperty("webdriver.ie.driver",SetUp.class.getClassLoader().getResource("driver/IEDriverServer.exe").getPath());
				driver = new InternetExplorerDriver();
			}else{
				driver = new HtmlUnitDriver();
				System.out.println("--------------------HtmlUnitDriver---------------------");
			}
			
			driver.manage().timeouts().implicitlyWait(config.getTimeOut(), TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(config.getPageTimeOut(), TimeUnit.SECONDS);
			driver.manage().window().maximize();			
			driver.get(config.getUrl());
						
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@AfterSuite(alwaysRun=true)
	public void packUp(){
		System.out.println("----------Inside close Browser--------------");
		driver.close();
		driver.quit();
		if( driver != null){
			driver=null;
		}
	}
	
	

	@BeforeTest
	public void doLogin() throws InterruptedException{
		
		System.out.println("----------Inside Do Login--------------");
	//	WebElementHelper.ClickonElement("//a[contains(text(),'Signin')]");				
		WebElementHelper.typeinTextusingXpath("//div[@class='login']/descendant::form[@class='inline_login_form']/descendant::input[position()=1]", "shrikantm929@gmail.com");	
		WebElementHelper.typeinTextusingXpath("//div[@class='login']/descendant::form[@class='inline_login_form']/descendant::input[position()=2]", "quoraquora");			
		WebElementHelper.ClickonElement("//div[@class='login']/descendant::form[@class='inline_login_form']/descendant::input[position()=4]");
		System.out.println("---------- Login done--------------");
		
		//Assert.assertEquals("Login Done", driver.findElement(By.xpath("//h3[contains(@class,'title')]")), "Feeds");
	

	}
	
	public static WebElement getElement(String locater){
		
			if(driver.findElements(By.xpath(locater)).size() == 1){
				return driver.findElement(By.xpath(locater));
			}else if(driver.findElements(By.className(locater)).size() == 1){
				return driver.findElement(By.className(locater));
			}else if(driver.findElements(By.cssSelector(locater)).size() == 1){
				return driver.findElement(By.cssSelector(locater));
			}else if(driver.findElements(By.name(locater)).size() == 1){
				return driver.findElement(By.name(locater));
			}else if(driver.findElements(By.id(locater)).size() == 1){
				return driver.findElement(By.id(locater));
			}else if(driver.findElements(By.tagName(locater)).size() == 1){
				return driver.findElement(By.tagName(locater));
			}else{
				throw new NoSuchElementException("No such Element found "+locater);
			}		
		
	}
	
	
	public static WebElement getElementByXpath(String locater){
			return driver.findElement(By.xpath(locater));
	}
	
	
	
	
	
}

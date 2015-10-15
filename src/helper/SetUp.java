package helper;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import common.ReadConfig;

public class SetUp {
	
	
	public static WebDriver driver = null;
	protected ProfilesIni ini = null; 
	protected FirefoxProfile profile =null;	
	protected ReadConfig config = null;

	@BeforeSuite
	public void setBrowser(){				
		
		System.out.println("----------Inside Set Browser--------------");
		
		try {
			config = new ReadConfig();
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
			
		//	driver.manage().timeouts().implicitlyWait(config.getTimeOut(), TimeUnit.SECONDS);
		//	driver.manage().timeouts().implicitlyWait(config.getPageTimeOut(), TimeUnit.SECONDS);
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
	
	

	/*@BeforeTest
	public void testonLoginPage(){
		System.out.println("----------------Inside before Test--------------------");
		Assert.assertEquals(WebElementHelper.getElementByXpath("//a[@class='login']").getText(), "Sign in", "Not on Login Page");
	}
	*/
	
	

	
	
	
	
}

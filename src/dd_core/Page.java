package dd_core;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import dd_util.DbManager;
import dd_util.TestConfig;
import dd_util.TestUtil;
import dd_util.Xls_Reader;
import dd_util.monitoringMail;

public class Page {
	
	public static WebDriver driver;
	public static Properties Config = new Properties();
	public static Properties OR = new Properties();
	public static FileInputStream fis;
	public static Xls_Reader excel = new Xls_Reader(System.getProperty("user.dir")+"\\src\\dd_properties\\testdata.xlsx");
	public static Logger logs = Logger.getLogger("devpinoyLogger");
	
	@BeforeSuite
	public void init() throws IOException, AddressException, SQLException, ClassNotFoundException, MessagingException{
		
		if(driver==null){
		
		fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\dd_properties\\Config.properties");
		Config.load(fis);
		logs.debug("Loaded the Config property file");
		
		fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\dd_properties\\OR.properties");
		OR.load(fis);
		logs.debug("loaded the OR property file");
		
		if(Config.getProperty("browser").equals("firefox")){
			
			driver = new FirefoxDriver();
			logs.debug("Loaded Firefox");
			
		}else if(Config.getProperty("browser").equals("ie")){
			
			System.setProperty("webdriver.ie.driver", "IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			
		}else if(Config.getProperty("browser").equals("chrome")){
			
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			driver = new ChromeDriver();
			
		}
		
		driver.get(Config.getProperty("testsiteurl"));
		driver.manage().timeouts().implicitlyWait(30L, TimeUnit.SECONDS);
		DbManager.setMysqlDbConnection();
		}
	}
	
	public static WebElement findElement(String key) throws IOException{
		
		try{
		
			return driver.findElement(By.xpath(OR.getProperty(key)));
			
		
		}catch(Throwable t){
			
			TestUtil.CaptureScreenshot();
			return null;
		}
	}
	public static boolean IsElementPresent(By by) 
	{
		boolean IsDisplayed = driver.findElement(by).isDisplayed();
		if (IsDisplayed) 
		{
			driver.findElement(by).click();
		}
		return IsDisplayed;
	}
	public static void logindetails(By by, String input, By btnby)
	{
		if (driver.findElement(by).isDisplayed()) 
		{
			driver.findElement(by).sendKeys(input);
			driver.findElement(btnby).click();
		}
	}
	
	public static boolean IsElementSearch(By by,String name){		
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(by));
	    actions.sendKeys(name);
	    actions.click().build().perform();
	    return true;
	}
	
	 public static void UserDetails(By by, String input){
  		 if(driver.findElement(by).isDisplayed())
  		 {
  			 driver.findElement(by).sendKeys(input);
  			driver.findElement(by).click();
  		  }
  		 }	
	@AfterSuite
	public void QuitDriver() throws AddressException, MessagingException{
		
		driver.quit();
		monitoringMail mail = new monitoringMail();
		mail.sendMail(TestConfig.server, TestConfig.from, TestConfig.to, TestConfig.subject, TestConfig.messageBody, TestConfig.attachmentPath, TestConfig.attachmentName);
		}
}

package dd_testcases;


import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import dd_core.Page;
import dd_util.TestUtil;


public class LoginTest extends Page {

	
	//public static String GlobalUsername;
	
	@BeforeTest
	public void isSkip(){
		
		if(!TestUtil.isExecutable("LoginTest")){
			
			throw new SkipException("Skipping the test as the Run mode is No");
		}
	}
	@Test(dataProvider="getData")
	public void doLogin(String username,String password) throws IOException, InterruptedException{
		
		logs.debug("Inside Login Test");
		driver.findElement(By.xpath(OR.getProperty("username"))).sendKeys(username);
		driver.findElement(By.xpath(OR.getProperty("password"))).sendKeys(password);
		driver.findElement(By.xpath(OR.getProperty("login"))).click();
		
		TestUtil.CaptureScreenshot();
	}
	
	@DataProvider
	public static Object[][] getData(){
		
		return TestUtil.getData("LoginTest");
	}
}

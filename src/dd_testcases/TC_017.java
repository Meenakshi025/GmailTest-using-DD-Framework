package dd_testcases;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import dd_core.Page;
import dd_util.TestUtil;

public class TC_017  extends Page{
	
	@BeforeTest
	public void isSkip(){
		
		if(!TestUtil.isExecutable("TC_017")){
			
			throw new SkipException("Skipping the test as the Run mode is No");
		   }
		}
		@Test(dataProvider="getData")
		public void VerifyEmailSettingIspresent(String Username,String Password) throws IOException, InterruptedException{
			
			logs.debug("Inside mails  setting verification Test");
			System.out.println("..........TC_017.To verify that Settings page is displayed properly...........");	
			driver.navigate().to("http://mail.google.com");
			
			 logindetails(By.xpath(OR.getProperty("EmailText")),Username,By.xpath(OR.getProperty("NextBtn")));
		     Thread.sleep(3000);
		     
		     logindetails(By.xpath(OR.getProperty("PasswordText")),Password,By.xpath(OR.getProperty("SignInBtn")));
			
		 	 IsElementPresent(By.xpath(OR.getProperty("SettingIcon")));
			 Thread.sleep(3000);
			
			 IsElementPresent(By.xpath(OR.getProperty("SettingLink")));
			 Thread.sleep(3000);
			
			 String IsSettingDisplayed = driver.findElement(By.className(OR.getProperty("linkText"))).getText(); 
			 System.out.println("page element = "+IsSettingDisplayed);
		     
			 IsElementPresent(By.xpath(OR.getProperty("GLogOutBtn")));
					
			 IsElementPresent(By.xpath(OR.getProperty("GSignOutbtn")));
		}
		@DataProvider
		public static Object[][] getData(){
			
			return TestUtil.getData("TC_017");
		}
	

}

package dd_testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import dd_core.Page;
import dd_util.TestUtil;

public class TC_014 extends Page {
	
	@BeforeTest
	public void isSkip(){
		
		if(!TestUtil.isExecutable("TC_014")){
			
			throw new SkipException("Skipping the test as the Run mode is No");
		   }
		}
		@Test(dataProvider="getData")
		public void VerifyMailIsSendProperly(String Username,String Password,String UserMailId,String ComposeSubject,String ComposetextMessage) throws IOException, InterruptedException{
			
			logs.debug("Inside Compose and sending mail Test");
			System.out.println("..........TC_014.To verify that email is Send properly to email address in To,cc & bcc...........");		
			driver.navigate().to("http://mail.google.com");
			
			 logindetails(By.xpath(OR.getProperty("EmailText")),Username,By.xpath(OR.getProperty("NextBtn")));
		     Thread.sleep(3000);
		     
		     logindetails(By.xpath(OR.getProperty("PasswordText")),Password,By.xpath(OR.getProperty("SignInBtn")));
		     Thread.sleep(3000);
		     
		     IsElementPresent(By.xpath(OR.getProperty("ComposeButton"))); 
		    
		     UserDetails(By.className(OR.getProperty("CompostTo")),UserMailId);
				
		     UserDetails(By.className(OR.getProperty("ComposeSub")),ComposeSubject);
		  		  
		     
		     UserDetails(By.className(OR.getProperty("ComposeText")),ComposetextMessage);
				
			 IsElementPresent(By.xpath(OR.getProperty("SendButton")));
			 Thread.sleep(3000);
				
			 IsElementPresent(By.xpath(OR.getProperty("SentItems")));
			 Thread.sleep(3000);
				
			 if(driver.getPageSource().contains("Test Mail")){
				System.out.println("Email exist in sent mail");
			 }else{
					System.out.println("Email not exist in sent mail");
				}
				IsElementPresent(By.xpath(OR.getProperty("GLogOutBtn")));
				
				IsElementPresent(By.xpath(OR.getProperty("GSignOutbtn")));
		}
		@DataProvider
		public static Object[][] getData(){
			
			return TestUtil.getData("TC_014");
		}
}

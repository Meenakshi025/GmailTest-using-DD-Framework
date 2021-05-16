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

public class TC_010 extends Page{
	@BeforeTest
	public void isSkip(){
		
		if(!TestUtil.isExecutable("TC_010")){
			
			throw new SkipException("Skipping the test as the Run mode is No");
		   }
		}
		@Test(dataProvider="getData")
		public void verifyInboxMailsWithStarCount(String Username,String Password) throws IOException, InterruptedException{
			
			logs.debug("Inside verify Inbox Mails With Star Count Test");
			System.out.println("..........TC_010.To verify the total no. of emails marked with STAR...........");
			driver.navigate().to("http://mail.google.com");
			
			 logindetails(By.xpath(OR.getProperty("EmailText")),Username,By.xpath(OR.getProperty("NextBtn")));
		     Thread.sleep(3000);
		     
		     logindetails(By.xpath(OR.getProperty("PasswordText")),Password,By.xpath(OR.getProperty("SignInBtn")));
			
		     driver.findElement(By.xpath(OR.getProperty("Starred"))).click();
			 Thread.sleep(5000);
				
			 WebElement Flag_Star = driver.findElement(By.xpath(OR.getProperty("EmailStarred")));
			 List<WebElement> EmailRow = Flag_Star.findElements(By.tagName(OR.getProperty("StarsCount")));
	         System.out.println("Starred mail count = "+EmailRow.size());
	         
	         IsElementPresent(By.xpath(OR.getProperty("GLogOutBtn")));
				
			 IsElementPresent(By.xpath(OR.getProperty("GSignOutbtn")));
		}
		@DataProvider
		public static Object[][] getData(){
			
			return TestUtil.getData("TC_010");
		}


}

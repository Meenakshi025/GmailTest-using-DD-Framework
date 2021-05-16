package dd_testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import dd_core.Page;
import dd_util.TestUtil;

public class TC_019 extends Page{
	
	@BeforeTest
	public void isSkip(){
		
		if(!TestUtil.isExecutable("TC_019")){
			
			throw new SkipException("Skipping the test as the Run mode is No");
		   }
		}
		@Test(dataProvider="getData")
		public void VerifyMailsMoveSourceFolderTotargetfolder(String Username,String Password) throws IOException, InterruptedException{
			
			logs.debug("Inside verify mails move source folder to target folder Test");
			System.out.println("..........TC_019.To verify that emails are moved from source label to target label (Folders)...........");	
			driver.navigate().to("http://mail.google.com");
			
			logindetails(By.xpath(OR.getProperty("EmailText")),Username,By.xpath(OR.getProperty("NextBtn")));
		    Thread.sleep(3000);
		     
		    logindetails(By.xpath(OR.getProperty("PasswordText")),Password,By.xpath(OR.getProperty("SignInBtn")));
			
		    IsElementPresent(By.xpath(OR.getProperty("Selectmail")));
			Thread.sleep(3000);
			
			IsElementPresent(By.xpath(OR.getProperty("MoveTo")));   
			Thread.sleep(3000);
			
			IsElementPresent(By.xpath(OR.getProperty("TargetLabel"))); 
			Thread.sleep(3000);
			
			IsElementPresent(By.xpath(OR.getProperty("Movedmail"))); 
			Thread.sleep(3000);
			
			String IsMoved = driver.findElement(By.xpath(OR.getProperty("MailText"))).getText();
			Thread.sleep(3000);
		    System.out.println(IsMoved);
			IsElementPresent(By.xpath(OR.getProperty("GLogOutBtn")));
					
			IsElementPresent(By.xpath(OR.getProperty("GSignOutbtn")));
		  }
		@DataProvider
		public static Object[][] getData(){
			
			return TestUtil.getData("TC_019");
		}
}

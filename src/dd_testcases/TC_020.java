package dd_testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import dd_core.Page;
import dd_util.TestUtil;

public class TC_020 extends Page{
	
	@BeforeTest
	public void isSkip(){
		
		if(!TestUtil.isExecutable("TC_020")){
			
			throw new SkipException("Skipping the test as the Run mode is No");
		   }
		}
		@Test(dataProvider="getData")
		public void VerifyMailsMoveSourceFolderTotargetfolder(String Username,String Password) throws IOException, InterruptedException{
			
			logs.debug("Inside verify mails move source folder to target folder Test");
			System.out.println("..........TC_020.To verify that the user can successfully Sign-out from Gmail...........");	
			driver.navigate().to("http://mail.google.com");
			
			logindetails(By.xpath(OR.getProperty("EmailText")),Username,By.xpath(OR.getProperty("NextBtn")));
		    Thread.sleep(3000);
		     
		    logindetails(By.xpath(OR.getProperty("PasswordText")),Password,By.xpath(OR.getProperty("SignInBtn")));
			
		    System.out.println("Page title = " +driver.getTitle());
		    
			IsElementPresent(By.xpath(OR.getProperty("GLogOutBtn")));
					
			IsElementPresent(By.xpath(OR.getProperty("GSignOutbtn")));
			
			System.out.println("Page title = " +driver.getTitle());
		  }
		@DataProvider
		public static Object[][] getData(){
			
			return TestUtil.getData("TC_020");
		}
}

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

public class TC_013 extends Page{
	
	@BeforeTest
	public void isSkip(){
		
		if(!TestUtil.isExecutable("TC_013")){
			
			throw new SkipException("Skipping the test as the Run mode is No");
		   }
		}
		@Test(dataProvider="getData")
		public void VerifymailComposeIsWorkingProperly(String Username,String Password) throws IOException, InterruptedException{
			
			logs.debug("Inside mail Compose Test");
			System.out.println("..........TC_013.To verify that Compose is working properly...........");
			boolean IsComposeDialogDisplayed;
			
			driver.navigate().to("http://mail.google.com");
			
			 logindetails(By.xpath(OR.getProperty("EmailText")),Username,By.xpath(OR.getProperty("NextBtn")));
		     Thread.sleep(3000);
		     
		     logindetails(By.xpath(OR.getProperty("PasswordText")),Password,By.xpath(OR.getProperty("SignInBtn")));
		     Thread.sleep(3000);
		     
		     IsElementPresent(By.xpath(OR.getProperty("ComposeButton")));
		     Thread.sleep(3000);
		     
			 IsComposeDialogDisplayed = IsElementPresent(By.className(OR.getProperty("ComposeDialogBox")));

				if (IsComposeDialogDisplayed)
				{
					System.out.println("Compose dialog box is displayed once clicked on compose button");
				} 
				else
				{
					System.out.println("Compose dialog box is not displayed once clicked on compose button");
				}
		     
			     IsElementPresent(By.xpath(OR.getProperty("GLogOutBtn")));
					
				 IsElementPresent(By.xpath(OR.getProperty("GSignOutbtn")));
		}
		@DataProvider
		public static Object[][] getData(){
			
			return TestUtil.getData("TC_013");
		}
	

}

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

public class TC_009 extends Page{
	
	public static int NoOfEmailCount =0;
	
	@BeforeTest
	public void isSkip(){
		
		if(!TestUtil.isExecutable("TC_009")){
			
			throw new SkipException("Skipping the test as the Run mode is No");
		   }
		}
		@Test(dataProvider="getData")
		public void VerifyInboxMailsCount(String Username,String Password) throws IOException, InterruptedException{
			
			logs.debug("Inside Inbox mails count Test");
			System.out.println("..........TC_009.To verify the total no. of emails received by the user...........");
			driver.navigate().to("http://mail.google.com");
			
			 logindetails(By.xpath(OR.getProperty("EmailText")),Username,By.xpath(OR.getProperty("NextBtn")));
		     Thread.sleep(3000);
		     
		     logindetails(By.xpath(OR.getProperty("PasswordText")),Password,By.xpath(OR.getProperty("SignInBtn")));
			
		     int TotalNoInboxEmail = Integer.parseInt(driver.findElement(By.xpath(OR.getProperty("TolEmailCount"))).getText());
			 System.out.println("Total No of Inbox Email: " + TotalNoInboxEmail);
			
			 while(NoOfEmailCount < TotalNoInboxEmail)
			  {
				  List<WebElement> checkBoxes = driver.findElements(By.className(OR.getProperty("CheckBox")));
				  NoOfEmailCount =  NoOfEmailCount + (checkBoxes.size()-1);
				  driver.findElement(By.xpath(OR.getProperty("NextBtnArrow"))).click();
				  Thread.sleep(1000);
			  }
			     System.out.println("No of Email: " + NoOfEmailCount);
			     IsElementPresent(By.xpath(OR.getProperty("GLogOutBtn")));
					
				 IsElementPresent(By.xpath(OR.getProperty("GSignOutbtn")));
		}
		@DataProvider
		public static Object[][] getData(){
			
			return TestUtil.getData("TC_009");
		}
}

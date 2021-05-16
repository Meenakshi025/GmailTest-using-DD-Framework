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

public class TC_011 extends Page{
	
	public static int NoOfEmailCount =0;
	public static int NoofUnreadEmail=0;
	
	@BeforeTest
	public void isSkip(){
		
		if(!TestUtil.isExecutable("TC_011")){
			
			throw new SkipException("Skipping the test as the Run mode is No");
		   }
		}
		@Test(dataProvider="getData")
		public void VerifyInboxUnreadMailsCount(String Username,String Password) throws IOException, InterruptedException{
			
			logs.debug("Inside Inbox Unread mails count Test");
			System.out.println("..........TC_011.To verify and count unread emails in an INBOX...........");
			driver.navigate().to("http://mail.google.com");
			
			 logindetails(By.xpath(OR.getProperty("EmailText")),Username,By.xpath(OR.getProperty("NextBtn")));
		     Thread.sleep(3000);
		     
		     logindetails(By.xpath(OR.getProperty("PasswordText")),Password,By.xpath(OR.getProperty("SignInBtn")));
			
		     IsElementPresent(By.xpath(OR.getProperty("Inbox")));
				Thread.sleep(3000);
				
				int TotalNoInboxEmail = Integer.parseInt(driver.findElement(By.xpath(OR.getProperty("TolEmailCount"))).getText());
			   
			    while(NoOfEmailCount < TotalNoInboxEmail)
			     {
					  List<WebElement> checkBoxes = driver.findElements(By.className(OR.getProperty("CheckBox")));
					  NoOfEmailCount =  NoOfEmailCount + (checkBoxes.size()-1);
					  
					  List<WebElement> element = driver.findElements(By.className(OR.getProperty("UnReadmailCount")));
				      NoofUnreadEmail = (NoofUnreadEmail+element.size()/2);
					  driver.findElement(By.xpath(OR.getProperty("NextBtnArrow"))).click();
					  Thread.sleep(1000);
				    }

			    System.out.println("Total unread email in Inbox: " + NoofUnreadEmail);
		     
			     IsElementPresent(By.xpath(OR.getProperty("GLogOutBtn")));
					
				 IsElementPresent(By.xpath(OR.getProperty("GSignOutbtn")));
		}
		@DataProvider
		public static Object[][] getData(){
			
			return TestUtil.getData("TC_011");
		}
	

}

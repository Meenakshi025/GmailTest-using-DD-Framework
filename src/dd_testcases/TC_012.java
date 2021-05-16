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

public class TC_012 extends Page {
	
	public static int NoOfEmailCount =0;
	public static int NoOfReadEmail=0;
	
	@BeforeTest
	public void isSkip(){
		
		if(!TestUtil.isExecutable("TC_012")){
			
			throw new SkipException("Skipping the test as the Run mode is No");
		   }
		}
		@Test(dataProvider="getData")
		public void VerifyInboxReadMailsCount(String Username,String Password) throws IOException, InterruptedException{
			
			logs.debug("Inside Inbox read mails count Test");
			System.out.println("..........TC_012.To verify and count the read emails in an INBOX...........");
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
					  
					List<WebElement> element = driver.findElements(By.className(OR.getProperty("ReadMailsCount")));
				    NoOfReadEmail = NoOfReadEmail+(element.size()/2);

					driver.findElement(By.xpath(OR.getProperty("NextBtnArrow"))).click();
					Thread.sleep(1000);
				    }
			    System.out.println("Total No of Read email in Inbox: " + NoOfReadEmail);
		     
			     IsElementPresent(By.xpath(OR.getProperty("GLogOutBtn")));
					
				 IsElementPresent(By.xpath(OR.getProperty("GSignOutbtn")));
		}
		@DataProvider
		public static Object[][] getData(){
			
			return TestUtil.getData("TC_012");
		}
	

}

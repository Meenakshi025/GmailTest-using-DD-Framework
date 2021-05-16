package dd_testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import dd_core.Page;
import dd_util.TestUtil;

public class TC_018 extends Page {
	
	@BeforeTest
	public void isSkip(){
		
		if(!TestUtil.isExecutable("TC_018")){
			
			throw new SkipException("Skipping the test as the Run mode is No");
		   }
		}
		@Test(dataProvider="getData")
		public void VerifyLabelIsCreated(String Username,String Password,String Labelname) throws IOException, InterruptedException{
			
			logs.debug("Inside verify label is created Test");
			System.out.println("..........TC_018.To verify that the new label is properly created...........");	
			driver.navigate().to("http://mail.google.com");
			
			 logindetails(By.xpath(OR.getProperty("EmailText")),Username,By.xpath(OR.getProperty("NextBtn")));
		     Thread.sleep(3000);
		     
		     logindetails(By.xpath(OR.getProperty("PasswordText")),Password,By.xpath(OR.getProperty("SignInBtn")));
			
		     IsElementPresent(By.className(OR.getProperty("MoreClick")));
			 Thread.sleep(3000);
				
			 IsElementPresent(By.className(OR.getProperty("ManageLabel")));
			 Thread.sleep(3000);
				
			 IsElementPresent(By.className(OR.getProperty("CreateLabel")));
				
			 logindetails(By.className(OR.getProperty("LabelTextBox")), Labelname,By.xpath(OR.getProperty("CreateLabelBtn")));
			 Thread.sleep(3000);
			 driver.navigate().back();
				
			 if(driver.getPageSource().contains("Testing_3")){
				System.out.println("New lable created");
			 }else{
				System.out.println("New lable not created");
				}
			 Thread.sleep(3000);
			 IsElementPresent(By.xpath(OR.getProperty("GLogOutBtn")));
					
			 IsElementPresent(By.xpath(OR.getProperty("GSignOutbtn")));
			 Thread.sleep(3000);
		}
		@DataProvider
		public static Object[][] getData(){
			
			return TestUtil.getData("TC_018");
		}
	


}

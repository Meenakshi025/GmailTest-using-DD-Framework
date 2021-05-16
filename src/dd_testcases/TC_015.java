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

public class TC_015 extends Page{
	@BeforeTest
	public void isSkip(){
		
		if(!TestUtil.isExecutable("TC_015")){
			
			throw new SkipException("Skipping the test as the Run mode is No");
		   }
		}
		@Test(dataProvider="getData")
		public void VerifyMailsareserchproperly(String Username,String Password,String Search) throws IOException, InterruptedException{
			
			logs.debug("Inside mail search Test");
			System.out.println("..........TC_015.To verify the search operation i.e search the emails received from specific email address from INBOX...........");				
			driver.navigate().to("http://mail.google.com");
			
			 logindetails(By.xpath(OR.getProperty("EmailText")),Username,By.xpath(OR.getProperty("NextBtn")));
		     Thread.sleep(3000);
		     
		     logindetails(By.xpath(OR.getProperty("PasswordText")),Password,By.xpath(OR.getProperty("SignInBtn")));
		     Thread.sleep(3000);
		     
		     logindetails(By.id(OR.getProperty("EmailSearchText")),Search,By.id(OR.getProperty("EmailSearchbtn")));
				Thread.sleep(3000);
				
				List<WebElement> element = driver.findElements(By.className(OR.getProperty("SearchEmails")));
	            for (int i = 0; i < element.size(); i++) 
	            {
	            	 System.out.println(element.get(i).getText());
	            }
             IsElementPresent(By.xpath(OR.getProperty("GLogOutBtn")));
				
			 IsElementPresent(By.xpath(OR.getProperty("GSignOutbtn")));
		     
		}
		@DataProvider
		public static Object[][] getData(){
			
			return TestUtil.getData("TC_015");
		}

}

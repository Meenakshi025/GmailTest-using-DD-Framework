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

public class TC_008 extends Page {
	@BeforeTest
	public void isSkip(){
		
		if(!TestUtil.isExecutable("TC_008")){
			
			throw new SkipException("Skipping the test as the Run mode is No");
		   }
		}
		@Test(dataProvider="getData")
		public void GmailLogin(String Username, String Password) throws IOException, InterruptedException{
			
			logs.debug("Inside Gmail Login Test");
			System.out.println("..........TC_008.To verify that user is able to login to Gmail...........");
			driver.navigate().to("http://mail.google.com");
			Thread.sleep(3000);
			String LoginName = "";
			
			 logindetails(By.xpath(OR.getProperty("EmailText")),Username,By.xpath(OR.getProperty("NextBtn")));
		     Thread.sleep(3000);
		     
		     logindetails(By.xpath(OR.getProperty("PasswordText")),Password,By.xpath(OR.getProperty("SignInBtn")));
		     
		     WebElement element = driver.findElement(By.xpath(OR.getProperty("GmailLinks")));
			 List<WebElement> links = element.findElements(By.tagName(OR.getProperty("AnchorTag")));
			 System.out.println("Total number of links on webpage = "+links.size());
			 Thread.sleep(3000);
				for(WebElement link:links)
				{
					System.out.println(link.getText());
				}
			
			IsElementPresent(By.xpath(OR.getProperty("GLogOutBtn")));
			
			LoginName = driver.findElement(By.xpath(OR.getProperty("GLoginname"))).getText();
			System.out.println("Login Persons Name = "+LoginName);
			
			IsElementPresent(By.xpath(OR.getProperty("GSignOutbtn")));
		}
		@DataProvider
		public static Object[][] getData(){
			
			return TestUtil.getData("TC_008");
	}
}

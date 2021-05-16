package dd_testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import dd_core.Page;
import dd_util.TestUtil;

public class TC_005 extends Page {
	
	@BeforeTest
	public void isSkip(){
		
		if(!TestUtil.isExecutable("TC_005")){
			
			throw new SkipException("Skipping the test as the Run mode is No");
		   }
		}
		@Test(dataProvider="getData")
		public void VerifyGoogleLaguageLinks(String name) throws IOException, InterruptedException{
			
			logs.debug("Inside Google Languages verification Test");
			System.out.println("..........TC_005.To verify that clicking on the language links (Hindi, Marathi etc) launches Google in respective language..........");
			String SignInBtn = "",HindilinkText;
			
			 HindilinkText = driver.findElement(By.xpath(OR.getProperty("HindiLinkbtn"))).getText();
			 System.out.println("hindi  = "+HindilinkText);
			 
			 IsElementPresent(By.xpath(OR.getProperty("HindiLinkbtn")));
			 Thread.sleep(3000);
			
			 SignInBtn = driver.findElement(By.xpath(OR.getProperty("SigninButntext"))).getText();
			 Thread.sleep(3000);
			
			  String ActualText = driver.findElement(By.xpath(OR.getProperty("HindiLinkbtn"))).getText();
			  Thread.sleep(3000);
			  
			  System.out.println("Hindi Link Text = "+ActualText);
			
			  if (HindilinkText.equals(ActualText))
			     System.out.println("View link: Displayed");
			  else
			     System.out.println("View link: NotDisplayed");

		}
		@DataProvider
		public static Object[][] getData(){
			
			return TestUtil.getData("TC_005");
		}

}




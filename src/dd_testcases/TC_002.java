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

public class TC_002 extends Page {
	
	@BeforeTest
	public void isSkip(){
		
		if(!TestUtil.isExecutable("TC_002")){
			
			throw new SkipException("Skipping the test as the Run mode is No");
		   }
		}
		@Test(dataProvider="getData")
		public void VerifyGoogleApp(String naame)throws IOException, InterruptedException{
			
			logs.debug("Inside Google App verification Test");
			System.out.println("..........TC_002.To verify all the Google apps in the dialog box...........");

			driver.findElement(By.xpath(OR.getProperty("GoogleApp"))).click();
		     Thread.sleep(3000);
			WebElement element = driver.findElement(By.xpath(OR.getProperty("DialogBox")));
			List<WebElement> links = element.findElements(By.tagName(OR.getProperty("AnchorTag")));
			System.out.println("Total number of links on webpage = "+links.size());
			Thread.sleep(3000);
			
			for(WebElement link:links)
			{
				System.out.println(link.getText());
			}
			logs.debug("Get Google apps Link");
		}
		
	@DataProvider
	public static Object[][] getData(){
		
		return TestUtil.getData("TC_002");
	}
}

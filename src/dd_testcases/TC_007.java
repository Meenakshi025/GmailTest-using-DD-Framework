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

public class TC_007 extends Page {
	
	@BeforeTest
	public void isSkip(){
		
		if(!TestUtil.isExecutable("TC_007")){
			
			throw new SkipException("Skipping the test as the Run mode is No");
		   }
		}
		@Test(dataProvider="getData")
		public void VerifyGoogleProducts(String name) throws IOException, InterruptedException{
			
			logs.debug("Inside Google Products link verification Test");
			System.out.println("..........TC_007.To verify the Google apps/products on Google products webpage...........");
			driver.navigate().to("https://www.google.co.in/intl/en/about/products/");
			
			WebElement element = driver.findElement(By.xpath(OR.getProperty("GoogleProductLinks")));
			List<WebElement> links = element.findElements(By.tagName(OR.getProperty("AnchorTag")));
			System.out.println("Total number of links on webpage = "+links.size());
			Thread.sleep(3000);
			for(WebElement link:links)
			{
				System.out.println(link.getText());
			}
			
			logs.debug("Get the Googleproducts link");
		}
		@DataProvider
		public static Object[][] getData(){
			
			return TestUtil.getData("TC_007");
		}


}

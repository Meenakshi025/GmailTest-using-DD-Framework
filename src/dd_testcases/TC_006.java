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

public class TC_006 extends Page{
	@BeforeTest
	public void isSkip(){
		
		if(!TestUtil.isExecutable("TC_006")){
			
			throw new SkipException("Skipping the test as the Run mode is No");
		   }
		}
		@Test(dataProvider="getData")
		public void VerifyGoogleSearchOperationPerformProperly(String Search) throws IOException, InterruptedException{
			
			logs.debug("Inside verify Google search perform properly Test");
			System.out.println("..........TC_006.To validate that the Google performs the search operation properly...........");

			     IsElementSearch(By.xpath(OR.getProperty("GSearchtext")),Search);
			    
			     IsElementPresent(By.xpath(OR.getProperty("GSearchbtn")));
			    
			    WebElement element = driver.findElement(By.xpath(OR.getProperty("Searchpage")));
				   List<WebElement> links =   element.findElements(By.tagName(OR.getProperty("PageHeading")));			
				   System.out.println(" total number of links on webpage = "+links.size());	
				   for (WebElement link : links) 
				   {
					System.out.println(link.getText());
				  }
		}
		@DataProvider
		public static Object[][] getData(){
			
			return TestUtil.getData("TC_006");
		}


}

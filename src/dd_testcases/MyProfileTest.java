package dd_testcases;


import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import dd_core.Page;
import dd_util.TestUtil;


public class MyProfileTest extends Page {

	@BeforeTest
	public void isSkip(){
		
		if(!TestUtil.isExecutable("MyProfileTest")){
			
			throw new SkipException("Skipping the test as the Run mode is No");
		}
	}
	
	@Test(dataProvider="getData")
	public void gotoProfile(String naame) throws IOException{
		
		String Username = driver.findElement(By.xpath(OR.getProperty("profile"))).getText();		
		System.out.println(Username);
	}
	
	@DataProvider
	public static Object[][] getData(){
		
		return TestUtil.getData("MyProfileTest");
	}
}

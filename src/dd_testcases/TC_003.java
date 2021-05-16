package dd_testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import dd_core.Page;
import dd_util.TestUtil;

public class TC_003 extends Page {
	
	public static String MyAccountText,NewsText,NewsToStoriesText;
	public static boolean IsSearchTextBoxPresent,IsZoomSliderPresent,IsUploadBtnPresent,IsYoutubeSearchTxtPresent,isYoutubeLogoPresent,IsPlaySearchtxtPresent,IsPlayLogoPresent,IsSignInPresent,IsGmailLogoPresent,IsMeetDrivePresent,IsUsingDrivePresent,IsGoogleDriveLogoPresent,IsDriveSymbolPresent,IsGoToGoogledriveBtnPresent,IsGooglePlusSearchPresent,IsGooglePlusLogoPresent,IsTranslateLogoPresent,IsTranslateBtnPresent,IsGooglePhotoLogoPresent,IsGoToGooglePhotosPresent;
	
	@BeforeTest
	public void isSkip(){
		
		if(!TestUtil.isExecutable("TC_003")){
			
			throw new SkipException("Skipping the test as the Run mode is No");
		   }
		}
		@Test(dataProvider="getData")
		public void VerifyAllGoogleApps(String name)throws IOException, InterruptedException{
			
			driver.navigate().refresh();
			Thread.sleep(2000);
			
			logs.debug("Inside Google All App Element verification Test");
			System.out.println("..........TC_003.To verify that all the Google apps are launched properly ...........");
			//My Account
			driver.findElement(By.xpath(OR.getProperty("GoogleApp"))).click();
			Thread.sleep(3000);
			
			driver.findElement(By.xpath(OR.getProperty("MyAccountApp"))).click();
		     System.out.println("Page title = " +driver.getTitle());
		     logs.debug("My Account Title verified");
		     Thread.sleep(3000);
		     
		     MyAccountText = driver.findElement(By.xpath(OR.getProperty("MyAccountText"))).getText();
		     System.out.println("Page text = "+MyAccountText);
		     Thread.sleep(3000);
		     
		    if (driver.getPageSource().contains("My Account"))
			        System.out.println("Text is Present on the MyAccount webpage");
		        else
			          System.out.println("Text is not Present on the MyAccount webpage");

			    driver.navigate().back();
			    Thread.sleep(3000);
          //Google Maps
			    logs.debug("Inside Google Maps Test Case");
			    driver.findElement(By.xpath(OR.getProperty("GoogleApp"))).click();
			    driver.findElement(By.xpath(OR.getProperty("MapsApp"))).click();
			    Thread.sleep(3000);
			    
			    System.out.println("Page title = " +driver.getTitle());
			    logs.debug("google Maps Title verified");
			    Thread.sleep(3000);
			    
			    IsSearchTextBoxPresent =  driver.findElement(By.xpath(OR.getProperty("SearchTextBox"))).isDisplayed();
			    Thread.sleep(3000);
			    
			    IsZoomSliderPresent =  driver.findElement(By.xpath(OR.getProperty("ZoomSlider"))).isDisplayed();
			    Thread.sleep(3000);
			    
			    if (IsSearchTextBoxPresent && IsZoomSliderPresent ){
	    		    System.out.println("Element is present on the Maps webpage");
	    	     }
	    		else  {  
	    			System.out.println("Element is not present on the Maps page");
	    		}
	              driver.navigate().back();
	       //YouTube
	              logs.debug("Inside Google Youtube Test Case");
				  driver.findElement(By.xpath(OR.getProperty("GoogleApp"))).click();
				  driver.findElement(By.xpath(OR.getProperty("YoutubeApp"))).click();
				  Thread.sleep(3000);
				  
				  System.out.println("Page title = " +driver.getTitle());
				  logs.debug("Google YouTube Title verified");
				  Thread.sleep(3000);
				  
				  IsUploadBtnPresent = IsElementPresent(By.xpath(OR.getProperty("UploadBtn")));
				  driver.navigate().back();
				  Thread.sleep(3000);
				  
				  IsYoutubeSearchTxtPresent = IsElementPresent(By.xpath(OR.getProperty("YoutubeSearchTxt")));
				  
				  isYoutubeLogoPresent = IsElementPresent(By.xpath(OR.getProperty("YouTubeLogo")));
				  Thread.sleep(3000);
				  if (IsYoutubeSearchTxtPresent && IsUploadBtnPresent && isYoutubeLogoPresent)
				   {
		   		    System.out.println("Element is present on the Youtube webpage");
				   }else {   
		   			System.out.println("Element is not present on the Youtube page");
				   }
		            driver.navigate().forward();
		            driver.navigate().back();
		            driver.navigate().back();
		            Thread.sleep(3000);
		            
		      //GooglePlay
		           logs.debug("Inside Google Play Test Case");
				 driver.findElement(By.xpath(OR.getProperty("GoogleApp"))).click();
				 IsElementPresent(By.xpath(OR.getProperty("GooglePlay")));
				 Thread.sleep(3000);
					  
				 System.out.println("Page title = " +driver.getTitle());
				 logs.debug("Google Play Title verified");
				 Thread.sleep(3000);
					    
				 IsPlaySearchtxtPresent = IsElementPresent(By.xpath(OR.getProperty("PlaySearchTxtBax")));
				 Thread.sleep(3000);
						    
				 IsPlayLogoPresent = IsElementPresent(By.xpath(OR.getProperty("GooglePlayLogo")));
				 Thread.sleep(3000);
				 		   
				 if (IsPlaySearchtxtPresent && IsPlayLogoPresent)
				{
				System.out.println("Element is present on the Google Play webpage");
				}else {   
				System.out.println("Element is not present on the Google Play page");
				}
				driver.navigate().back();
				
			//GoogleNews
				
				 logs.debug("Inside Google News Test Case");
				 driver.findElement(By.xpath(OR.getProperty("GoogleApp"))).click();
				 IsElementPresent(By.xpath(OR.getProperty("GoogleNewsApp")));
				 Thread.sleep(3000);
					  
				 System.out.println("Page title = " +driver.getTitle());
				 logs.debug("Google News Title verified");
				 Thread.sleep(3000);
				 
				 NewsText = driver.findElement(By.xpath(OR.getProperty("GoogleNewsTxt"))).getText();
				 System.out.println("Page text = "+NewsText);
				   
				 NewsToStoriesText = driver.findElement(By.xpath(OR.getProperty("GoogleTopStoriesTxt"))).getText();
				 System.out.println("Page text = "+NewsText);
				 Thread.sleep(3000);
				    
				 driver.navigate().back();
		//Gmail
				 
				 logs.debug("Inside Gmail Test Case");
				 driver.findElement(By.xpath(OR.getProperty("GoogleApp"))).click();
				 IsElementPresent(By.xpath(OR.getProperty("GmailApp")));
				 Thread.sleep(3000);
					  
				 System.out.println("Page title = " +driver.getTitle());
				 logs.debug("Google Gmail Title verified");
				 Thread.sleep(3000);
				 
				 IsSignInPresent =IsElementPresent(By.xpath(OR.getProperty("GmailSignIn"))); 
				 Thread.sleep(3000);
				 driver.navigate().back();
				 
				 IsGmailLogoPresent = IsElementPresent(By.xpath(OR.getProperty("GmailLogo"))); 
				 
				 WebElement WE = driver.findElement(By.linkText("CREATE AN ACCOUNT"));
				 Thread.sleep(2000);
			     Actions action = new Actions(driver);
			
				 if (IsSignInPresent && IsGmailLogoPresent)
				 {
			   		System.out.println("Element is present on the Gmail webpage");
				 }else 
				 {   
			   		System.out.println("Element is not present on the Gmail page");
				 }
					  driver.navigate().back();
          //GoogleDrive
			  logs.debug("Inside GoogleDrive Test Case");
			  driver.findElement(By.xpath(OR.getProperty("GoogleApp"))).click();
			  IsElementPresent(By.xpath(OR.getProperty("GoogleDriveApp")));
			  Thread.sleep(3000);
							  
			  System.out.println("Page title = " +driver.getTitle());
			  logs.debug("Google Drive Title verified");
			  Thread.sleep(3000);
			  
			  IsMeetDrivePresent = IsElementPresent(By.xpath(OR.getProperty("MeetDrive")));
			  Thread.sleep(3000); 
			  driver.navigate().back();
			  
			  IsUsingDrivePresent = IsElementPresent(By.xpath(OR.getProperty("UsingDrive")));
			  driver.navigate().back();
				  
			  IsGoogleDriveLogoPresent = IsElementPresent(By.xpath(OR.getProperty("GoogleDriveLogo")));
			  Thread.sleep(3000); 
				 
			  IsDriveSymbolPresent =  IsElementPresent(By.xpath(OR.getProperty("GoogleDriveSymbol")));
			  driver.navigate().back();
			  
			  IsGoToGoogledriveBtnPresent = IsElementPresent(By.xpath(OR.getProperty("GoToGoogleDriveBtn"))); 
			  Thread.sleep(3000);
				  
			  if (IsMeetDrivePresent && IsUsingDrivePresent && IsGoogleDriveLogoPresent && IsDriveSymbolPresent && IsGoToGoogledriveBtnPresent)
			   {
		   		  System.out.println("Element is present on the GoogleDrive webpage");
				}else {   
		   	      System.out.println("Element is not present on the GoogleDrive page");
			   }
				  driver.navigate().to("http://google.com");;
				  Thread.sleep(3000);
				  
		//Google+
				  logs.debug("Inside GooglePlus Test Case");
				  driver.findElement(By.xpath(OR.getProperty("GoogleApp"))).click();
				  IsElementPresent(By.xpath(OR.getProperty("GooglePlusApp")));
				  Thread.sleep(3000);
								  
				  System.out.println("Page title = " +driver.getTitle());
				  logs.debug("Google Plus Title verified");
				  Thread.sleep(3000);
				    
				IsGooglePlusSearchPresent = IsElementPresent(By.xpath(OR.getProperty("GooglePlusSearch")));
				Thread.sleep(3000);
				
				driver.navigate().back();
				
				IsGooglePlusLogoPresent = IsElementPresent(By.xpath(OR.getProperty("GooglePlusLogo")));
				Thread.sleep(3000);
				
				 if (IsGooglePlusSearchPresent && IsGooglePlusLogoPresent)
				    {
			   		System.out.println("Element is present on the GooglePlus webpage");
				}else {   
			   		System.out.println("Element is not present on the GooglePlus page");
					 }
				 driver.navigate().to("http://www.google.com");
				Thread.sleep(3000);
				
			//GoogleTranslator		  
				  logs.debug("Inside GoogleTranslator Test Case");
				  driver.findElement(By.xpath(OR.getProperty("GoogleApp"))).click();
				  Thread.sleep(3000);
				  IsElementPresent(By.xpath(OR.getProperty("TranslatorApp")));
				  Thread.sleep(3000);
								  
				  System.out.println("Page title = " +driver.getTitle());
				  logs.debug("Google Translator Title verified");
				  Thread.sleep(3000);
				  
				  IsTranslateLogoPresent = IsElementPresent(By.xpath(OR.getProperty("TranslateLogo")));
				  Thread.sleep(3000);
					 
				  IsTranslateBtnPresent = IsElementPresent(By.xpath(OR.getProperty("TranslateBtn")));
				  Thread.sleep(3000);
				     
				  if (IsTranslateLogoPresent && IsTranslateBtnPresent)
				   {
		   		    System.out.println("Element is present on the GooglePlus webpage");
				   }else {   
		   			System.out.println("Element is not present on the GooglePlus page");
				   }
				  driver.navigate().to("http://www.google.com");
		  //GooglePhotos  
				  logs.debug("Inside GoogleTranslator Test Case");
				  driver.findElement(By.xpath(OR.getProperty("GoogleApp"))).click();
				  IsElementPresent(By.xpath(OR.getProperty("GooglePhotosApp")));
				  Thread.sleep(3000);
								  
				  System.out.println("Page title = " +driver.getTitle());
				  logs.debug("Google Translator Title verified");
				  Thread.sleep(3000);  
				  
					 IsGoToGooglePhotosPresent = IsElementPresent(By.id(OR.getProperty("GoToGooglePhotos"))); 
					 Thread.sleep(3000);
					 driver.navigate().back();
					 IsGooglePhotoLogoPresent =  IsElementPresent(By.xpath(OR.getProperty("GooglePhotosLogo"))); 
					 Thread.sleep(3000);
					  if (IsGooglePhotoLogoPresent && IsGoToGooglePhotosPresent)
					   {
			   		    System.out.println("Element is present on the GooglePhotos webpage");
					   }
					  else 
					   {   
			   			System.out.println("Element is not present on the GooglePhotos page");
					   }
					  driver.navigate().to("http://www.google.com");
		  }
			
		@DataProvider
		public static Object[][] getData(){
			
			return TestUtil.getData("TC_003");
		}
}

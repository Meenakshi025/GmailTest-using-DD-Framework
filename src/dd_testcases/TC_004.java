package dd_testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import dd_core.Page;
import dd_util.TestUtil;

public class TC_004 extends Page {
	
	String UName = " ";

	@BeforeTest
	public void isSkip(){
		
		if(!TestUtil.isExecutable("TC_004")){
			
			throw new SkipException("Skipping the test as the Run mode is No");
		   }
		}
		@Test(dataProvider="getData")
		public void VerifyGoogleAppsLogInAndLogOut(String Username, String Password) throws IOException, InterruptedException{
			
			logs.debug("Inside Google Apps LogIn and Logout Test");
			
			System.out.println("..........TC_004.To verify that the user is able to Sign-in into all the Google apps..........");
			
		//MyAccount	
			IsElementPresent(By.xpath(OR.getProperty("GoogleApp")));
		     Thread.sleep(3000);
		     
		     IsElementPresent(By.xpath(OR.getProperty("MyAccountApp")));
		     System.out.println("Page title = " +driver.getTitle());
		     logs.debug("My Account Title verified");
		     Thread.sleep(3000);
		     
		     IsElementPresent(By.xpath(OR.getProperty("MyAccountLogIn")));
		     
		     logindetails(By.xpath(OR.getProperty("EmailText")),Username,By.xpath(OR.getProperty("NextBtn")));
		     Thread.sleep(3000);
		     
		     logindetails(By.xpath(OR.getProperty("PasswordText")),Password,By.xpath(OR.getProperty("SignInBtn")));
		     
		     IsElementPresent(By.xpath(OR.getProperty("MyAccountLogoutBtn")));
		     
		     UName = driver.findElement(By.xpath(OR.getProperty("MALogInName"))).getText();
		     System.out.println("Login Persons Name = " + UName);
		     
		     IsElementPresent(By.xpath(OR.getProperty("MASignOutBtn"))); 
		     
		     driver.navigate().to("http://www.google.com");
		     
		//GoogleMaps	
		     
		     logs.debug("Inside Google Maps Test Case");
			 driver.findElement(By.xpath(OR.getProperty("GoogleApp"))).click();
			 driver.findElement(By.xpath(OR.getProperty("MapsApp"))).click();
			 Thread.sleep(3000);
			    
			 System.out.println("Page title = " +driver.getTitle());
			 logs.debug("google Maps Title verified");
			 Thread.sleep(3000); 
		     
			 IsElementPresent(By.xpath(OR.getProperty("GMLogIn")));
			 logindetails(By.xpath(OR.getProperty("EmailText")),Username,By.xpath(OR.getProperty("NextBtn")));
			 Thread.sleep(3000);
			 
			 logindetails(By.xpath(OR.getProperty("PasswordText")),Password,By.xpath(OR.getProperty("SignInBtn")));
		    
		     IsElementPresent(By.xpath(OR.getProperty("MapsLogOutbtn")));
		     Thread.sleep(3000);
		     
		     UName = driver.findElement(By.xpath(OR.getProperty("MLoginName"))).getText();
		     System.out.println("Login Persons Name = " + UName);
		     
		     IsElementPresent(By.xpath(OR.getProperty("MSignOutBtn"))); 
		     
		     driver.navigate().to("http://www.google.com");
		     
		//YouTube
		      logs.debug("Inside Google Youtube Test Case");
			  driver.findElement(By.xpath(OR.getProperty("GoogleApp"))).click();
			  driver.findElement(By.xpath(OR.getProperty("YoutubeApp"))).click();
			  Thread.sleep(3000);
			  
			  System.out.println("Page title = " +driver.getTitle());
			  logs.debug("Google YouTube Title verified");
			  Thread.sleep(3000); 
			  
			  IsElementPresent(By.xpath(OR.getProperty("YLogIn")));
		     
			  logindetails(By.xpath(OR.getProperty("EmailText")),Username,By.xpath(OR.getProperty("NextBtn")));
				 Thread.sleep(3000);
				 
				 logindetails(By.xpath(OR.getProperty("PasswordText")),Password,By.xpath(OR.getProperty("SignInBtn")));
			     
			     IsElementPresent(By.xpath(OR.getProperty("YLogOutBtn")));
				 Thread.sleep(3000);
				    
				    if(driver.getPageSource().contains("Meenifsss@gmail.com"))
				    {
				    System.out.println("Text is Present on the youtube webpage");
				    }
				    else
				    {
				    System.out.println("Text is not Present on the youtube webpage");
				    }
				    
				    IsElementPresent(By.partialLinkText(OR.getProperty("YSignOutbtn")));
					 Thread.sleep(7000);
					 
					 driver.navigate().to("http://www.google.com");
					 Thread.sleep(3000);
					 
			//Google Play
					 
					 logs.debug("Inside Google Play Test Case");
					 driver.findElement(By.xpath(OR.getProperty("GoogleApp"))).click();
					 driver.findElement(By.xpath(OR.getProperty("GooglePlay"))).click();
					 Thread.sleep(3000);
					  
					  System.out.println("Page title = " +driver.getTitle());
					  logs.debug("Google play Title verified");
					  Thread.sleep(3000); 
					  
					  IsElementPresent(By.xpath(OR.getProperty("PLogIn")));
					  	
					  logindetails(By.xpath(OR.getProperty("EmailText")),Username,By.xpath(OR.getProperty("NextBtn")));
					  Thread.sleep(3000);
						 
					  logindetails(By.xpath(OR.getProperty("PasswordText")),Password,By.xpath(OR.getProperty("SignInBtn")));
					  
					  IsElementPresent(By.xpath(OR.getProperty("PLogOutBtn")));
					  Thread.sleep(3000);
					  UName = driver.findElement(By.xpath(OR.getProperty("PLoginName"))).getText();
					  System.out.println("Login Persons Name = " + UName);
					  
					  IsElementPresent(By.xpath(OR.getProperty("PSignOutBtn")));

					  driver.navigate().to("http://www.google.com");
					  Thread.sleep(3000);
			
		//Google News
					  
					  logs.debug("Inside Google News Test Case");
						 driver.findElement(By.xpath(OR.getProperty("GoogleApp"))).click();
						 driver.findElement(By.xpath(OR.getProperty("GoogleNewsApp"))).click();
						 Thread.sleep(3000);
						  
						  System.out.println("Page title = " +driver.getTitle());
						  logs.debug("Google play Title verified");
						  Thread.sleep(3000); 
						  
						  IsElementPresent(By.xpath(OR.getProperty("NLogIn")));
						  	
						  logindetails(By.xpath(OR.getProperty("EmailText")),Username,By.xpath(OR.getProperty("NextBtn")));
						  Thread.sleep(3000);
							 
						  logindetails(By.xpath(OR.getProperty("PasswordText")),Password,By.xpath(OR.getProperty("SignInBtn")));	  
						  Thread.sleep(3000);
						  
						  IsElementPresent(By.xpath(OR.getProperty("NLogOutBtn")));
						  Thread.sleep(3000);
						  UName = driver.findElement(By.xpath(OR.getProperty("NLoginName"))).getText();
						  System.out.println("Login Persons Name = " + UName);
						  Thread.sleep(3000);
						  
						  IsElementPresent(By.xpath(OR.getProperty("NSignOutBtn")));

						  driver.navigate().to("http://www.google.com");
						  Thread.sleep(3000);
						  
				//Gmail
						  logs.debug("Inside Google gmail Test Case");
						  driver.findElement(By.xpath(OR.getProperty("GoogleApp"))).click();
						  driver.findElement(By.xpath(OR.getProperty("GmailApp"))).click();
						  Thread.sleep(3000);
							  
							System.out.println("Page title = " +driver.getTitle());
							logs.debug("Google play Title verified");
							Thread.sleep(3000); 
							  
							//IsElementPresent(By.xpath(OR.getProperty("GmailSignIn")));
							  	
							logindetails(By.xpath(OR.getProperty("EmailText")),Username,By.xpath(OR.getProperty("NextBtn")));
							Thread.sleep(3000);
								 
							logindetails(By.xpath(OR.getProperty("PasswordText")),Password,By.xpath(OR.getProperty("SignInBtn")));	  
							Thread.sleep(3000);
							  
							IsElementPresent(By.xpath(OR.getProperty("GLogOutBtn")));
							Thread.sleep(3000);
							UName = driver.findElement(By.xpath(OR.getProperty("GLoginname"))).getText();
							System.out.println("Login Persons Name = " + UName);
							Thread.sleep(3000);
							IsElementPresent(By.xpath(OR.getProperty("GSignOutbtn")));

							driver.navigate().to("http://www.google.com");
							Thread.sleep(3000);
							  
				//Google Drive
					  
							logs.debug("Inside Google Drive Test Case");
							driver.findElement(By.xpath(OR.getProperty("GoogleApp"))).click();
							driver.findElement(By.xpath(OR.getProperty("GoogleDriveApp"))).click();
							Thread.sleep(3000);
								  
							System.out.println("Page title = " +driver.getTitle());
							logs.debug("Google play Title verified");
							Thread.sleep(3000); 
								  
							// IsElementPresent(By.xpath(OR.getProperty("")));
								  	
							logindetails(By.xpath(OR.getProperty("EmailText")),Username,By.xpath(OR.getProperty("NextBtn")));
						    Thread.sleep(3000);
									 
							logindetails(By.xpath(OR.getProperty("PasswordText")),Password,By.xpath(OR.getProperty("SignInBtn")));	  
							Thread.sleep(3000);
							IsElementPresent(By.xpath(OR.getProperty("GDLogOutBtn")));
							Thread.sleep(3000);
							UName = driver.findElement(By.xpath(OR.getProperty("GDloginName"))).getText();
							System.out.println("Login Persons Name = " + UName);
							Thread.sleep(3000);
							IsElementPresent(By.xpath(OR.getProperty("GDSignOutBtn")));

							driver.navigate().to("http://www.google.com");
						    Thread.sleep(3000);
					//GooglePlus
							logs.debug("Inside Google Plus Test Case");
							driver.findElement(By.xpath(OR.getProperty("GoogleApp"))).click();
							driver.findElement(By.xpath(OR.getProperty("GooglePlusApp"))).click();
						    Thread.sleep(3000);
									  
						    System.out.println("Page title = " +driver.getTitle());
							logs.debug("Google play Title verified");
							Thread.sleep(3000); 
									  
							IsElementPresent(By.xpath(OR.getProperty("GPlusLogInBtn")));
									  	
						   logindetails(By.xpath(OR.getProperty("EmailText")),Username,By.xpath(OR.getProperty("NextBtn")));
						   Thread.sleep(3000);
										 
						   logindetails(By.xpath(OR.getProperty("PasswordText")),Password,By.xpath(OR.getProperty("SignInBtn")));	  
						   Thread.sleep(3000);
						   
						   IsElementPresent(By.xpath(OR.getProperty("GPlusLogOutbtn")));
						   Thread.sleep(3000);
						   
						   UName = driver.findElement(By.xpath(OR.getProperty("GPlusLoginName"))).getText();
						   System.out.println("Login Persons Name = " + UName);
						   Thread.sleep(3000);
						   IsElementPresent(By.xpath(OR.getProperty("GPlusSignOutBtn")));

						   driver.navigate().to("http://www.google.com");
						   Thread.sleep(3000);
						   
			//GoogleTranslator
						   logs.debug("Inside Google Translator Test Case");
							driver.findElement(By.xpath(OR.getProperty("GoogleApp"))).click();
							driver.findElement(By.xpath(OR.getProperty("TranslatorApp"))).click();
						    Thread.sleep(3000);
									  
						    System.out.println("Page title = " +driver.getTitle());
							logs.debug("Google play Title verified");
							Thread.sleep(3000); 
									  
							IsElementPresent(By.xpath(OR.getProperty("GTLogInBtn")));
									  	
						   logindetails(By.xpath(OR.getProperty("EmailText")),Username,By.xpath(OR.getProperty("NextBtn")));
						   Thread.sleep(3000);
										 
						   logindetails(By.xpath(OR.getProperty("PasswordText")),Password,By.xpath(OR.getProperty("SignInBtn")));	  
						   Thread.sleep(3000);
						   
						   IsElementPresent(By.xpath(OR.getProperty("GTLogOutBtn")));
						   Thread.sleep(3000);
						   
						   UName = driver.findElement(By.xpath(OR.getProperty("GTLoginName"))).getText();
						   System.out.println("Login Persons Name = " + UName);
								  
						   IsElementPresent(By.xpath(OR.getProperty("GTSignOutbtn")));
						   Thread.sleep(3000);
						   driver.navigate().to("http://www.google.com");
						   Thread.sleep(3000);
			
			//GooglePhotos
						   logs.debug("Inside Google Translator Test Case");
							driver.findElement(By.xpath(OR.getProperty("GoogleApp"))).click();
							driver.findElement(By.xpath(OR.getProperty("GooglePhotosApp"))).click();
						    Thread.sleep(3000);
									  
						    System.out.println("Page title = " +driver.getTitle());
							logs.debug("Google play Title verified");
							Thread.sleep(3000); 
									  
							IsElementPresent(By.xpath(OR.getProperty("GPLogInBtn")));
									  	
						   logindetails(By.xpath(OR.getProperty("EmailText")),Username,By.xpath(OR.getProperty("NextBtn")));
						   Thread.sleep(3000);
										 
						   logindetails(By.xpath(OR.getProperty("PasswordText")),Password,By.xpath(OR.getProperty("SignInBtn")));	  
						   Thread.sleep(3000);
						   
						   IsElementPresent(By.xpath(OR.getProperty("GPLogOutBtn")));
						   Thread.sleep(3000);
						   
						   UName = driver.findElement(By.xpath(OR.getProperty("GPLoginName"))).getText();
						   System.out.println("Login Persons Name = " + UName);
						   Thread.sleep(3000);
						   
						   IsElementPresent(By.xpath(OR.getProperty("GPSignOutBtn")));

						   driver.navigate().to("http://www.google.com");
						   Thread.sleep(3000);
		}
		
		@DataProvider
		public static Object[][] getData(){
			
			return TestUtil.getData("TC_004");
		}
}

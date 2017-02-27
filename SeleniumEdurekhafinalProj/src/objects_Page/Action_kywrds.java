package objects_Page;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import constants.Log;

import java.util.Scanner;

import javax.swing.JOptionPane;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import utilities.Locators;
import constants.ConstantVariables;
import evidences.ScreenShot;


public class Action_kywrds {
	
	public static List<WebElement> element_name;
	public static List<WebElement> element_title;
	public static WebDriver driver;
	public static WebElement element;
	
	
	//Test Case 1
	public static WebDriver browser_Open(WebDriver driver, String ipName) throws IOException{
		try{
		System.setProperty("webdriver.chrome.driver", "C:\\selenium3.0.1\\chromedriver.exe");
		driver = new ChromeDriver();
		Log.info("Browser Open");
		}
		catch(Exception e){
			Log.info("Not able to open Browser" +e.getMessage());
			ScreenShot.getScreenShot(driver, "browserIssue");
			
		}
		return driver;
		
	}
	public static void navigate(WebDriver driver, String sURLname) throws Exception{
		try{
		driver.get(sURLname);
		Log.info("navigate to website");
		}
		catch(Exception e){
			Log.info("Not able to navigate Browser" +e.getMessage());
			ScreenShot.getScreenShot(driver, "navigateIssue");
		}
	}
	
	public static WebElement Text_box(WebDriver driver, String sElementName) throws Exception{
		try{
		element = driver.findElement(Locators.getLocator(sElementName));
		Log.info(sElementName + " : entered");
		}
		catch(Exception e){
			Log.info(sElementName + " : Not able enter" +e.getMessage());
			ScreenShot.getScreenShot(driver, sElementName+" :Text_box method" );
		}
		return element;
	}
	
	public static void CloseTab(WebDriver driver) throws Exception{
		 try{
				String originalHandle = driver.getWindowHandle();
				for(String handle : driver.getWindowHandles())
				{
						if (!handle.equals(originalHandle)) {
						driver.switchTo().window(handle);
						driver.close();
						Thread.sleep(1000);
						}
				//String Handle = driver.getWindowHandle();		
				driver.switchTo().defaultContent();
				}
			   }catch(Exception e){
					Log.info( driver + " : handle not found" +e.getMessage());
					ScreenShot.getScreenShot(driver,"handle"+ " :close tab method" );
				}
				
	}
	public static void Mouseover(WebDriver driver, String sElementName) throws Exception{
		try{
			System.out.println(Locators.getLocator(sElementName));
		    element = driver.findElement(Locators.getLocator(sElementName));
		 	Actions act =new Actions(driver);
			act.moveToElement(element).perform();
	    
		Log.info(sElementName + " : entered");
		}
		catch(Exception e){
			
			Log.info(sElementName + " : Not able enter" +e.getMessage());
			ScreenShot.getScreenShot(driver, sElementName+" :Text_box method" );
		}
		//return element;
	}
	
	public static void MouseoverAndClick(WebDriver driver, String sElementName) throws Exception{
		try{
			WebElement element = driver.findElement(Locators.getLocator(sElementName));
			System.out.println(Locators.getLocator(sElementName));
			
		 	Actions act =new Actions(driver);
			act.moveToElement(element).click().build().perform();
			
  
		Log.info(sElementName + " : entered");
		}
		catch(Exception e){
			
			Log.info(sElementName + " : Not able enter" +e.getMessage());
			ScreenShot.getScreenShot(driver, sElementName+" :Text_box method" );
		}
		//return element;
	}
	public static void searchtitle_Home(WebDriver driver,String sActualTitle){
		try{
		String pagetitle = driver.getTitle();
		if(sActualTitle.equalsIgnoreCase(pagetitle)){
			System.out.println("Test case 1: pass");
			Log.info("Search title found");
		}
		else {
			System.out.println("Test case 1: Fail");
			Log.info("Search title not found");
			ScreenShot.getScreenShot(driver, "Searchtitlehome method" );
		}
		}
		catch(Exception e){
			Log.info("Not able to find page title" +e.getMessage());
			
		}
		
	}
	
	
	public static void getNames_Home(WebDriver driver, String ipName) throws Exception{
		try{
		element_name = driver.findElements(By.partialLinkText("upreet"));
		System.out.println("Number of names is : " +element_name.size());
		element_title = driver.findElements(By.className("title"));
		System.out.println("Number of Titles is : " +element_title.size());
		for (int i=0;i<element_title.size();i++){
		String elename = element_name.get(i).getText();
		String eleTitle = element_title.get(i).getText();
		System.out.println("Element name is ---------->>>>"+" " +i+ " " + elename + "Titles are -------->>>" + " " +i+ " " +eleTitle);
		Log.info("Names found");
		}
		}
		catch(Exception e){
			Log.info("Not able to find names" +e.getMessage());
			ScreenShot.getScreenShot(driver, "getNamesMethod" );
		}
	}
	
	public static void getLoginScreen_Home(WebDriver driver, String sLoginTitle) throws IOException{
		try{
		String Logintitle = driver.getTitle();
		System.out.println(Logintitle);
	
		if(Logintitle.equalsIgnoreCase(sLoginTitle)){
			
			System.out.println("The user needs to login before proceding further  ");
			Log.info("User needs to login before viewing profile");
		}
		else{
			System.out.println("Test case failed");
			}
		}
		catch(Exception e){
			Log.info("Not able to login" +e.getMessage());
			ScreenShot.getScreenShot(driver, "getloginscreenmethod");
		}
		
	}

	public static WebElement Click(WebDriver driver, String ipName) throws Exception {
			try {
				element = driver.findElement(Locators.getLocator(ipName));
				Log.info("Sign in button is enabled and clicked");
			} catch (Exception e) {
				//ScreenShot.getScreenShot(driver, ipName+" :Clickmethod" );
				e.printStackTrace();
			}
		return element;
	}

	public static void ScreenShot(WebDriver driver)
	{
		try{
	
		DateFormat dateFormat= new SimpleDateFormat("mm-dd-yyyy h-m-s");
		   Date date=new Date();
		   File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		   FileUtils.copyFile(src, new File("C:\\selenium3.0.1\\screenshots\\LoginPage_" + dateFormat.format(date) + ".png"));
	      } catch (Exception e) {
		   
		   e.printStackTrace();
		   }
		
	}
	
	public static WebElement getErrMsg_wrongpass(WebDriver driver, String ipName) throws Exception{
		try{
	
	//String errormessage = driver.findElement(By.xpath("//*[@id='control_gen_3']/div[1]/ul/li[2]/div/span")).getText();
	element = driver.findElement(Locators.getLocator(ipName));
	String colcor = element.getCssValue("color");
	
	if(colcor.equalsIgnoreCase(ConstantVariables.expectedColor)){
		System.out.println("Wrong username or password eneterd");
		driver.navigate().back();
		Log.info("Wrong password entered");
	}
	else{
		System.out.println("Test case failed");
		}
		}
		catch(Exception e){
			Log.info("Not able to get wrong passowrd error message" +e.getMessage());
			ScreenShot.getScreenShot(driver, "GetErrMsg_method" );
		}
		return element;
}
		
	//Test Case 5

	public static WebElement getErrMsg_wrongusername(WebDriver driver, String ipName){
		try{
		
		element = driver.findElement(Locators.getLocator(ipName));
		element.getText();
		//WebElement boxColor = driver.findElement(By.xpath("//*[@id='control_gen_3']//div[1]/ul/li[1]/div/span"));
		//String colcor = boxColor.getCssValue("color");
		
		
		if(element.equals(ConstantVariables.expectedError)){
			System.out.println("Wrong username or password eneterd");
			driver.navigate().back();
			Log.info("Wrong username entered");
		}
		else{
			System.out.println("Test case failed");
			ScreenShot.getScreenShot(driver, "Wrongusername_method" );

		}
		}
		catch(Exception e){
			Log.info("Not able to get wrong username error message" +e.getMessage());
			
		}
		return element;
		
	}
	
	//Test Case 6
	
	public static void getSuccess_Login(WebDriver driver, String ipName) throws Exception{
		try{
		
		WebElement loginFind = driver.findElement(By.xpath("//*[@id='top-header']/div/div[2]/ul/li[4]/a/img"));
		Actions builder = new Actions(driver);
		Action movetoELE = builder.moveToElement(loginFind).clickAndHold().build();
		movetoELE.perform();
		Thread.sleep(5000);
		WebElement signOutLink = driver.findElement(By.xpath("//*[@id='top-header']/div/div[2]/ul/li[4]/div/div/div[2]/ul/li[1]/div/span/span[3]/a"));
		String signOutLink_text = signOutLink.getText();
		//System.out.println(signOutLink_text);
		if(signOutLink_text.equalsIgnoreCase("signout")){
			Log.info("User succesfully logged in");
		}
		else
		{
			Log.info("User not able to log in");
			ScreenShot.getScreenShot(driver, "getsuccesslogin_method" );

		}
		}
		catch(Exception e){
			Log.info("Not able to login " +e.getMessage());
			
		}
	}
	
	//Test Case 7
	public static void getNameTitle_successLogin(WebDriver driver, String ipName) throws Exception{
		try{
		WebElement personName = driver.findElement(By.xpath("//*[@id='left-container']/div/div[1]/div[2]/section/div/div/h3/a"));
		String personName_Text = personName.getText();
		System.out.println(personName_Text);
		WebElement personTitle = driver.findElement(By.xpath("//*[@id='left-container']/div/div[1]/div[2]/section/div/div/a"));
		String personTitle_Text = personTitle.getText();
		Log.info("Found user Title");
		}
	catch(Exception e){
		Log.info("Not able to find user title" +e.getMessage());
		ScreenShot.getScreenShot(driver, "Getnametitle_method" );

	}
	}
	
	
	public static void waitfor() throws Exception {
		try{
		Thread.sleep(10000);
		Log.info("Waiting for 10 seconds");
		}
catch(Exception e){
	
		}
	}
	
	public static WebElement getCompanyName(WebDriver driver, String ipName) throws Exception {
		try{
		element = driver.findElement(Locators.getLocator(ipName));
		String cmpName_Text = element.getText();
		Log.info("Company Name found");
		}
catch(Exception e){
	Log.info("Not able to find comapny name" +e.getMessage());
	ScreenShot.getScreenShot(driver, "Getcompanyname_method" );

		}
		return element;
	}
	
	public static void browser_close(WebDriver driver){
		try{
		driver.close();
		}
catch(Exception e){
				
		}
	}

	// This method will be used to locate the view profile button 
			public static WebElement viewProfile_Home(WebDriver driver, String ipName) throws Exception{
				try{
					element= driver.findElement(Locators.getLocator(ipName));
					}
				catch(Exception e){
					ScreenShot.getScreenShot(driver, "viewprofilebutton_method" );

				}
				return element;
			}

			public static void Clickonuser() throws Exception {
//				try{
//				
////				String personName_Text = Action_kywrds.Click_anything(driver, ConstantVariables.userProfilePage_click_UserName).getText();
////				System.out.println(personName_Text);
////				Action_kywrds.Click_anything(driver, ConstantVariables.userProfilePage_personName).click();
////				}
////				catch(Exception e){
////					ScreenShot.getScreenShot(driver, "Clickonuser_method" );
////
//				}
				}
	}


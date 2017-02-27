package testcases;

import objects_Page.Action_kywrds;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import appModules.BrowserandURL;
import appModules.PostPage;
import utilities.ExcelReadWrite;
import utilities.Locators;
import utilities.SendEmail;
import constants.ConstantVariables;

public class testcase01 {
	/*
	open the browser
	enter the URL
	enter the first name
	enter the last name
	click on search
	verify the search page title and that u successfully logged in
	Close Browser
*/
	
	public static Locators objmap;
	static WebDriver driver;
	static String sheetname = ConstantVariables.shtName;
	@Test
	public static void TC001() throws Exception{
		String TC_name = new Object(){}.getClass().getEnclosingMethod().getName();
		System.out.println(TC_name);	
		ExcelReadWrite.openExcelFile(ConstantVariables.pathName);
		WebDriver driver = null;
		System.setProperty("webdriver.chrome.driver", "C:\\selenium3.0.1\\chromedriver.exe");
		driver = new ChromeDriver();
		
		objmap = new Locators(ConstantVariables.propertyFileLocation);
		constants.Log.startlogging("-------" + TC_name + "-----Started---" );
		
		//BrowserandURL.browser_open(driver);
		BrowserandURL.enter_URL(driver);
		BrowserandURL.enter_Text(driver, ConstantVariables.User, "admin");
		BrowserandURL.enter_Text(driver, ConstantVariables.Password, "demo123");
		BrowserandURL.ScreenShot(driver);
		BrowserandURL.Click(driver,ConstantVariables.LostPasswordlnk);
		BrowserandURL.Click(driver,ConstantVariables.LogInlnk);
		BrowserandURL.enter_Text(driver, ConstantVariables.User, "admin");
		BrowserandURL.enter_Text(driver, ConstantVariables.Password, "demo123");
		BrowserandURL.Click(driver,ConstantVariables.Loginbtn);
		
		Thread.sleep(1000);
		 
	    PostPage.moveOverAndClick(driver, ConstantVariables.DBPostslnk);
		PostPage.moveOverAndClick(driver, ConstantVariables.DBAddNewPostlnk);
		PostPage.enter_text(driver,ConstantVariables.DBTitleXP,"Title");
		PostPage.click(driver,ConstantVariables.DBBodyXP);
		PostPage.enter_text(driver,ConstantVariables.DBBodyContentXP,"Body");
		PostPage.click(driver,ConstantVariables.DBPreviewbtn);
		Thread.sleep(1000);
		PostPage.closeTab(driver);
		Thread.sleep(1000);

		PostPage.enter_text(driver,ConstantVariables.DBAddTagVal,"Test1,Deepak");
		PostPage.click(driver,ConstantVariables.DBAddbtn);
		PostPage.click(driver,ConstantVariables.DBPreviewbtn);
		Thread.sleep(5000);
		PostPage.closeTab(driver);
		PostPage.enter_text(driver,ConstantVariables.DBTitleXP,"");					  
		//PostPage.click(driver,ConstantVariables.DBSettingsId);
		//PostPage.click(driver,ConstantVariables.DB_CHKBOXDSlugXP);
		
		PostPage.moveOver(driver, ConstantVariables.DBAdminBarlnk);
		//Thread.sleep(1000);
		PostPage.moveOverAndClick(driver, ConstantVariables.DBLogoutlnk);
		Action_kywrds.waitfor();
		SendEmail.SendMessage("ajay_pappan@newyorklife.com", "test", "this is a test message","C:\\Users\\t15clsp\\workspaceEdurekha\\SeleniumEdurekhafinalProj\\test-output\\emailable-report.html");
		
		//ProfilePageVerify.searchTitle(driver);
		//Action_kywrds.browser_close(driver);
		constants.Log.Endlogging("----------" + TC_name + "---Ended---");
		}
	}



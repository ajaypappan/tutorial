package appModules;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import objects_Page.Action_kywrds;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;



import org.openqa.selenium.firefox.FirefoxProfile;

import constants.ConstantVariables;

public class BrowserandURL {
	
	public static WebDriver browser_open(WebDriver driver){
		System.setProperty("webdriver.chrome.driver", "C:\\selenium3.0.1\\chromedriver.exe");
		driver = new ChromeDriver();
		
	return driver;
	}
	
	public static void enter_URL(WebDriver driver){
		driver.get(ConstantVariables.URL);
		driver.manage().window().maximize();
	}
	public static void enter_UserName(WebDriver driver) throws Exception{
            Action_kywrds.Text_box(driver,ConstantVariables.User).sendKeys("admin");
	}
	public static void enter_Text(WebDriver driver,String propName,String data) throws Exception{
       	Action_kywrds.Text_box(driver, propName).sendKeys(data);
    }
	public static void Click(WebDriver driver,String propName ) throws Exception{
       	Action_kywrds.Click(driver, propName).click();
    }
	public static void closeBrowser(WebDriver driver){
		driver.close();
	}
	
	public static void ScreenShot(WebDriver driver ) throws Exception{
		Action_kywrds.ScreenShot(driver);
    }
	public static void waitfor() throws Exception{
		Thread.sleep(6000);
	}
}

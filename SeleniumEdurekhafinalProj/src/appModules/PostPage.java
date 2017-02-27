package appModules;

import org.openqa.selenium.WebDriver;

import constants.Log;
import evidences.ScreenShot;
import objects_Page.Action_kywrds;

public class PostPage {
	
	public static void enter_text(WebDriver driver, String propName,String data) throws Exception{
		Action_kywrds.Text_box(driver, propName).sendKeys(data);
	}
	
	public static void click(WebDriver driver, String propName) throws Exception{
		Action_kywrds.Click(driver, propName).click();
	}
	
   public static void moveOver(WebDriver driver,String propName) throws Exception{
   Action_kywrds.Mouseover(driver, propName);
	}
   public static void moveOverAndClick(WebDriver driver,String propName) throws Exception{
	   Action_kywrds.MouseoverAndClick(driver, propName);
		}
   public static void closeTab(WebDriver driver) throws Exception{
	   Action_kywrds.CloseTab(driver);
   }
	  

	 

}

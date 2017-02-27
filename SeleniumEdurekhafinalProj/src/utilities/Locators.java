package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.By;

public class Locators {
	static Properties prop;
	
	public Locators(String mapName) throws Exception{
		prop = new Properties();
		FileInputStream fi = new FileInputStream(mapName);
		prop.load(fi);
		fi.close();
	}

	public static By getLocator(String eleName) throws Exception{
		String Locator = prop.getProperty(eleName) ; // get properties;
		String l_Type = Locator.split(":")[0];
		String l_Value = Locator.split(":")[1];
		
		if(l_Type.equalsIgnoreCase("id"))
			return By.id(l_Value);
		
		else if(l_Type.equalsIgnoreCase("Name"))
			return By.name(l_Value);
		
		else if(l_Type.equalsIgnoreCase("partialLinktext"))
			return By.partialLinkText(l_Value);
		
		else if((l_Type.equalsIgnoreCase("link")) || l_Type.equalsIgnoreCase("linktext"))
			return By.linkText(l_Value);
		
		else if(l_Type.equalsIgnoreCase("xpath"))
			return By.xpath(l_Value);
		
		else if((l_Type.equalsIgnoreCase("class")) || l_Type.equalsIgnoreCase("classname"))
			return By.className(l_Value);
		 	
		else if((l_Type.equalsIgnoreCase("Tag")) || l_Type.equalsIgnoreCase("tagname"))
			return By.tagName(l_Value);
			
		else if((l_Type.equalsIgnoreCase("css")) || l_Type.equalsIgnoreCase("cssselector"))
			return By.cssSelector(l_Value);
		
		else 
			throw new Exception("locator type ------->>>>>" + l_Type + " ----- Not found");
		
	}	
	}


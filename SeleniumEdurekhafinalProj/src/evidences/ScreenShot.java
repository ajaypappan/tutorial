package evidences;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Random;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShot {
	
	public static void getScreenShot(WebDriver driver, String pic_Name) throws IOException{
		String path = "C:\\selenium3.0.1\\screenshots\\" + new Date() + pic_Name+(new Random().nextInt())+".jpeg";
		File filebrowser = new File(path);
		takeshot((TakesScreenshot)driver, filebrowser, pic_Name);
	}

	private static void takeshot(TakesScreenshot driver, File filebrowser,String pic_Name) throws IOException {
		try {
			File filesrc = driver.getScreenshotAs(OutputType.FILE);
			FileUtils.moveFile(filesrc, filebrowser);		
		} catch (Exception e) {
			System.out.println("Screenshot method not working");
	}
}
}

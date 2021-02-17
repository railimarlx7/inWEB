package core;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Log {
		
	private static WebDriver driver = DriveFactory.driver;
	
	public static void screenshot() throws IOException{	
		TakesScreenshot ss =  ((TakesScreenshot) driver);
		File log = ss.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(log,  new File("Log/screenshot.jpg"));
	}
	
}
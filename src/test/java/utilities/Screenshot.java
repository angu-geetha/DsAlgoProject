package utilities;

import java.io.File;

import org.apache.logging.log4j.core.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Screenshot {

	
	public static void takescreenshot() {
		
	WebDriver chromedriver = new ChromeDriver();
		chromedriver.get("https://dsportalapp.herokuapp.com/register");
		
		
		TakesScreenshot screenshot = (TakesScreenshot)chromedriver;
		 File srcfile =screenshot.getScreenshotAs(OutputType.FILE);
		
		
	
	}
	
	
}

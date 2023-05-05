package portal;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class PortalMain {
	
	WebDriver chromedriver;
	final String homePageUrl = "https://dsportalapp.herokuapp.com/" ;
	IndexPage indexPage ;
	
	@BeforeTest
	public void setUp() {
		 chromedriver = new ChromeDriver();
	
		 chromedriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		 chromedriver.manage().window().maximize();
		
		 indexPage = new IndexPage(chromedriver);
		
		
		
	} 

	@Test
	public void testCase001() {
		indexPage.openDsAlgoPage();
		indexPage.clickGetStarted();
	}
	
}

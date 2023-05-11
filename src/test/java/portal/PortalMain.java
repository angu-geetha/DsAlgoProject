package portal;

import static org.testng.Assert.assertEquals;

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
	Homepage homepage;
	Registerpage registerpage;
	
	
	
	@BeforeTest
	public void setUp() {
		 chromedriver = new ChromeDriver();
	
		 chromedriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		 chromedriver.manage().window().maximize();
		
		 indexPage = new IndexPage(chromedriver);
		 homepage =  new Homepage(chromedriver);
		 registerpage = new Registerpage(chromedriver);
		
	} 

	@Test
	public void testCase001() {
		indexPage.openDsAlgoPage();
		indexPage.clickGetStarted();
		String url =chromedriver.getCurrentUrl();
		assertEquals(url, "https://dsportalapp.herokuapp.com/home");
		
		homepage.opensregisterPage();
		registerpage.clickRegisterbtn();  
		//use screenshot
		registerpage.inputusername("Numpy@sdet84_1");
		registerpage.clickRegisterbtn();  
	
		registerpage.sendpassword("testpassword");
		registerpage.clickRegisterbtn();  
		registerpage.clearusername();
		registerpage.inputusername("&**&**&");
		registerpage.clearpassword();
		registerpage.sendpassword("testpassword");
		registerpage.sendpasswordConfirmation("testpassword");
		
		registerpage.clickRegisterbtn();  
		// registerpage.signout();
		registerpage.clearusername();
		registerpage.inputusername("Numpy@sdet84_1");
		registerpage.clearpassword();
		registerpage.sendpassword("RT56YUabc");
		registerpage.clearpasswordconfirmation();
		registerpage.sendpasswordConfirmation("RT56YUabc");
		registerpage.clearusername();
		registerpage.inputusername("Numpy@sdet84_1");
		registerpage.clearpassword();
		registerpage.sendpassword("testpassword");
		registerpage.clearpasswordconfirmation();
		registerpage.sendpasswordConfirmation("testpassword1");
	
		
		
	}
	
}

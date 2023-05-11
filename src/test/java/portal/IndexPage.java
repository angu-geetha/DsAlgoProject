package portal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class IndexPage {
	WebDriver chromedriver;
	final String homePageUrl = "https://dsportalapp.herokuapp.com/" ;
	By getStartedButton = By.xpath("//button[text()='Get Started']");
	
	public void clickGetStarted() {
		chromedriver.findElement(getStartedButton).click();
	}
	public void openDsAlgoPage() {
		chromedriver.get(homePageUrl);
		
	}

	public IndexPage(WebDriver chromedriver) {
		super();
		this.chromedriver = chromedriver;
	}

}

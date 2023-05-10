package portal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Registerpage {
	WebDriver chromedriver;
	final String homePageUrl = "https://dsportalapp.herokuapp.com/home" ;
	By  registerbtn = By.xpath("//input[@value='Register']");
	By username  =  By.name("username");
	By password1 =  By.name("password1");                      
	By password2confirmation =  By.name("password2"); 
	By  signoutbtn = By.xpath("//a[text()='Sign out']");
	By errorElement =  By.xpath("//div[@class='alert alert-primary']");

public Registerpage(WebDriver chromedriver) {
	super();
	this.chromedriver = chromedriver;
	}






public void clickRegisterbtn() {
		
		chromedriver.findElement(registerbtn).click();
		
	}
	
public void inputusername(String name) {
	
	
	chromedriver.findElement(username).sendKeys(name);
	
}
		
public void sendpassword(String password) {
	
	
	chromedriver.findElement(password1).sendKeys(password);
	
}

public void sendpasswordConfirmation(String passwordconfirmation) {
	
	
	chromedriver.findElement(password2confirmation).sendKeys(passwordconfirmation);
	
}

public void clearusername() {
	
	
	chromedriver.findElement(username).clear();
	
}

public String findusername() {
	
	
	String userNameValue = chromedriver.findElement(username).getAttribute("value");
	return userNameValue;
	
}

public String findPassword() {
	
	
	String passwordNameValue = chromedriver.findElement(password1).getAttribute("value");
	return passwordNameValue;
	
}

public String findPasswordconfirmation() {
	
	
	String passwordconfNameValue = chromedriver.findElement(password2confirmation).getAttribute("value");
	return passwordconfNameValue;
	
}



public void getusernameeerormsg() {
	
	
	chromedriver.findElement(username).clear();
	
}
public void clearpassword() {
	
	
	chromedriver.findElement(password1).clear();
	
}
public void clearpasswordconfirmation () {
	
	
	chromedriver.findElement(password2confirmation).clear();
	
}
public void signout() {
	
	
	chromedriver.findElement(signoutbtn).click();
	
}
public String getErrorElementg() {
	
	return chromedriver.findElement(errorElement).getText();
	
}

public String usernameErrorMsg() {
	return chromedriver.findElement(username).getAttribute("validationMessage");
	
}
public String passwordErrorMsg() {
	return chromedriver.findElement(password1).getAttribute("validationMessage");
	
}
public String passwordconfirmationErrorMsg() {
	return chromedriver.findElement(password2confirmation).getAttribute("validationMessage");
	
}


	
}


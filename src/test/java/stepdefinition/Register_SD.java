package stepdefinition;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import portal.Homepage;
import portal.IndexPage;
import portal.Registerpage;

public class Register_SD {
	WebDriver chromedriver;

	final String homePageUrl = "https://dsportalapp.herokuapp.com/";

	IndexPage indexPage;

	Homepage homepage;

	Registerpage registerpage;
	
	public Register_SD() {

		chromedriver = new ChromeDriver();

		chromedriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		chromedriver.manage().window().maximize();

		indexPage = new IndexPage(chromedriver);

		homepage = new Homepage(chromedriver);

		registerpage = new Registerpage(chromedriver);

		}

	@Given("The user opens DS Algo portal link")
	public void the_user_opens_ds_algo_portal_link() {
		indexPage.openDsAlgoPage();
	}

	@When("The user clicks the {string} button")
	public void the_user_clicks_the_button(String string) {
		indexPage.clickGetStarted();
	}

	@Then("The user should be redirected to homepage")
	public void the_user_should_be_redirected_to_homepage() {
		String url = chromedriver.getCurrentUrl();

		assertEquals(url, "https://dsportalapp.herokuapp.com/home");
	}
	
	@Given("The user opens register page")
	public void the_user_opens_register_page() {
		homepage.opensregisterPage();
	}
	
	

	@When("User clicks registerbutton with all fields empty")
	public void user_clicks_registerbutton_with_all_fields_empty() {
		//if user isempty && pwwd is empty && pssconfi is emptyy

		String userNameValue =registerpage.findusername();

		String passwordNameValue =registerpage.findPassword();

		String passwordconfNameValue=registerpage.findPasswordconfirmation();

		if (userNameValue.isEmpty()&& passwordNameValue.isEmpty()&& passwordconfNameValue.isEmpty()) {

		registerpage.clickRegisterbtn();

		}
	}

	@Then("{string} errormessage must display for feild {string}")
	public void errormessage_must_display_for_feild(String message, String feildName) {
		String formMessage;

		if(feildName.contentEquals("username")) {

			formMessage = registerpage.usernameErrorMsg();

		} else if(feildName.contentEquals("password")){

			formMessage = registerpage.passwordErrorMsg();

		} else {

			formMessage = registerpage.passwordconfirmationErrorMsg();

		}

		assertEquals(formMessage, message);

		System.out.println("I am ath the message "+formMessage);
	}

	@When("User clicks registerbutton after entering username  {string} with others fields empty")
	public void user_clicks_registerbutton_after_entering_username_with_others_fields_empty(String userName) {
		registerpage.inputusername(userName);

		String passwordNameValue =registerpage.findPassword();

		String passwordconfNameValue=registerpage.findPasswordconfirmation();

		if ( passwordNameValue.isEmpty()&& passwordconfNameValue.isEmpty()) {

		registerpage.clickRegisterbtn();
		
		}
	}

	@When("User clicks registerbutton after entering username  {string}  and {string} with password confirmation field empty")
	public void user_clicks_registerbutton_after_entering_username_and_with_password_confirmation_field_empty(String userName, String psswd) {
		registerpage.inputusername(userName);

		registerpage.sendpassword(psswd);

		String passwordconfNameValue=registerpage.findPasswordconfirmation();

		if ( passwordconfNameValue.isEmpty()) {

		registerpage.clickRegisterbtn();
		}
	}

	@When("User enters {string} , {string}, {string} with characters other than letters,digits and {string}")
	public void user_enters_with_characters_other_than_letters_digits_and(String userName, String psswd, String confirmPsswd, String specialCaracter) {
		registerpage.clearusername();

		registerpage.inputusername(userName);

		registerpage.clearpassword();

		registerpage.sendpassword(psswd);

		registerpage.sendpasswordConfirmation(confirmPsswd);
		registerpage.clickRegisterbtn();
	
		
	}

	@Then("{string}  error msg  must display")
	public void enter_a_valid_username_error_msg_must_display(String string) {
		String error = registerpage.getErrorElementg();
		assertEquals(error,string);
	}

	@Given("User gets  error message for username already exists")
	public void user_gets_error_message_for_username_already_exists() {
	    
	}

	@When("User enters valid existing {string} with  {string} and {string}")
	public void user_enters_valid_existing_with_and(String userName, String psswd, String confirmPsswd) {
		registerpage.clearusername();

		registerpage.inputusername(userName);

		registerpage.clearpassword();

		registerpage.sendpassword(psswd);

		registerpage.clearpasswordconfirmation();

		registerpage.sendpasswordConfirmation(confirmPsswd);
		registerpage.clickRegisterbtn();

	}

	

	@When("User clicks registerbutton after entering valid {string}  and different passwords in {string} and {string}")
	public void user_clicks_registerbutton_after_entering_valid_and_different_passwords_in_and(String userName, String psswd, String confirmPsswd) {
		registerpage.clearusername();

		registerpage.inputusername(userName);

		registerpage.clearpassword();

		registerpage.sendpassword(psswd);

		registerpage.clearpasswordconfirmation();

		registerpage.sendpasswordConfirmation(confirmPsswd);
		registerpage.clickRegisterbtn();

	}

	
	
}

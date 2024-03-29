package stepDef;

import java.time.Duration;

import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;
import org.junit.rules.ErrorCollector;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.object.respository.Homepage;
import com.util.ReadConfig;
import com.util.WaitUtils;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class MCFSteps {

	Base base;
	Homepage hp;
	WaitUtils waitUtils;
	ReadConfig config;
	
	public MCFSteps() {
		hp = new Homepage(base);
	}
	
	@Given("I access MCF portal")
	public void i_access_mcf_portal() {
		base.getDriver().get(config.readProperty("url"));
	    // Implicit wait
	    base.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	@Then("I should see the MCF login page")
	public void i_should_see_the_mcf_login_page() {
		boolean bFlag=false;
	    try {
	    	waitUtils.waitForElementToBeClickable(hp.username);
	    	waitUtils.waitForElement(hp.txtUsername, 20, 500);
	    	bFlag = base.getDriver().findElement(By.xpath("//h5[contains(text(),'User Login:')]")).isDisplayed();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@When("I click on FREE ACCOUNT SIGNUP! button")
	public void i_click_on_free_account_signup_button() {
	    hp.signup.click();
	}
	
	@When("I enter Name in the Name text field")
	public void i_enter_name_in_the_name_text_field() {
		hp.name.sendKeys("Suma");
	}
	
	@When("I enter any valid email address in E-mail Address field")
	public void i_enter_any_valid_email_address_in_e_mail_address_field() {
		hp.setEmail("suma@gmail.com");
		String email = hp.getEmail();
		//Assert.assertEquals("Expected email is not macthing with actual email entered","suma@gmail.com", email);
		ErrorCollector collector = new ErrorCollector();
		collector.checkThat(email, "suma123@gmail.com", null);
	}
	
	
	@When("I enter any valid {string} address in E-mail Address field")
	public void i_enter_any_valid_address_in_e_mail_address_field(String emailAddress) {
		hp.setEmail(emailAddress);
		String email = hp.getEmail();
		Assert.assertEquals("Expected email is not macthing with actual email entered",emailAddress, email); 
	}
	
	@When("I enter user name in User Name field")
	public void i_enter_user_name_in_user_name_field() {
	    hp.username.sendKeys("suma123");
	}
	
	@When("I enter password in Password field")
	public void i_enter_password_in_password_field() {
	    hp.password.sendKeys("Secure*12");
	}
	
	@When("re-enter the password in Re-type Password field")
	public void re_enter_the_password_in_re_type_password_field() {
	    hp.retypePassword.sendKeys("Secure*12");
	}
	
	@When("I select the Terms of Service & Privacy Statement checkbox")
	public void i_select_the_terms_of_service_privacy_statement_checkbox() {
	   hp.agree.click(); 
	}
	
	@When("I click on Submit button")
	public void i_click_on_submit_button() {
	   hp.Submit.click();
	}
	
	@Then("I should see a registration confirmation message")
	public void i_should_see_a_registration_confirmation_message() {
	    String message = hp.signUpConfirmMessage.getText();
	    Boolean[] expected = {true};
	    Boolean[] actual = {message.contains("SUCCESS")};
	    Assert.assertArrayEquals("Failed to sign up since :", expected, actual);
	}
}

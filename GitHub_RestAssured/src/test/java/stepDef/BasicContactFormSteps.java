package stepDef;

import org.junit.Assert;

import com.object.respository.BasicContactFormPage;
import com.object.respository.Homepage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BasicContactFormSteps {
	
	Homepage hp;
	BasicContactFormPage bcf;
	Base driver;
	
	public BasicContactFormSteps() {
		hp = new Homepage(driver);
		bcf = new BasicContactFormPage(driver);
	}
	
	@When("I click on Sample Forms tab")
	public void i_click_on_sample_forms_tab() {
	    hp.sampleForms.click();
	}
	
	@When("I navigate to Basic Contact Form page from left navigation")
	public void i_navigate_to_basic_contact_form_page_from_left_navigation() {
		bcf.basicContactForm.click();
	}
	
	@When("I enter {string} in the name text field")
	public void i_enter_in_the_name_text_field(String yourName) {
	   bcf.yourName.sendKeys(yourName);
	}
	
	@When("I enter {string} in the email address field")
	public void i_enter_in_the_email_address_field(String emailAddress) {
	    bcf.emailAddress.sendKeys(emailAddress);
	}
	
	@When("I enter {string} in the message description field")
	public void i_enter_in_the_message_description_field(String message) {
		bcf.message.sendKeys(message);
	}
	
	@When("I click on Submit button in basic contact for page")
	public void clickSubmit() {
		bcf.submit.click();
	}
			
	@Then("I should see the confirmation message")
	public void i_should_see_the_confirmation_message() {
	    String actMessage = bcf.confirmationMessage.getText();
	    Assert.assertEquals("Expected message is not same as actual message", "Thank You", actMessage);
	}

}

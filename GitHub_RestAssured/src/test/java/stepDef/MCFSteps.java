package stepDef;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class MCFSteps {

	Base base;
	
	@Given("I access MCF portal")
	public void i_access_mcf_portal() {
	    base.getDriver().get("https://www.mycontactform.com/");
	}
	
	@Then("I should see the MCF login page")
	public void i_should_see_the_mcf_login_page() {
		boolean bFlag=false;
	    try {
	    	bFlag = base.getDriver().findElement(By.xpath("//h5[contains(text(),'User Login:')]")).isDisplayed();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

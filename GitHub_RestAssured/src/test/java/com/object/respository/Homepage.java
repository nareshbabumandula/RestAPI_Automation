package com.object.respository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import stepDef.Base;

public class Homepage {

	Base driver;
	
	@FindBy(linkText = "Sample Forms")
	public WebElement sampleForms;

	@FindBy(partialLinkText = "FREE ACCOUNT")
	public WebElement signup;

	// Page object or page element
	public static By txtUsername = By.id("name");

	// Page factory element
	@FindBy(id = "name")
	public WebElement name;

	@FindBy(how=How.ID,using = "email")
	public WebElement email;

	@FindBy(id = "user_signup")
	public WebElement username;

	@FindBy(id = "pass_signup")
	public WebElement password;

	@FindBy(id = "pass2")
	public WebElement retypePassword;

	@FindBy(id = "useragree")
	public WebElement agree;

	@FindBy(name = "Submit")
	public WebElement Submit;

	@FindBy(xpath = "//span[contains(text(),'SUCCESS')]")
	public WebElement signUpConfirmMessage;

	// Re-usable Method
	public void setEmail(String emailAddress) {
		email.sendKeys(emailAddress);
	}

	// Re-usable Method
	public String getEmail() {
		String actEmail = email.getAttribute("value");
		return actEmail;
	}


	public Homepage(Base driver) {
		this.driver = driver;
		PageFactory.initElements(driver.getDriver(),this);
	}
}

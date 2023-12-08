package com.object.respository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import stepDef.Base;

public class Homepage {
	
	Base driver;
	
	@FindBy(partialLinkText = "FREE ACCOUNT")
	public WebElement signup;
	
	@FindBy(id = "name")
	public WebElement name;
	
	@FindBy(id = "email")
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
		
	public Homepage(Base driver) {
		this.driver = driver;
		PageFactory.initElements(driver.getDriver(),this);
	}
}

package com.object.respository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import stepDef.Base;

public class BasicContactFormPage {
	
	Base driver;
	
	@FindBy(linkText = "Basic Contact Form")
	public WebElement basicContactForm;
	
	@FindBy(name="q[1]")
	public WebElement yourName;
	
	@FindBy(id = "email")
	public WebElement emailAddress;
	
	@FindBy(name="q[2]")
	public WebElement message;
	
	@FindBy(name="submit")
	public WebElement submit;
	
	@FindBy(xpath="//h4[contains(text(),'Thank You')]")
	public WebElement confirmationMessage;

	public BasicContactFormPage(Base driver) {
		this.driver=driver;
		PageFactory.initElements(driver.getDriver(),this);
	}

}

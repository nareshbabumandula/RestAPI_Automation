package stepDef;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
	Base base;

	public WebDriver driver;

	@Before
	public void launchBrowser() {
		System.out.println("This will run before every scenario");
	}

	@After
	public void launchCloseBrowser() {
		System.out.println("This will run after every scenario");
		base.getDriver().quit();
	}

}

package stepDef;

import org.openqa.selenium.WebDriver;
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
	public void launchCloseBrowser() throws InterruptedException {
		System.out.println("This will run after every scenario");
		Thread.sleep(4000);
		base.getDriver().quit();
	}

}

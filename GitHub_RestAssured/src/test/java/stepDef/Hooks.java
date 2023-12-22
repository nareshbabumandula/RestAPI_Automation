package stepDef;

import org.openqa.selenium.WebDriver;

import com.util.ScreenshotUtils;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
	Base base;

	public WebDriver driver;

	@Before
	public void launchBrowser() {
		System.out.println("This will run before every scenario");
	}

	@After
	public void launchCloseBrowser(Scenario scenario) throws InterruptedException {
		System.out.println("This will run after every scenario");
		if (scenario.isFailed()) {
            ScreenshotUtils.captureScreenshot(Base.getDriver(), scenario.getName().replaceAll(" ", "_"));
        }
		Thread.sleep(4000);
		if (!(base.getDriver()==null)) {
			base.getDriver().quit();
		}
		
	}
	

}

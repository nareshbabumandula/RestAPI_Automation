package stepDef;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GithubUISteps {
	
	WebDriver driver;
	
	@Given("I login into Github portal")
	public void verifyLogin() throws InterruptedException {
	   System.setProperty("webdriver.chrome.driver", "./browsers/chromedriver.exe");
	   ChromeOptions options = new ChromeOptions();
	   options.addArguments("--remote-allow-origins=*");
	   driver = new ChromeDriver(options);
	   driver.get("https://github.com/");
	   driver.manage().window().maximize();
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	   driver.findElement(By.linkText("Sign in")).click();
	   driver.findElement(By.id("login_field")).sendKeys("qarealtimetraining@gmail.com");
	   driver.findElement(By.id("password")).sendKeys("Secure*1234$");
	   driver.findElement(By.xpath("//input[@name='commit']")).click();
	   System.out.println("Logged into github account"); 
	}

	@When("I create a repository on GitHub")
	public void createRepository() {
		driver.findElement(By.xpath("//span[contains(text(),'New') and @class='Button-label']")).click();
		driver.findElement(By.id(":r2:")).sendKeys("TestRepo222");
		boolean blnRepo = driver.findElement(By.id("RepoNameInput-is-available")).isDisplayed();
		if (blnRepo) {
			System.out.println("Repository is available");
		} else {
			System.out.println("Cannot create repo as it already exists");
		}
		driver.findElement(By.xpath("//input[@id=':r8:']")).click(); //Click ReadMe checkbox
		driver.findElement(By.xpath("//span[contains(text(),'Create repository')]")).click();
	}

	@When("I create a repository on GitHub with name {string}")
	public void createRepositories(String repoName) throws InterruptedException {
		driver.findElement(By.xpath("//span[contains(text(),'New') and @class='Button-label']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@aria-describedby='RepoNameInput-is-available RepoNameInput-message']")).sendKeys(repoName);
		boolean blnRepo = driver.findElement(By.id("RepoNameInput-is-available")).isDisplayed();
		if (blnRepo) {
			System.out.println("Repository is available");
		} else {
			System.out.println("Cannot create repo as it already exists");
		}
		driver.findElement(By.xpath("//input[@name='Description']")).sendKeys("This repo is created via Selenium");
		driver.findElement(By.xpath("//input[@type='checkbox' and contains(@id,':r')]")).click(); //Click ReadMe checkbox
		driver.findElement(By.xpath("//span[contains(text(),'Create repository')]")).click();
	}

	
	
	@Then("I can see the project created")
	public void verifyRepository() throws InterruptedException {
		String currentURL = driver.getCurrentUrl();
		if (currentURL.contains("TestRepo222")) {
			System.out.println("Repository created successfully");
		} else {
			System.out.println("Failed to create repository");
		}
		System.out.println("Successfully verfied the github repository..!");
		Thread.sleep(4000);
		driver.quit();
	}

	
	@Then("I can see the project created with name {string}")
	public void verifyRepositories(String repoName) throws InterruptedException {
		String currentURL = driver.getCurrentUrl();
		if (currentURL.contains(repoName)) {
			System.out.println("Repository created successfully");
		} else {
			System.out.println("Failed to create repository");
		}
		System.out.println("Successfully verfied the github repository..!");
		Thread.sleep(4000);
		driver.quit();
	}


}

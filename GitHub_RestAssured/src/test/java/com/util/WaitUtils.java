package com.util;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import stepDef.Base;

public class WaitUtils {

	Base driver;
	private final WebDriverWait wait;

	public WaitUtils(Base driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(Base.getDriver(), Duration.ofSeconds(20));
	}

	public void waitForElementToBeClickable(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void waitForElementToBeVisible(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void waitForElementToBeClickable(By element) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public WebElement waitForElement(By locator, int timeoutInSeconds, int pollingEveryInMilliseconds) {
		Wait<WebDriver> wait = new FluentWait<>(Base.getDriver())
				.withTimeout(Duration.ofSeconds(timeoutInSeconds))
				.pollingEvery(Duration.ofMillis(pollingEveryInMilliseconds))
				.ignoring(NoSuchElementException.class);

		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
}

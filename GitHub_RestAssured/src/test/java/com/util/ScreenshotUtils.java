package com.util;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import stepDef.Base;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

public class ScreenshotUtils {
	
	private static final String SCREENSHOT_FOLDER = "screenshots/";
		
	public static void captureScreenshot(WebDriver driver, String screenshotName) {
		try {
			TakesScreenshot ts = (TakesScreenshot)Base.getDriver();
			File source = ts.getScreenshotAs(OutputType.FILE);
			String destination = SCREENSHOT_FOLDER + screenshotName + ".png";
			Path screenshotPath = Paths.get(SCREENSHOT_FOLDER);

			if (!Files.exists(screenshotPath)) {
				Files.createDirectories(screenshotPath);
			}

			Files.copy(Objects.requireNonNull(source.toPath()), Paths.get(destination));
			System.out.println("Screenshot captured: " + destination);
		} catch (Exception e) {
			System.out.println("Failed to capture screenshot: " + e.getMessage());
		}
	}
}
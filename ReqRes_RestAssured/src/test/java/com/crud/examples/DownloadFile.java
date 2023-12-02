package com.crud.examples;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.File;
import static io.restassured.RestAssured.*;


public class DownloadFile {

	@Test
	public void verifyFileDownload ()  {

		int fileSize;
		File filePath =  new File (System.getProperty("user.dir")+"/resources/rest-assured-3.0.5-dist.zip");

		fileSize = (int)filePath.length();

		System.out.println("The actual value is "+fileSize);

		byte [] expectedValue =
				given ()
				.get("http://dl.bintray.com/johanhaleby/generic/rest-assured-3.0.5-dist.zip")
				.asByteArray();

		System.out.println("The expected value is "+expectedValue.length);

		Assert.assertEquals(fileSize, expectedValue.length); 
	}
}
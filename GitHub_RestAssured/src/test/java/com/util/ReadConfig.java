package com.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
	
	public static String readProperty(String propertyName) {
		String value="";
		try {
			FileReader fr = new FileReader("./src/test/resources/config.properties");
			Properties p = new Properties();
			p.load(fr);
			value = p.getProperty(propertyName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return value;
	}

}

package fr.eni.utils;

import java.io.IOException;
import java.util.Properties;

public abstract class Settings {

	private static Properties properties;
	
	static {
		String configPath = "settings.properties";
		
		properties = new Properties();
		try {
			properties.load(Settings.class.getResourceAsStream(configPath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String getSetting(String property) {
		return properties.getProperty(property, null);
	}
	
}

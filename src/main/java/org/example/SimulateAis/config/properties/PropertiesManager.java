package org.example.SimulateAis.config.properties;

import org.apache.logging.log4j.LogManager;

import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;

public class PropertiesManager {
    private static final Properties PROPERTIES = new Properties();

    static {
        try (InputStream input = PropertiesManager.class.getClassLoader().getResourceAsStream("application.properties")) {
            if (input != null) {
                PROPERTIES.load(input);
            } else {
                LogManager.getLogger().error("Unable to find properties file");
            }
        } catch (IOException e) {
            LogManager.getLogger().error("Error loading properties file", e);
        }
    }

    private PropertiesManager() {
    }

    public static String getBrowser() {
        return PROPERTIES.getProperty("browser");
    }

    public static String getProperty(String propertyName) {
        String propertyValue = PROPERTIES.getProperty(propertyName);
        if (propertyValue != null) {
            LogManager.getLogger().info("Extracting the following value from the properties : {}", propertyValue);
            return propertyValue;
        } else {
            LogManager.getLogger().warn("{} is null or not found in the properties file", propertyName);
        }
        return null;
    }

    public static Duration checkElementIsDisplayedTimeout() {
        String propertyValue = PROPERTIES.getProperty("displayed.element.timeout");
        try {
            return Duration.ofSeconds(Integer.parseInt(propertyValue));
        } catch (NumberFormatException | NullPointerException e) {
            LogManager.getLogger().warn("Invalid or missing displayedElementTimeout value in properties. Using default value - 5 seconds.");
            return Duration.ofSeconds(5);
        }
    }
}

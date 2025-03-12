package org.example.SimulateAis.config.driverfactory;

import org.apache.logging.log4j.LogManager;
import org.example.SimulateAis.config.properties.PropertiesManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserProperty {
    private static WebDriver driver;
    private static final String BROWSER_TYPE = PropertiesManager.getBrowser().toLowerCase().trim();

    public static WebDriver getBrowserProperty() {
        switch (BROWSER_TYPE) {
            case "firefox" -> driver = new FirefoxDriver();
            case "edge" -> driver = new EdgeDriver();
            default -> driver = new ChromeDriver();
        }
        LogManager.getLogger().info("Current browser is: {}", BROWSER_TYPE);
        return driver;
    }
}

package org.example.SimulateAis.config.driverfactory;

import org.apache.logging.log4j.LogManager;
import org.example.SimulateAis.config.properties.PropertiesManager;
import org.example.SimulateAis.enums.Urls;
import org.openqa.selenium.WebDriver;

public class DriverManager {
    private static WebDriver driver;

    private DriverManager() {
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            driver = BrowserProperty.getBrowserProperty();
        }
        return driver;
    }

    public static void openAndMaximizeBrowser() {
        getDriver().manage().window().maximize();
        LogManager.getLogger().info("Browser is launched and maximized");
    }

    public static void openBasePage() {
        getDriver().get(PropertiesManager.getProperty(Urls.UI_BASE_URL.getUrl()));
    }

    public static void clearBrowserCache() {
        getDriver().manage().deleteAllCookies();
        LogManager.getLogger().info("Cash was cleared");
    }

    public static void tearDown() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}

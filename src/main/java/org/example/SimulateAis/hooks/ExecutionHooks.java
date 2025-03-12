package org.example.SimulateAis.hooks;

import io.cucumber.java.*;
import org.apache.logging.log4j.LogManager;
import org.example.SimulateAis.config.driverfactory.DriverManager;
import org.example.SimulateAis.config.logger.LoggerHelper;
import org.example.SimulateAis.config.screenshots.ScreenshotConfiguration;

public class ExecutionHooks {
    @Before("@API")
    public void setUpAPI(Scenario scenario) {
        LoggerHelper.setLogFileName(scenario);
        LogManager.getLogger().info("Starting API test: {}", scenario.getName());
    }

    @Before("@UI")
    public void setUpUI(Scenario scenario) {
        LoggerHelper.setLogFileName(scenario);
        LogManager.getLogger().info("Starting UI test: {}", scenario.getName());
        DriverManager.openAndMaximizeBrowser();
        DriverManager.openBasePage();
    }

    @After("@UI")
    public void clearCache() {
        DriverManager.clearBrowserCache();
    }

    @AfterStep("@UI")
    public void takeScreenshot(Scenario scenario) {
        ScreenshotConfiguration.captureScreenshot(scenario);
    }

    @AfterAll
    public static void closeTests() {
        DriverManager.tearDown();
        LogManager.getLogger().info("Test is finished. Browser closed");
    }
}

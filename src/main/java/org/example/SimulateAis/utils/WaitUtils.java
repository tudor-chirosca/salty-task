package org.example.SimulateAis.utils;

import org.apache.logging.log4j.LogManager;
import org.example.SimulateAis.config.driverfactory.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtils {

    private static WebDriverWait createWebDriverWait(Duration timeoutInSeconds) {
        return new WebDriverWait(DriverManager.getDriver(), timeoutInSeconds);
    }

    public static void waitForElementToBeClickable(WebElement element, Duration timeoutInSeconds) {
        WebDriverWait wait = createWebDriverWait(timeoutInSeconds);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        LogManager.getLogger().info("Button [{}] is clickable.", element.getText());
    }
}

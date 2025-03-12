package org.example.SimulateAis.utils;

import org.openqa.selenium.WebElement;

public class UIValidationUtils {

    public static boolean isElementClickable(WebElement element) {
        try {
            return element.isEnabled() && element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isElementDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}

package org.example.SimulateAis.action;

import org.apache.logging.log4j.LogManager;
import org.example.SimulateAis.config.properties.PropertiesManager;
import org.example.SimulateAis.utils.WaitUtils;
import org.openqa.selenium.WebElement;

public class BrowserAction {
    public void clickButton(WebElement button) {
        WaitUtils.waitForElementToBeClickable(button, PropertiesManager.checkElementIsDisplayedTimeout());
        String buttonName = button.getText();
        button.click();
        LogManager.getLogger().info("The [{}] button was clicked", buttonName);
    }
}

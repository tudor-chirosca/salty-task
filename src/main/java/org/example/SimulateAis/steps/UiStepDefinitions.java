package org.example.SimulateAis.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.example.SimulateAis.action.BrowserAction;
import org.example.SimulateAis.config.driverfactory.DriverManager;
import org.example.SimulateAis.config.properties.PropertiesManager;
import org.example.SimulateAis.enums.ElementText;
import org.example.SimulateAis.enums.Urls;
import org.example.SimulateAis.pageobjects.AccountInformationPage;
import org.example.SimulateAis.utils.UIValidationUtils;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class UiStepDefinitions {

    private final AccountInformationPage accountInformationPage;
    private final BrowserAction browserAction;

    public UiStepDefinitions() {
        accountInformationPage = new AccountInformationPage();
        browserAction = new BrowserAction();
    }

    @When("I open the base URL")
    public void getBaseUrl() {
        String url = PropertiesManager.getProperty(Urls.UI_BASE_URL.getUrl());
        LogManager.getLogger().info("Opening base URL: {}", url);
        DriverManager.getDriver().get(url);
    }

    @When("{string} element is clicked")
    public void clickOnElement(String elementName) {
        WebElement element = getElementByName(elementName);
        assertThat("Element " + elementName + " should be clickable", UIValidationUtils.isElementClickable(element));
        LogManager.getLogger().info("Clicked on element: {}", elementName);
        browserAction.clickButton(element);
    }

    @Then("the {string} element should be displayed")
    public void elementShouldBeDisplayed(String elementName) {
        WebElement element = getElementByName(elementName);
        assertThat("Element " + elementName + " should be displayed", element.isDisplayed());
        LogManager.getLogger().info("Element {} is displayed", elementName);
    }

    @Then("{string} element should have the expected text")
    public void checkElementText(String elementName) {
        WebElement element = getElementByName(elementName);
        String actualText = element.getText().trim();
        String expectedText = ElementText.valueOf(elementName.replace(" ", "_").toUpperCase()).getElementName();
        assertThat("Text for element " + elementName + " should be " + expectedText, actualText, is(expectedText));
        LogManager.getLogger().info("Element '{}' has the expected text. Expected: '{}', Found: '{}'", elementName, expectedText, actualText);
    }

    @Then("^the following elements with text (are|are not) displayed$")
    public void theFollowingElementsWithTextAreDisplayed(String option, List<Map<String, String>> listsOfElements) {
        LogManager.getLogger().info("Entering method: theFollowingElementsWithTextAreDisplayed() with option: {}", option);
        for (Map<String, String> elementValue : listsOfElements) {
            String elementName = elementValue.get("elementName");
            String expectedText = elementValue.get("value");
            LogManager.getLogger().info("Validating element: {} with expected text: {}", elementName, expectedText);
            isDisplayed(elementName, option.equals("are") ? "is" : "is not");
            if (option.equals("are")) {
                hasText(elementName, expectedText);
            }
        }
        LogManager.getLogger().info("Completed validation of elements with text display.");
    }

    private void isDisplayed(String elementName, String condition) {
        LogManager.getLogger().info("Entering method: isDisplayed() for element: {} with condition: {}", elementName, condition);
        WebElement element = getElementByName(elementName);
        if (condition.equals("is")) {
            assertThat("Element " + elementName + " should be displayed", element.isDisplayed());
            LogManager.getLogger().info("Element {} is displayed", elementName);
        } else {
            assertThat("Element " + elementName + " should not be displayed", !element.isDisplayed());
            LogManager.getLogger().info("Element {} is not displayed", elementName);
        }
    }

    private void hasText(String elementName, String expectedText) {
        LogManager.getLogger().info("Entering method: hasText() for element: {} with expected text: {}", elementName, expectedText);
        WebElement element = getElementByName(elementName);
        String actualText = element.getText().trim();
        assertThat("Element " + elementName + " should have the expected text", actualText, is(expectedText));
        LogManager.getLogger().info("Element '{}' has the expected text. Expected: '{}', Found: '{}'", elementName, expectedText, actualText);
    }

    private WebElement getElementByName(String elementName) {
        try {
            ElementText elementTextEnum = ElementText.valueOf(elementName.replace(" ", "_").toUpperCase());
            switch (elementTextEnum) {
                case X_REQUEST_ID -> {
                    return accountInformationPage.getXRequestIdAuthorisation();
                }
                case X_REQUEST_ID_TYPE -> {
                    return accountInformationPage.getXRequestIdTypeAuthorisation();
                }
                case DIGEST -> {
                    return accountInformationPage.getDigestAuthorisation();
                }
                case DATE -> {
                    return accountInformationPage.getDateAuthorisation();
                }
                case PSU_ID -> {
                    return accountInformationPage.getPsuIdAuthorisation();
                }
                case PSU_CORPORATE_ID -> {
                    return accountInformationPage.getPsuCorporateIdAuthorisation();
                }
                case PSU_DEVICE_ID -> {
                    return accountInformationPage.getPsuDeviceIdAuthorisation();
                }
                case PSU_USER_AGENT -> {
                    return accountInformationPage.getPsuUserAgentAuthorisation();
                }
                case PSU_GEO_LOCATION -> {
                    return accountInformationPage.getPsuGeoLocationAuthorisation();
                }
                case PSU_IP_ADDRESS -> {
                    return accountInformationPage.getPsuIpAddressAuthorisation();
                }
                case TPP_SIGNATURE_CERTIFICATE -> {
                    return accountInformationPage.getTppSignatureCertAuthorisation();
                }
                case SIGNATURE -> {
                    return accountInformationPage.getSignatureAuthorisation();
                }
                case CONTENT_TYPE -> {
                    return accountInformationPage.getContentTypeAuthorisation();
                }
                case PROVIDER_CODE -> {
                    return accountInformationPage.getProviderCodeAuthorisation();
                }
                case CONSENT_ID -> {
                    return accountInformationPage.getConsentIdAuthorisation();
                }
                case CONSENT_ID_TYPE -> {
                    return accountInformationPage.getConsentIdTypeAuthorisation();
                }
                case AUTHORISATION_ID -> {
                    return accountInformationPage.getAuthorisationId();
                }
                case SCA_STATUS -> {
                    return accountInformationPage.getScaStatusAuthorisation();
                }
                case ERROR_RESPONSE -> {
                    return accountInformationPage.getErrorResponseAuthorisation();
                }
                case ERROR_RESPONSE_TPP_MESSAGE -> {
                    return accountInformationPage.getErrorResponseTppMessageAuthorisation();
                }
                case ERROR_RESPONSE_CATEGORY -> {
                    return accountInformationPage.getErrorResponseCategoryAuthorisation();
                }
                case ERROR_RESPONSE_CODE -> {
                    return accountInformationPage.getErrorResponseCodeAuthorisation();
                }
                case ERROR_RESPONSE_TEXT -> {
                    return accountInformationPage.getErrorResponseTextAuthorisation();
                }
                default -> throw new IllegalArgumentException("Element not found: " + elementName);
            }
        } catch (IllegalArgumentException e) {
            LogManager.getLogger().error("Element not found: {}", elementName);
            throw e;
        }
    }
}

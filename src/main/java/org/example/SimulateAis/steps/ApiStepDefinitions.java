package org.example.SimulateAis.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.example.SimulateAis.config.properties.PropertiesManager;
import org.example.SimulateAis.enums.Urls;
import org.example.SimulateAis.models.ConsentRequest;
import org.example.SimulateAis.models.ConsentResponse;
import org.example.SimulateAis.enums.ApiEndpoints;
import org.example.SimulateAis.utils.ApiValidationUtils;
import org.springframework.http.HttpStatus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import java.util.List;
import java.util.Map;

public class ApiStepDefinitions {

    private Response response;
    private static final Logger LOG = LogManager.getLogger(ApiStepDefinitions.class);

    @Before
    public void setUp() {
        RestAssured.baseURI = PropertiesManager.getProperty(Urls.API_BASE_URL.getUrl());
        LOG.info("Base URI set to: {}", RestAssured.baseURI);
    }

    @When("I create a consent with consentId {string}")
    public void createConsent(String consentId, DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        Map<String, String> row = data.get(0);
        boolean recurringIndicator = Boolean.parseBoolean(row.get("recurringIndicator"));
        int frequencyPerDay = Integer.parseInt(row.get("frequencyPerDay"));
        String validUntil = row.get("validUntil");
        String access = "allAccounts";
        ConsentRequest consentRequest = new ConsentRequest();
        consentRequest.setRecurringIndicator(recurringIndicator);
        consentRequest.setFrequencyPerDay(frequencyPerDay);
        consentRequest.setValidUntil(validUntil);
        ConsentRequest.Access accessObj = new ConsentRequest.Access();
        accessObj.setAllPsd2(access);
        consentRequest.setAccess(accessObj);
        LOG.debug("Creating consent with ID: {}", consentId);
        LOG.debug("Request body: {}", consentRequest);
        response = RestAssured.given()
                .contentType("application/json")
                .body(consentRequest)
                .pathParam("consentId", consentId)
                .post(ApiEndpoints.CREATE_CONSENT.getPath());
        LOG.info("Response received with status code: {}", response.getStatusCode());
        LOG.debug("Response body: {}", response.getBody().asString());
    }

    @Then("I should receive a valid response for newly created consentId {string}")
    public void validateConsentResponse(String consentId, DataTable dataTable) {
        List<Map<String, String>> dataList = dataTable.asMaps(String.class, String.class);
        Map<String, String> data = dataList.get(0);
        boolean expectedRecurringIndicator = Boolean.parseBoolean(data.get("recurringIndicator"));
        int expectedFrequencyPerDay = Integer.parseInt(data.get("frequencyPerDay"));
        String expectedValidUntil = data.get("validUntil");
        ConsentResponse consentResponse = response.as(ConsentResponse.class);
        LOG.debug("Validating consent response for ID: {}", consentId);
        LOG.debug("Expected Recurring Indicator: {}", expectedRecurringIndicator);
        LOG.debug("Expected Frequency Per Day: {}", expectedFrequencyPerDay);
        LOG.debug("Expected Valid Until: {}", expectedValidUntil);
        assertThat("Consent ID should match", consentResponse.getConsentId(), equalTo(consentId));
        assertThat("Recurring indicator should match", consentResponse.isRecurringIndicator(), equalTo(expectedRecurringIndicator));
        assertThat("Frequency per day should match", consentResponse.getFrequencyPerDay(), equalTo(expectedFrequencyPerDay));
        assertThat("Valid until date should match", consentResponse.getValidUntil(), equalTo(expectedValidUntil));
        assertThat("Consent status should be invalid", consentResponse.getConsentStatus().getConsentStatus(), equalTo("invalid"));
        assertThat("Combined service indicator should be false", consentResponse.isCombinedServiceIndicator(), is(false));
    }

    @Given("a consent exists with consentId {string}")
    public void checkConsentExistsWithConsentId(String consentId) {
        response = RestAssured.given()
                .pathParam("consentId", consentId)
                .get(ApiEndpoints.GET_CONSENT.getPath());
        ApiValidationUtils.validateStatusCode(response, HttpStatus.OK.value());
        LOG.debug("Response body for consent check: {}", response.getBody().asString());
    }

    @When("I request the status for the consent {string}")
    public void sendAGetRequestToCheckConsentsStatus(String consentId) {
        LOG.info("Requesting status for consent ID: {}", consentId);
        response = RestAssured.given()
                .pathParam("consentId", consentId)
                .get(ApiEndpoints.GET_CONSENT_STATUS.getPath());
        ApiValidationUtils.validateStatusCode(response, HttpStatus.OK.value());
        LOG.debug("Response body for consent status: {}", response.getBody().asString());
    }

    @Then("the response status should be {int}")
    public void getResponseStatus(int statusCode) {
        LOG.info("Validating response status code: {}", statusCode);
        ApiValidationUtils.validateStatusCode(response, statusCode);
    }

    @Then("the response body should contain {string}")
    public void checkResponseBodyShouldContain(String key) {
        LOG.debug("Validating if the response body contains key: {}", key);
        ApiValidationUtils.validateResponseBodyContains(response, key);
    }

    @Then("the response body contains")
    public void checkResponseBodyContains(DataTable dataTable) {
        LOG.info("Validating response body contains the following key-value pairs:");
        Map<String, String> data = dataTable.asMap(String.class, String.class);
        Map<String, Object> responseBody = response.as(Map.class);
        for (Map.Entry<String, String> entry : data.entrySet()) {
            String key = entry.getKey();
            String expectedValue = entry.getValue();
            Object actualValue = responseBody.get(key);
            assert actualValue != null && actualValue.toString().equals(expectedValue) :
                    "Expected value for key '" + key + "' to be '" + expectedValue + "' but got: '" + actualValue + "'";
            LOG.debug("Key: {}, Expected Value: {}, Actual Value: {}", key, expectedValue, actualValue);
        }
    }

    @When("I change the status for consentId {string} to {string}")
    public void changeConsentStatus(String consentId, String status) {
        String debugBaseUrl = PropertiesManager.getProperty(Urls.DEBUG_BASE_URL.getUrl());
        String url = String.format("%s/consent/%s/%s", debugBaseUrl, consentId, status);
        LOG.info("Changing status for consent ID: {} to {}", consentId, status);
        LOG.debug("POST request URL: {}", url);
        response = RestAssured.given().post(url);
        ApiValidationUtils.validateStatusCode(response, HttpStatus.OK.value());
        LOG.info("Response received with status code: {}", response.getStatusCode());
        LOG.debug("Response body: {}", response.getBody().asString());
    }

    @When("I create a consent with consentId {string} and an empty body")
    public void createConsentWithEmptyBody(String consentId) {
        LOG.info("Creating consent with consentId: {} and no request body", consentId);
        response = RestAssured.given()
                .contentType("application/json")
                .pathParam("consentId", consentId)
                .post(ApiEndpoints.CREATE_CONSENT.getPath());
        LOG.info("Request sent to create consent with empty body for consentId: {}", consentId);
        LOG.debug("Response status code: {}", response.getStatusCode());
        LOG.debug("Response body: {}", response.getBody().asString());
    }

    @When("I try to delete the consent with the consentId {string}")
    public void deleteConsent(String consentId) {
        LOG.info("Attempting to delete consent with consentId: {}", consentId);
        response = RestAssured.given()
                .pathParam("consentId", consentId)
                .delete(ApiEndpoints.DELETE_CONSENT.getPath());
        LOG.info("Delete request sent for consentId: {}", consentId);
        LOG.debug("Response status code: {}", response.getStatusCode());
    }
}

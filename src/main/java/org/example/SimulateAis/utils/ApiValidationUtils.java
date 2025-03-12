package org.example.SimulateAis.utils;

import io.restassured.response.Response;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class ApiValidationUtils {

    public static void validateStatusCode(Response response, int expectedStatusCode) {
        assertThat(response.statusCode(), equalTo(expectedStatusCode));
    }

    public static void validateResponseBodyContains(Response response, String expectedKey) {
        assertThat(response.getBody().asString(), containsString(expectedKey));
    }
}

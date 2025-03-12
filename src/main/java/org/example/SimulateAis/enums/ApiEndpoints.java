package org.example.SimulateAis.enums;

import org.apache.logging.log4j.LogManager;

public enum ApiEndpoints {

    CREATE_CONSENT("/consents/{consentId}"),
    GET_CONSENT("/consents/{consentId}"),
    GET_CONSENT_STATUS("/consents/{consentId}/status"),
    CHANGE_CONSENT_STATUS("/consent/{consentId}/{status}"),
    DELETE_CONSENT("/consents/{consentId}");

    private final String path;

    ApiEndpoints(String path) {
        this.path = path;
    }

    public String getPath() {
        LogManager.getLogger().info("Retrieving the endpoint: {}", path);
        return path;
    }
}

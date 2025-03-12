package org.example.SimulateAis.enums;

public enum ElementText {

    X_REQUEST_ID("X-Request-ID"),
    X_REQUEST_ID_TYPE("X-Request-ID-Type"), // Keep this one as it was specified
    DIGEST("Digest"),
    DATE("Date"),
    PSU_ID("Psu-ID"),
    PSU_CORPORATE_ID("Psu-Corporate-ID"),
    PSU_DEVICE_ID("PSU-Device-ID"),
    PSU_USER_AGENT("PSU-User-Agent"),
    PSU_GEO_LOCATION("PSU-Geo-Location"),
    PSU_IP_ADDRESS("Psu-IP-Address"),
    TPP_SIGNATURE_CERTIFICATE("TPP-Signature-Certificate"),
    SIGNATURE("Signature"),
    CONTENT_TYPE("Content-Type"),
    PROVIDER_CODE("provider_code"),
    CONSENT_ID("Consent-ID"),
    AUTHORISATION_ID("Authorisation-ID"),
    SCA_STATUS("SCA-Status"),
    ERROR_RESPONSE("Error-Response"),
    ERROR_RESPONSE_TPP_MESSAGE("Error-Response-TPP-Message"),
    ERROR_RESPONSE_CATEGORY("Error-Response-Category"),
    ERROR_RESPONSE_CODE("Error-Response-Code"),
    ERROR_RESPONSE_TEXT("Error-Response-Text"),
    CONSENT_ID_TYPE("Consent-ID-Type");

    private final String elementName;

    ElementText(String elementName) {
        this.elementName = elementName;
    }

    public String getElementName() {
        return elementName;
    }
}

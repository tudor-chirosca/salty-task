@UI
Feature: API Documentation Validation for Account Information page

  Scenario: Validate Authorization endpoint
    Given I open the base URL
    Then the following elements with text are displayed
      | elementName               | value                     |
      | X_REQUEST_ID              | X-Request-ID              |
      | DIGEST                    | Digest                    |
      | DATE                      | Date                      |
      | PSU_ID                    | Psu-ID                    |
      | PSU_CORPORATE_ID          | Psu-Corporate-ID          |
      | PSU_DEVICE_ID             | PSU-Device-ID             |
      | PSU_USER_AGENT            | PSU-User-Agent            |
      | PSU_GEO_LOCATION          | PSU-Geo-Location          |
      | PSU_IP_ADDRESS            | Psu-IP-Address            |
      | TPP_SIGNATURE_CERTIFICATE | TPP-Signature-Certificate |
      | SIGNATURE                 | Signature                 |
      | CONTENT_TYPE              | Content-Type              |
    When "ERROR_RESPONSE" element is clicked
    Then the following elements with text are displayed
      | elementName                | value       |
      | ERROR_RESPONSE_TPP_MESSAGE | tppMessages |
      | ERROR_RESPONSE_CATEGORY    | category    |
      | ERROR_RESPONSE_CODE        | code        |
      | ERROR_RESPONSE_TEXT        | text        |

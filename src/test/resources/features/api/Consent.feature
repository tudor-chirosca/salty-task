@API
Feature: API Testing for SimulateAis

  Scenario: Create a new consent with valid body and validate response
    When I create a consent with consentId "0000009"
      | recurringIndicator | frequencyPerDay | validUntil |
      | true               | 2               | 2025-12-27 |
    Then the response status should be 201
    And I should receive a valid response for newly created consentId "0000009"
      | recurringIndicator | frequencyPerDay | validUntil |
      | true               | 2               | 2025-12-27 |

  Scenario: Get consent status for an existing consent
    Given a consent exists with consentId "0000009"
    When I request the status for the consent "0000009"
    Then the response status should be 200
    And the response body contains
      | consentStatus |
      | invalid       |

  Scenario: Change the status for an existing consent
    Given a consent exists with consentId "0000009"
    When I change the status for consentId "0000009" to "valid"
    And I request the status for the consent "0000009"
    Then the response status should be 200
    And the response body contains
      | consentStatus |
      | valid         |

  Scenario: Check if missing consent data will result in an error
    When I create a consent with consentId "0000009" and an empty body
    Then the response status should be 500
    And the response body should contain "An unexpected error occurred: Required request body is missing"

  Scenario: Check if a consent can be deleted
    Given a consent exists with consentId "0000009"
    When I try to delete the consent with the consentId "0000009"
    Then the response status should be 204

  Scenario: Delete an non-existent consentId "0000008"
    When I try to delete the consent with the consentId "0000009"
    Then the response status should be 404

  Scenario: Check the status for a consent that does not exist
    Then I request the status for the consent "0000009"
    Then the response status should be 404

Scenario: Change an existing consent for an incorrect consent status
    Given a consent exists with consentId "0000009"
    When I change the status for consentId "0000009" to "valid2"
    Then the response status should be 500
    And the response body should contain "n unexpected error occurred: No enum constant"

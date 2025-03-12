# Automated Testing Framework for SimulateAis

This repository contains an automated testing framework designed to test both **UI** and **API** endpoints of the **SimulateAis** project. The framework utilizes **Cucumber** for behavior-driven testing, **Selenium WebDriver** for UI testing, **RestAssured** for API testing, and **Log4j2** for logging. Additionally, it uses **Cucumber Reporting** to generate detailed test reports.

## Overview

The **SimulateAis** project was updated to automate testing for both its API and UI endpoints. Below is an overview of the key components and improvements made:

### Automated API Testing

1. **ApiStepDefinitions Class**:
   - This class contains the methods that execute the steps written in the feature files for API tests.
   - These steps define actions like making HTTP requests, validating the responses, and verifying the content of the response body.

2. **ApiValidationUtils Class**:
   - A utility class to validate response codes and contents of the API responses.
   - Ensures that the API responses match expected results and format.

3. **ApiEndpoints Enum**:
   - Stores the names and URLs of the API endpoints used in tests.
   - Centralizes the management of API endpoints, making it easier to update them across the project.

4. **ConsentRequest and ConsentResponse Classes**:
   - **ConsentRequest**: Represents the data sent when creating a new consent.
   - **ConsentResponse**: Represents the response received after the consent creation.

5. **ConfigUtils Class**:
   - Simplifies working with configuration files (e.g., `application.properties`).
   - Helps read configuration values like base URLs, authorization tokens, and other necessary application settings.

### Automated UI Testing

1. **ExecutionHooks Class**:
   - Contains the setup and teardown methods for the UI tests.
   - Includes handling browser initialization, cache clearing, and taking screenshots during test execution.

2. **BrowserProperty Class**:
   - Manages the browser selection and initializes the WebDriver (Chrome, Firefox, or Edge).
   - Retrieves the browser configuration from the project properties.

3. **UIValidationUtils Class**:
   - Provides utility methods to validate whether a UI element is clickable or displayed.
   - Useful for performing checks on elements before interacting with them.

4. **UiStepDefinitions Class**:
   - Contains the methods that execute the steps written in the feature files for UI tests.
   - Defines actions like opening URLs, clicking elements, and verifying element visibility and text.

5. **ScreenshotConfiguration Class**:
   - Captures and saves screenshots during the UI test execution.
   - Ensures screenshots are attached to reports for better debugging.

## Key Libraries and Tools Used

- **Cucumber**: For behavior-driven development (BDD) testing.
- **Selenium WebDriver**: For automating UI interactions and validation in web browsers.
- **RestAssured**: For making HTTP requests and validating API responses.
- **Hamcrest**: For readable and expressive assertions in tests.
- **Log4j2**: For logging detailed information during test execution.
- **Cucumber Reporting**: For generating post-test reports that summarize test execution.

## Logging

The framework uses **Log4j2** to create detailed logs during the execution of tests. This helps in tracing the steps and understanding failures or issues in the tests. The logs are organized by scenario and provide helpful insights into what went wrong during the test.

## Test Reports

After the tests are executed, **Cucumber Reporting** is used to generate a comprehensive report. This report includes:

- The status of each test (pass/fail).
- Detailed logs and data for troubleshooting failures.
- Highlighting of failed tests and providing insights for debugging.

## Setup and Configuration

### Clone the Repository

Clone the repository to your local machine using the following command:

```bash
git clone https://github.com/your-repo-url.git

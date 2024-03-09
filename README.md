# README.md

This repository contains Cucumber test suites for validating different aspects of an API.

### SDET Assessment  
* Given the API: https://open.er-api.com/v6/latest/USD
* Returns the USD rates against multiple currency.

### Task

* Create a test framework using Java/JVM language framework.
  * BDD approach would be an added advantage.
* Write necessary tests to cover the acceptance criteria below.
* Make sure code is modular and easily understood.
* Structure the code properly so that we making changes are easier.
* Upload the solution in bitbucket/GitHub and share the link of the repo
* Include a README.md file.

### Acceptance criteria

* API call is successful and returns valid price.
* Check the status code and status returned by the API response.
  * API could return multiple statuses like SUCCESS, FAILURE etc. Make sure this is
  catered for.  
* Fetch the USD price against the AED and make sure the prices are in range on 3.6 – 3.7
* Make sure API response time is not less then 3 seconds then current time in second.
  * Timestamp is returned in the API response.
* Verify that 162 currency pairs are returned by the API.
* Make sure API response matches the Json schema
  * Generate a schema from the API response.

### Dependencies

* Cucumber: A tool for running automated tests written in plain language.
* RestAssured: A Java library for testing RESTful APIs.

### How to Run
* Ensure you have Java installed on your system.
* Clone this repository to your local machine.
* Open the project in your preferred IDE.
* Run the test runners located in the respective packages.

### Test Scenarios

#### Scenario 1: Check Status Code And Body
* Given I am on the website the URL "https://open.er-api.com/v6/latest/USD"
* When Get content
* Then Check that response has not empty body
* And Returns status code 200

#### Scenario 2: Check that currency price is valid
* Given I am on the website the URL "https://open.er-api.com/v6/latest/USD"
* When Get content
* Then Check that currency price is valid

#### Scenario 3: API Response Time
* Given I am on the website the URL "https://open.er-api.com/v6/latest/USD"
* When Record time for request and response
* Then Check that API response time is not less than 3 seconds

#### Scenario 4: Currency Value Is In The Range
* Given I am on the website the URL "https://open.er-api.com/v6/latest/USD"
* When Get content from URL
* Then Check that the AED is in the range 3.6-3.7

#### Scenario 5: Check How Many Pairs The API Returns
* Given I am on the website the URL "https://open.er-api.com/v6/latest/USD"
* When Get response
* Then Check that API returns 162 pairs

### Test Runners
* StatusCode_StepsDefinitions.CurrencyStatusCodeSteps: Executes scenarios related to Check Status Code And Body.
* ValidCurrancy_StepsDefinitions.ValidCurrancy: Executes scenarios related to Check that currency price is valid.
* CurrencyResponseTimeSteps_StepsDefinitions.CurrencyResponseTimeSteps: Executes scenarios related to API response time.
* CurrencyValiueIsInTheRange_StepsDefinitions.CurrencyValueIsInTheRangeSteps: Executes scenarios related to checking currency values.
* CurrencyPairsAreReturned_StepsDefinitions.CurrencyPairsAreReturnedSteps: Executes scenarios related to Check How Many Pairs The API Returns

### Notes
* Make sure the provided URL is accessible and return the expected responses.
* Additional scenarios can be added as needed by creating new feature files and corresponding step definition files.
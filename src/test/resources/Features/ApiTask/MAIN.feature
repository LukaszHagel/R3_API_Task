Feature: API Tests

  Background:
    Given I am on the website the URL "https://open.er-api.com/v6/latest/USD"
    When Get content

  Scenario: Check valid price

    Then Check that currency price is valid

  Scenario: Check Status Code And Body
    Then Check that response has not empty body
    And Returns status code 200

  Scenario: Check how many pairs are returned by the API
    Then Check that 162 pairs are response by the API


  Scenario: Check Status Code
    Then Check that AED is in the range 3.6-3.7

  Scenario: Check API Response Time
    When Record time for request and response
    Then Check that API response time is not less then 3 seconds
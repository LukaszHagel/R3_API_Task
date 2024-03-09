Feature: API Response Time

  Scenario: Check API Response Time
    Given I am on the website the URL "https://open.er-api.com/v6/latest/USD"
    When Get the request and response time
    Then Check that API response time is not less than 3 seconds
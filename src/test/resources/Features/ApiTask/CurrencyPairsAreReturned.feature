Feature: Currency Pairs

  Scenario: Check How Many Pairs The API Returns
    Given I am on the website the URL "https://open.er-api.com/v6/latest/USD"
    When Get response
    Then Check that API returns 162 pairs
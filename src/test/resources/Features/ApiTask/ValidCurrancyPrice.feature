Feature: Currency Valid Value

  Scenario: Check that currency price is valid
    Given I am on the website the URL "https://open.er-api.com/v6/latest/USD"
    When Get content
    Then Check that currency price is valid
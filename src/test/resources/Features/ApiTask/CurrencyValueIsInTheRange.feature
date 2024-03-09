Feature: Price is in the range

  Scenario: Currency Value Is In The Range
    Given I am on the website the URL "https://open.er-api.com/v6/latest/USD"
    When Get content from URl
    Then Check that the AED is in the range 3.6-3.7
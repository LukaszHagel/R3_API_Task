Feature: Currency Status Code and Empty Body

  Scenario: Check Status Code And Body
    Given I am on the website the URL "https://open.er-api.com/v6/latest/USD"
    When Get content
    Then Check that response does not have empty body
    And Returns status code 200
@ui
Feature: Search basic verification
  As a
  I want to
  So that

  Scenario: Search for an leather bag
    Given "John The Shopper" is on the main page
    And "John The Shopper" accepts privacy policy with default settings
    When "John The Shopper" search for "leather bag"
    Then search result page is visible
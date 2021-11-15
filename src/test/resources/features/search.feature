@ui
Feature: Search for an item
  As a user
  I want to search for an particular item
  So that i can buy what i want

  Scenario: Search for a leather bag
    Given "John" on the shop landing page
    When he accepts privacy policy with default settings
    And he search for "leather bag"
    Then search results contains item with title "leather bag"

  Scenario: Search for a handmade
    Given "John" on the shop landing page
    When he accepts privacy policy with default settings
    And he search for "handmade"
    Then search results contains item with title "handmade"
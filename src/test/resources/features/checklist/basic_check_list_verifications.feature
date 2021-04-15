@list
Feature: Basic check list functionalities verifications
  As a user
  I want to
  So that

  Background:
    Given a check list named "Smoke test v2.0"
    When I add a "Login verification" check list item

  Scenario: Add a check item into a list
    Then check list size is equal to 1

  Scenario: Remove item from list
    When I delete "Login verification" check list item
    Then check list size is equal to 0





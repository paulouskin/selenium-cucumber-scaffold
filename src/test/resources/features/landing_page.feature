# background
Feature: Landing page basic verifications
  As an admin Ed
  In order to have all things set up
  I need to verify basic elements on the main page

  Background: Preconditions
    Given "John" on the shop landing page
    When he accepts privacy policy with default settings

  Scenario: Populars and signin button verification
    Then populars is visible
    And Sign in button is visible

  Scenario: Shop selections area verification
    Then shop selections is visible
    And subscribe area is visible
@ui
Feature: Privacy policy
  As a new shopper John
  In order to proceed with shopping
  I need to accept privacy policy default settings

  Scenario: Accept default privacy settings
    Given "John" on the shop landing page
    When he accepts privacy policy with default settings
    Then "John" can proceed with shopping
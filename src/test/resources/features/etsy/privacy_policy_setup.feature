# this is a comment about session end
@ui
Feature: Privacy policy setup
  As a legal department
  I want to introduce privacy policy settings as early as possible
  So that further legal related complications can be avoided

  Background: Going to the main page
    Given "John" is on the main page

  Scenario: User can accept privacy policy window
    When "John" accepts privacy policy with default settings
    Then "John" can proceed with shopping

  Scenario: Privacy policy initial information
    Given the privacy policy modal text:
    """
    For the best experience, we use cookies and similar tools to help Etsy function, for performance, analytics, personalization and advertising. Learn more in our Privacy Policy and Cookie Policy. Update your choices any time via Privacy Settings.
    """
    Then the privacy modal contains expected text

  Scenario: User can update privacy policy settings
    Given privacy policy modal is visible
    When "John" go to full privacy policy settings
    Then update policy settings modal is visible

  Scenario: User can enable/disable site customization to improve user experience

  Scenario: User can enable/disable personalized advertising

  Scenario Outline: User have access to documents online
    Given "<name>" is on the main page
    Then the link to "<link>" is available

    Examples:
      | name | link           |
      | John | Privacy Policy |
      | John | Cookie Policy  |

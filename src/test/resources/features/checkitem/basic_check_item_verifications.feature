Feature: Verify basic check item requirements
  As a user
  I want to check basic functionalities
  So that I can be sure that check have all necessary information

  Scenario: Check item should have a title
    Given I have an access to application
    When I create a check with a title "Test check 1"
    Then check has a title "Test check 1"

  Scenario: Check item title can not be replaced by empty string
    Given a check item with "Test check 2" title
    When I replace check item title to ""
    Then check has a title "Test check 2"

  Scenario: Check item should have number of executions
    Given a check item with "Test check 3" title
    When I specify that check need to be executed 3 times
    Then check number of executions is equal to 3

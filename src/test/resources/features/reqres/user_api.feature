@api
Feature: User API basic checks
  As a test automation engineer
  I want to test my backend developers result of work
  So that my manual test colleagues can have less headache

  Scenario: List all users detailed information
    Given user service is up and running
    When we fetching users from page "2"
    Then result list contains next emails:
      | michael.lawson@reqres.in   |
      | lindsay.ferguson@reqres.in |
      | tobias.funke@reqres.in     |
      | byron.fields@reqres.in     |
      | george.edwards@reqres.in   |
      | rachel.howell@reqres.in    |

  Scenario: List specific user information
    Given user service is up and running
    When we fetch user information for user id "11"
    Then user email is "george.edwards@reqres.in"

  Scenario: Add new user
    Given user service is up and running
    When we create new user with following parameters:
      | name     | job                      |
      | John Doe | Test Automation Engineer |
    Then user id have been returned in the response

  Scenario: Update user information
    Given user service is up and running
    When we update the user with id "10" with following data:
      | name | job       |
      | Viki | Test Lead |
    Then user job is "Test Lead"

  Scenario: Delete user

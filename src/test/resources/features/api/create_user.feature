@api
Feature: User creation verification

  Scenario: Create user - happy path
    Given the application is up and running
    When I create user with next parameters:
      | name     | job                      |
      | John Doe | Test automation engineer |
    Then response returns user id
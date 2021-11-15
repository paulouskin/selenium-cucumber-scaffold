@api
Feature: User API verifications

  Scenario Outline: Get user with id and verify email
    Given user service is up and running
    When I fetch the information about user with id <id>
    Then user has a email "<email>"

    Examples:
      | id | email                    |
      | 7  | michael.lawson@reqres.in |
      | 6  | tracey.ramos@reqres.in   |
      | 5  | charles.morris@reqres.in |
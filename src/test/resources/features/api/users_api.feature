@api
Feature: User API verifications

  Scenario: Get all users for subscription audition
    Given user service is up and running
    When I fetch all users from page 2
    Then user list contains 6 users

  Scenario: Verify user by id fetching (id=7)
    Given user service is up and running
    When I fetch the information about user with id 7
    Then user has a email "michael.lawson@reqres.in"

  Scenario: Get user with id = 6
    Given user service is up and running
    When I fetch the information about user with id 6
    Then user has a email "tracey.ramos@reqres.in"

  Scenario: Get user with id = 5
    Given user service is up and running
    When I fetch the information about user with id 5
    Then user has a email "charles.morris@reqres.in"
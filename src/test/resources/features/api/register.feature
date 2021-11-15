@api
Feature: Register user

  Scenario: User have been registered successfully
    Given the application is up and running
    When user registers with email "eve.holt@reqres.in" and password "machine gun"
    Then registration "have been" completed

  Scenario: User have not been registered without password
    Given the application is up and running
    When user registers with email "eve.holt@reqres.in" and password ""
    Then registration "have not been" completed
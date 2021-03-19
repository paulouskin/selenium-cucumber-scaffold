Feature: Todo item base properties verification

  Scenario: Create todo item and assign title
    Given a new todo item
    When I set todo item title to "Todo 1"
    Then todo item title is "Todo 1"

  Scenario: New todo item have an empty title
    Given a new todo item
    Then an empty string have been returned

  Scenario: New todo item status is "PENDING"
    Given a new todo item
    Then todo item status is "PENDING"

  Scenario: New todo item creation date is equal to today's date
    Given a new todo item
    Then todo item date is today's date

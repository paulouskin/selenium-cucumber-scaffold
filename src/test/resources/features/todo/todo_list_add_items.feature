@list
Feature: Todo list add items feature

  Background:Create an empty todo list
    Given an empty todo list "What I need to do today"
    And following todo items:
      | title                     | priority |
      | Learn Cucumber Tags       | MEDIUM   |
      | Practice Java Collections | HIGH     |

  Scenario: Empty list should have 0 length
    Then length of "What I need to do today" list is 2

  Scenario: List with items should have non-zero length
    When I add a todo called "Learn Java streams API" into list
    And I add a todo called "Eat healthy food at dinner" into list
    Then length of "What I need to do today" list is 4

  Scenario: Can not add todo item with empty title
    When I add a todo called "" into list
    Then length of "What I need to do today" list is 2
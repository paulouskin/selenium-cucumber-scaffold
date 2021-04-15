@ddt
Feature: Check item execution status DDT

  Background: Check item creation
    Given a check items with following properties:
      | title                       | numOfExecutions |
      | Verify log in functionality | 1               |

  Scenario Outline: Can not omit IN_PROGRESS status DDT
    When mark check item as "<requiredStatus>"
    Then check execution status is "<expectedStatus>"
    Examples:
      | requiredStatus | expectedStatus |
      | PASSED         | UNKNOWN        |
      | FAILED         | UNKNOWN        |
      | PENDING        | UNKNOWN        |

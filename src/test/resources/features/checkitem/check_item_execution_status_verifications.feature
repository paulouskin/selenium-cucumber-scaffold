Feature: Check item execution status verifications

  As a user
  I want to able to change execution status
  So that current execution status can be visible
  # Check execution statuses
  #PASSED
  #FAILED
  #PENDING
  #IN PROGRESS
  #UNKNOWN (default)

  Background: Create UAT check item
    Given a check items with following properties:
      | title                        | numOfExecutions |
      | Verify log in functionality  | 1               |

  Scenario: Check execution status can be changed
    When I start working on the item check
    Then check execution status is "IN_PROGRESS"

  Scenario: New check item have UNKNOWN status
    Then check execution status is "UNKNOWN"

  Scenario: Check execution status flow can not omit IN_PROGRESS
    When mark check item as "PASSED"
    Then check execution status is "UNKNOWN"

  Scenario: Execution status can not be changed for archived checks

  Scenario: Execution status can be changed for active check
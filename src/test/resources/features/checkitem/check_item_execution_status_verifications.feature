Feature: Check item execution status verifications

  As a user
  I want to able to change execution status
  So that current execution status can be visible
  # Check execution statuses
  #PASSED
  #FAILED
  #PENDING
  #IN PROGRESS
  #UNKNOWN

  Background: Create UAT check item
    Given a check items with following properties:
      | title                        | numOfExecutions |
      | Verify log in functionality  | 2               |

  Scenario: Check execution status can be changed

  Scenario: New check have UNKNOWN status

  Scenario: Execution status can not be changed for archived checks

  Scenario: Execution status can be changed for active check
Feature: Check item state verifications
  As a user
  I want to change check item lifecycle state
  So that I can reflect relevant check state

  #ACTIVE (default)
  #ARCHIVED

  Background: Create check item
    Given a check items with following properties:
      | title                                | numOfExecutions |
      | Verify change password functionality | 1               |

    #HW: make scenario pass
  Scenario: Check can be marked as ARCHIVED
    When I archive check item
    Then check item have "ARCHIVED" state

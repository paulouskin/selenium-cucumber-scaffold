Feature: File just to test if all configurations was OK
  As a
  I want to
  So that

  Scenario: Few steps to generate report
    Given I create empty Maven Cucumber project
    When I run maven command clean verify
    Then I see some reports generated in target folder
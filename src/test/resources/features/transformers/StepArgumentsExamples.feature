Feature: Demo of step arguments expressions

  Scenario: {word} example
    Given "Cucumber" as a word step expression
    Then  above word can not be split

  Scenario: {bigdecimal} example
    Given 3.1415 as a bigdecimal step expression
    Then the variable value to which it assigned not equal to initial var value

  Scenario: {biginteger} example
    Given 40000000 is a big integer

  Scenario: {float} example

  Scenario: {} anonymous example
    Given BLUE as anonymous argument will be converted into enum

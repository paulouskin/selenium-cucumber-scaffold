Feature: Feature to demo argument transformers functionality

  Scenario: Parameter type demo
    Given today is 2022-10-23
    When we add 1 month to today's date
    Then result date will be in future

  Scenario: Data table type demo
    Given the following books
      | author       | title                                   | publishYear |
      | Bruce Eckel  | Thinking in Java                        | 2017        |
      | Joshua Bloch | Effective Java. Third Edition           | 2018        |
      | Kathy Sierra | Head First Java: A Brain Friendly Guide | 2015        |
    Then I want to output all above mentioned books on the console
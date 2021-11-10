Feature: Testing operations on bank account

  Scenario: Deposit amount of money in account
    Given account have a balance of 0
    When a deposit of 100 is made in an empty account
    Then the balance must be 100

  Scenario: Withdraw amount of money in account
    Given account have a balance of 10
    When a withdraw of 5 is made in account
    Then the balance must be 5

  Scenario: Print statement lines
    Given account have a balance of 0
    When a deposit of 100 is made in an empty account
    When a withdraw of 50 is made in account
    When statement of deposit is printed
    Then console display operations
      | OPERATION  | DATE             | AMOUNT | BALANCE |
      | WITHDRAW   | 2021-11-10 00:00 | 50     | 50      |
      | DEPOSIT    | 2021-11-10 00:00 | 100    | 100     |

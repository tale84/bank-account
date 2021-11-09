package com.kata.bank;

import java.time.Clock;
import java.time.LocalDateTime;

public class Account {
    private Balance balance;
    private Statement statement = new Statement();
    private Clock clock;

    public Account(Balance balance) {
        this.balance = balance;
        this.clock=Clock.systemDefaultZone();
    }

    public Account(Balance balance, Clock clock) {
        this.balance = balance;
        this.clock=clock;
    }

    public Balance getBalance() {
        return balance;
    }

    public Statement getStatement() {
        return statement;
    }

    public void deposit(Amount amount) {
        this.balance = this.balance.increase(amount);
        statement.addOperation(new Operation(OperationType.DEPOSIT, amount, LocalDateTime.now(clock)), this.balance);
    }

    public void withdraw(Amount amount) {
        this.balance = this.balance.decrease(amount);
        statement.addOperation(new Operation(OperationType.WITHDRAW, amount, LocalDateTime.now(clock)), this.balance);
    }

    public void printHistoryOfOperations() {
        StatementPrinter.printHistoryOfOperations(this.statement);
    }
}

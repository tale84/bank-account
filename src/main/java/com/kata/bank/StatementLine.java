package com.kata.bank;

import java.util.Objects;

public class StatementLine {
    private Operation operation;
    private Balance balance;

    public StatementLine(Operation operation, Balance balance) {
        this.operation = operation;
        this.balance = balance;
    }

    public Operation getOperation() {
        return operation;
    }

    public Balance getBalance() {
        return balance;
    }

    @Override
    public boolean equals(Object o) {

        if (o == this) return true;
        if (!(o instanceof StatementLine)) {
            return false;
        }
        StatementLine statementLine = (StatementLine) o;
        return Objects.equals(balance, statementLine.balance) &&
                Objects.equals(operation, statementLine.operation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operation, balance);
    }
}

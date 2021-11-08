package com.kata.bank;

public class Account {
    Balance balance;

    public Account(Balance balance) {
        this.balance = balance;
    }

    public Balance getBalance() {
        return balance;
    }
}

package com.kata.bank;

public class Account {
    Balance balance;

    public Account(Balance balance) {
        this.balance = balance;
    }

    public Balance getBalance() {
        return balance;
    }

    public void deposit(Amount amount) {
        this.balance = this.balance.increase(amount);
    }

    public void withdraw(Amount amount) {
        this.balance = this.balance.decrease(amount);
    }
}

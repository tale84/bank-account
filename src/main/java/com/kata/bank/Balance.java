package com.kata.bank;

public class Balance {

    Amount amount;

    public Balance(Amount amount) {
        this.amount = amount;
    }

    public Amount getAmount() {
        return amount;
    }

    public Balance increase(Amount amount) {
        return new Balance(this.amount.add(amount.value));
    }
}

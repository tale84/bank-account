package com.kata.bank;

import java.util.Objects;

public class Balance {

    Amount amount;

    private static final String BALANCE_NOT_SUFFICIENT_INFO = "Client does not have a sufficient balance";

    public Balance(Amount amount) {
        this.amount = amount;
    }

    public Amount getAmount() {
        return amount;
    }

    public Balance increase(Amount amount) {
        return new Balance(this.amount.add(amount.value));
    }

    public Balance decrease(Amount amount) {
        if (isBalanceEnoughForWithdraw(amount)) {
            return new Balance(this.amount.subtract(amount.value));
        } else {
            throw new RuntimeException(BALANCE_NOT_SUFFICIENT_INFO);
        }
    }

    private boolean isBalanceEnoughForWithdraw(Amount amount) {
        return this.amount.getValue().compareTo(amount.getValue()) >= 0;
    }

    @Override
    public boolean equals(Object o) {

        if (o == this) return true;
        if (!(o instanceof Balance)) {
            return false;
        }
        Balance balance = (Balance) o;
        return Objects.equals(amount, balance.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }
}

package com.kata.bank;

import java.math.BigDecimal;

public class Balance {

    BigDecimal amount;

    public Balance(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getAmount() {
        return amount;
    }
}

package com.kata.bank;

import java.math.BigDecimal;

public class Amount {
    BigDecimal value;

    public Amount(BigDecimal value) {
        this.value = value;
    }

    public BigDecimal getValue() {
        return value;
    }

    public Amount add(BigDecimal value) {
        return new Amount(this.value.add(value));
    }
}

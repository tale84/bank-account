package com.kata.bank;

import java.math.BigDecimal;

public class Amount {
    BigDecimal value;

    private static final String AMOUNT_POSITIVE_WARN = "The amount must be positive";

    public Amount(BigDecimal value) {
        this.value = value;
    }

    public BigDecimal getValue() {
        return value;
    }

    public Amount add(BigDecimal value) {
        if (value.signum()==-1) {
            throw new IllegalArgumentException(AMOUNT_POSITIVE_WARN);
        } else {
            return new Amount(this.value.add(value));
        }
    }

    public Amount subtract(BigDecimal value) {
        if (value.signum()==-1) {
            throw new IllegalArgumentException(AMOUNT_POSITIVE_WARN);
        } else {
            return new Amount(this.value.subtract(value));
        }
    }
}

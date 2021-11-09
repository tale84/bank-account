package com.kata.bank;

import java.math.BigDecimal;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {

        if (o == this) return true;
        if (!(o instanceof Amount)) {
            return false;
        }
        Amount amount = (Amount) o;
        return Objects.equals(value, amount.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}

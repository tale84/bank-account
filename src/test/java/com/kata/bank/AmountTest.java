package com.kata.bank;

import io.cucumber.java.bs.A;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.*;

class AmountTest {
    @Test
    public void should_create_an_amount_of_zero() {
        Amount amount = new Amount(BigDecimal.ZERO);

        assertThat(amount.getValue()).isEqualTo(BigDecimal.ZERO);
    }

    @Test
    public void should_create_an_amount_of_ten() {
        Amount amount = new Amount(new BigDecimal(10));

        assertThat(amount.getValue()).isEqualTo(new BigDecimal(10));
    }

    @Test
    public void should_increase_value_to_10_when_add_amount_10() {
        Amount amount = new Amount(BigDecimal.ZERO);

        assertThat(amount.add(new BigDecimal(10)).getValue()).isEqualTo(new BigDecimal(10));
    }
}
package com.kata.bank;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.*;

class BalanceTest {
    @Test
    public void should_create_a_balance_of_ten() {
        Balance balance = new Balance(new Amount(new BigDecimal(10)));

        assertThat(balance.getAmount().getValue()).isEqualTo(new BigDecimal(10));
    }

    @Test
    public void should_add_10_to_an_empty_balance() {
        Balance balance = new Balance(new Amount(BigDecimal.ZERO));

        Balance newBalance = balance.increase(new Amount(new BigDecimal(10)));

        assertThat(newBalance.getAmount().getValue()).isEqualTo(new BigDecimal(10));
    }
}
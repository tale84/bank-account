package com.kata.bank;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.*;

class BalanceTest {

    private Balance BALANCE_OF_TEN = new Balance(new Amount(new BigDecimal(10)));
    private Amount AMOUNT_OF_ZERO = new Amount(BigDecimal.ZERO);
    private Amount AMOUNT_OF_TWENTY = new Amount(new BigDecimal(20));
    private Amount AMOUNT_OF_TEN = new Amount(new BigDecimal(10));

    @Test
    public void should_create_a_balance_of_ten() {
        Balance balance = new Balance(AMOUNT_OF_TEN);

        assertThat(balance).isEqualTo(BALANCE_OF_TEN);
    }

    @Test
    public void should_add_10_to_an_empty_balance() {
        Balance balance = new Balance(AMOUNT_OF_ZERO);

        Balance newBalance = balance.increase(AMOUNT_OF_TEN);

        assertThat(newBalance).isEqualTo(BALANCE_OF_TEN);
    }

    @Test
    public void should_soutract_10_from_balance_when_withdraw() {
        Balance balance = new Balance(AMOUNT_OF_TWENTY);

        Balance newBalance = balance.decrease(AMOUNT_OF_TEN);

        assertThat(newBalance).isEqualTo(BALANCE_OF_TEN);
    }

    @Test
    public void should_generate_an_exception_when_withdraw_an_amount_under_the_balance() {
        Balance balance = new Balance(AMOUNT_OF_ZERO);

        assertThatExceptionOfType(RuntimeException.class).isThrownBy(()->{
            balance.decrease(AMOUNT_OF_TEN);
        });
    }
}
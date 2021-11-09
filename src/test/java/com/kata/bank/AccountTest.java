package com.kata.bank;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.*;

public class AccountTest {

    @Test
    void should_have_empty_balance_when_account_is_created(){
        Account account = new Account(new Balance(new Amount(BigDecimal.ZERO)));
        assertThat(account.getBalance().getAmount().getValue()).isEqualTo(BigDecimal.ZERO);
    }

    @Test
    void should_have_balance_of_10_when_create_account(){
        Account account = new Account(new Balance(new Amount(new BigDecimal(10))));
        assertThat(account.getBalance().getAmount().getValue()).isEqualTo(new BigDecimal(10));
    }

    @Test
    void should_have_balance_10_when_deposit_amount_10_in_empty_account(){
        Account account = new Account(new Balance(new Amount(BigDecimal.ZERO)));
        Amount amount = new Amount(new BigDecimal(10));
        account.deposit(amount);
        assertThat(account.getBalance().getAmount().getValue()
        ).isEqualTo(new BigDecimal(10));
    }

    @Test
    void should_have_balance_10_when_withdraw_10_from_a_balance_20() {
        Account account = new Account(new Balance(new Amount(new BigDecimal(20))));
        Amount amount = new Amount(new BigDecimal(10));
        account.withdraw(amount);
        assertThat(account.getBalance().getAmount().getValue()).isEqualTo(new BigDecimal(10));
    }
}

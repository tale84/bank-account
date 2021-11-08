package com.kata.bank;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.*;

public class AccountTest {

    @Test
    void should_have_empty_balance_when_account_is_created(){
        Account account = new Account(new Balance(BigDecimal.ZERO));
        assertThat(account.getBalance().getAmount()).isEqualTo(BigDecimal.ZERO);
    }

    @Test
    void should_have_balance_of_10_when_create_account(){
        Account account = new Account(new Balance(new BigDecimal(10)));
        assertThat(account.getBalance().getAmount()).isEqualTo(new BigDecimal(10));
    }
}

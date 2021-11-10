package com.kata.bank;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

import static org.assertj.core.api.Assertions.*;

public class AccountTest {

    private final static Clock fixedClock = Clock.fixed(Instant.now(), ZoneId.systemDefault());
    private Balance BALANCE_OF_ZERO = new Balance(new Amount(BigDecimal.ZERO));
    private Balance BALANCE_OF_TEN = new Balance(new Amount(new BigDecimal(10)));
    private Balance BALANCE_OF_TWENTY = new Balance(new Amount(new BigDecimal(20)));

    @Test
    void should_have_empty_balance_when_account_is_created(){
        Account account = new Account(new Balance(new Amount(BigDecimal.ZERO)));
        assertThat(account.getBalance()).isEqualTo(new Balance(new Amount(BigDecimal.ZERO)));
    }

    @Test
    void should_have_balance_of_10_when_create_account(){
        Account account = new Account(BALANCE_OF_TEN);
        assertThat(account.getBalance()).isEqualTo(BALANCE_OF_TEN);
    }

    @Test
    void should_have_balance_10_when_deposit_amount_10_in_empty_account(){
        Account account = new Account(BALANCE_OF_ZERO);
        Amount amount = new Amount(new BigDecimal(10));
        account.deposit(amount);
        assertThat(account.getBalance()).isEqualTo(BALANCE_OF_TEN);
    }

    @Test
    void should_have_balance_10_when_withdraw_10_from_a_balance_20() {
        Account account = new Account(BALANCE_OF_TWENTY);
        Amount amount = new Amount(new BigDecimal(10));
        account.withdraw(amount);
        assertThat(account.getBalance()).isEqualTo(BALANCE_OF_TEN);
    }

    @Test
    void should_add_the_deposit_operation_when_a_deposit_of_10_is_made_in_an_empty_account() {
        Account account = new Account(BALANCE_OF_ZERO, fixedClock);

        account.deposit(new Amount(BigDecimal.TEN));

        assertThat(account.getStatement().getStatementLines()).contains(
                new StatementLine(
                        new Operation(
                                OperationType.DEPOSIT,
                                new Amount(BigDecimal.TEN),
                                LocalDateTime.now(fixedClock)),
                        new Balance(new Amount(BigDecimal.TEN))));
    }

    @Test
    void should_add_the_withdraw_operation_when_a_withdraw_of_10_is_made_in_an_account_with_balance_of_20() {
        Account account = new Account(BALANCE_OF_TWENTY, fixedClock);

        account.withdraw(new Amount(new BigDecimal(10)));

        assertThat(account.getStatement().getStatementLines()).contains(
                new StatementLine(
                        new Operation(
                                OperationType.WITHDRAW,
                                new Amount(new BigDecimal(10)),
                                LocalDateTime.now(fixedClock)),
                        new Balance(new Amount(new BigDecimal(10)))));
    }
}

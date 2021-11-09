package com.kata.bank;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.*;

class StatementLineTest {
    @Test
    void should_create_statement_line() {
        LocalDateTime date = LocalDateTime.of(2021,10,9,0,0,0);
        Amount amount = new Amount(new BigDecimal(10));
        Operation operation = new Operation(OperationType.DEPOSIT, amount, date);
        Balance balance = new Balance(amount);
        StatementLine statementLine = new StatementLine(operation, balance);

        assertThat(statementLine.getOperation().getOperationType()).isEqualTo(OperationType.DEPOSIT);
        assertThat(statementLine.getOperation().getAmount().getValue()).isEqualTo(amount.getValue());
        assertThat(statementLine.getOperation().getLocalDateTime()).isEqualTo(date);

        assertThat(statementLine.getBalance().getAmount().getValue()).isEqualTo(amount.getValue());
    }
}
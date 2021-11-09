package com.kata.bank;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.*;

class OperationTest {
    @Test
    void should_create_an_operation() {
        LocalDateTime date = LocalDateTime.of(2021,10,9,0,0,0);
        Amount amount = new Amount(new BigDecimal(10));
        Operation operation = new Operation(OperationType.DEPOSIT, amount, date);

        assertThat(operation.getOperationType()).isEqualTo(OperationType.DEPOSIT);
        assertThat(operation.getAmount().getValue()).isEqualTo(amount.getValue());
        assertThat(operation.getLocalDateTime()).isEqualTo(date);
    }
}
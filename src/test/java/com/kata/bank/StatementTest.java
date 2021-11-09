package com.kata.bank;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import static org.assertj.core.api.Assertions.*;

public class StatementTest {
    @Test
    void should_add_an_operation_to_statement() {
        LocalDateTime date = LocalDateTime.of(2021,10,9,0,0,0);
        Amount amount = new Amount(new BigDecimal(10));
        Operation operation = new Operation(OperationType.DEPOSIT, amount, date);
        Statement statement = new Statement();
        Balance balance = new Balance(amount);

        statement.addOperation(operation, balance);

        assertThat(statement.getStatementLines()).contains(new StatementLine(operation, balance));
    }
}

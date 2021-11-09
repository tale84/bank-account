package com.kata.bank;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import static org.assertj.core.api.Assertions.*;

class StatementPrinterTest {
    Clock fixedClock = Clock.fixed(Instant.now(), ZoneId.systemDefault());

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    @BeforeEach
    void setup(){
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restore() {
        System.setOut(originalOut);
    }


    @Test
    void should_print_deposit_statement_line(){
        Account account = new Account(new Balance(new Amount(BigDecimal.ZERO)),fixedClock);
        account.deposit(new Amount(BigDecimal.TEN));

        StatementPrinter.printHistoryOfOperations(account.getStatement());

        String expectedDate = LocalDateTime.now(fixedClock).format(formatter);
        String expectedOut = "| OPERATION | DATE | AMOUNT | BALANCE |\n| DEPOSIT | "+expectedDate+" | 10 | 10 |\n";
        assertThat(expectedOut).isEqualTo( outContent.toString());
    }

    @Test
    void should_print_withdraw_statement_line(){

        Account account = new Account(new Balance(new Amount(new BigDecimal(20))),fixedClock);
        account.withdraw(new Amount(new BigDecimal(10)));

        StatementPrinter.printHistoryOfOperations(account.getStatement());

        String expectedDate = LocalDateTime.now(fixedClock).format(formatter);
        String expectedOut = "| OPERATION | DATE | AMOUNT | BALANCE |\n| WITHDRAW | "+expectedDate+" | 10 | 10 |\n";
        assertThat(expectedOut).isEqualTo( outContent.toString());
    }
}
package cucumber;

import com.kata.bank.*;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class AccountStepDefinition {

    private final Clock fixedClock = Clock.fixed(Instant.now(), ZoneId.of("Europe/Paris"));
    private Account account;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    @Given("^account have a balance of (.+)$")
    public void setUpAccountBalance(BigDecimal value) {
        account = new Account(new Balance(new Amount(value)));
    }

    @When("^a deposit of (.+) is made in an empty account$")
    public void aDepositIsMadeInAccount(BigDecimal value) {
        account.deposit(new Amount(value));
    }

    @Then("^the balance must be (.+)$")
    public void theBalanceShouldBeIncreased(BigDecimal value) {
        assertThat(account.getBalance().getAmount().getValue()).isEqualTo(value);
    }

    @When("^a withdraw of (.+) is made in account$")
    public void aWithdrawIsMadeInAccount(BigDecimal value) {
        account.withdraw(new Amount(value));
    }

    @When("^statement of deposit is printed$")
    public void statementOfDepositIsPrinted() {
        System.setOut(new PrintStream(outContent));
        account.printOperations(new ConsoleStatementPrinter());
    }

    @Then("^console display operations$")
    public void consoleDisplayTheDepositOperation(DataTable dataTable) {
        List<StatementLine> statementLines = formatDataTableToListOfStatement(dataTable);
        StringBuffer result = new StringBuffer();
        result.append("| OPERATION | DATE | AMOUNT | BALANCE |\n");
        for (StatementLine statementLine : statementLines) {
            result.append("| " + statementLine.getOperation().getOperationType().toString() +
                    " | " + LocalDateTime.now(fixedClock).format(formatter) +
                    " | " + statementLine.getOperation().getAmount().getValue() +
                    " | " + statementLine.getBalance().getAmount().getValue() + " |\n");
        }
        assertThat(result.toString()).isEqualTo( outContent.toString());
        System.setOut(originalOut);
    }

    private List<StatementLine> formatDataTableToListOfStatement(DataTable dataTable) {
        return dataTable.asMaps().stream().map(table -> {
            LocalDateTime localDate = LocalDateTime.parse(table.get("DATE"), formatter);
            Operation operation = new Operation(
                    OperationType.valueOf(table.get("OPERATION")),
                    new Amount(new BigDecimal(table.get("AMOUNT"))),
                    localDate);
            return new StatementLine(operation, new Balance(new Amount(new BigDecimal(table.get("BALANCE")))));
        }).collect(Collectors.toList());
    }
}

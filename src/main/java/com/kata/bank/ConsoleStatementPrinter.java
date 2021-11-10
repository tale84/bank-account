package com.kata.bank;

import java.time.format.DateTimeFormatter;

public class ConsoleStatementPrinter implements StatementPrinter {
    private  String header = "| OPERATION | DATE | AMOUNT | BALANCE |\n";
    private  String line = "| %s | %s | %s | %s |\n";
    private  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    @Override
    public  void printHistoryOfOperations(Statement statement) {
        StringBuilder stringBuilder = new StringBuilder(header);
        statement.getStatementLines().forEach(statementLine->{
            String printedLine = String.format(line,
                    statementLine.getOperation().getOperationType(),
                    statementLine.getOperation().getLocalDateTime().format(formatter),
                    statementLine.getOperation().getAmount().getValue(),
                    statementLine.getBalance().getAmount().getValue());
            stringBuilder.append(printedLine);
        });
        System.out.print(stringBuilder);
    }
}

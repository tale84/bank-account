package com.kata.bank;

import java.util.ArrayList;
import java.util.List;

public class Statement {
    private List<StatementLine> statementLines = new ArrayList<>();

    public List<StatementLine> getStatementLines() {
        return statementLines;
    }

    public void addOperation(Operation operation, Balance balance) {
        statementLines.add(new StatementLine(operation, balance));
    }

}

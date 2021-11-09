package com.kata.bank;

import java.time.LocalDateTime;
import java.util.Objects;

public class Operation {
    private OperationType operationType;
    private Amount amount;
    private LocalDateTime localDateTime;

    public Operation(OperationType operationType, Amount amount, LocalDateTime localDateTime) {
        this.operationType = operationType;
        this.amount = amount;
        this.localDateTime = localDateTime;
    }

    public OperationType getOperationType() {
        return operationType;
    }

    public Amount getAmount() {
        return amount;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    @Override
    public boolean equals(Object o) {

        if (o == this) return true;
        if (!(o instanceof Operation)) {
            return false;
        }
        Operation operation = (Operation) o;
        return Objects.equals(operationType, operation.operationType) &&
                Objects.equals(amount, operation.amount) &&
                Objects.equals(localDateTime, operation.localDateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operationType, amount, localDateTime);
    }
}

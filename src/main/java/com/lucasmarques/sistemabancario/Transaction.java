package com.lucasmarques.sistemabancario;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction {
    private final BigDecimal value;
    private final LocalDateTime date;
    private final NatureTransaction transictionNature;

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    public Transaction(BigDecimal value, NatureTransaction transictionNature) {
        this.value = value;
        this.date = LocalDateTime.now();
        this.transictionNature = transictionNature;
    }

    public BigDecimal getValue() {
        return value;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public NatureTransaction getTransictionNature() {
        return transictionNature;
    }

    @Override
    public String toString() {
        return "Type: " + transictionNature + " | " + " Value: " + value + " | " + " Date: " + date.format(formatter);
    }
}

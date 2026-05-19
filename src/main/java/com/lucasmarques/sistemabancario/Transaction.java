package com.lucasmarques.sistemabancario;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Transaction {
   private final BigDecimal value;
   private final LocalDateTime date;
   private final NatureTransaction transictionNature;

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
}

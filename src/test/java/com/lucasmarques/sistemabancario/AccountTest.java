package com.lucasmarques.sistemabancario;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.math.BigDecimal;

public class AccountTest {

    @Test
    public void depositPositiveValue() {
        Account account = new Account("Lucas", "12345678910");
        account.deposit(new BigDecimal("29.99"));
        Assertions.assertEquals(new BigDecimal("29.99"), account.getBalance());
    }

    @Test
    public void depositNegativeValue() {
        Account account = new Account("Lucas", "12345678901");
        Assertions.assertThrows(IllegalArgumentException.class, () -> account.deposit(new BigDecimal("-29.99")));
    }


    @Test
    public void positiveWithdrawal() {
        Account account = new Account("Lucas", "12345678910");
        account.deposit(new BigDecimal("100.00"));
        account.withdraw(new BigDecimal("30.00"));
        Assertions.assertEquals(new BigDecimal("70.00"), account.getBalance());
    }

    @Test
    public void negativeWithdrawal() {
        Account account = new Account("Lucas", "12345678910");
        account.deposit(new BigDecimal("100.00"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> account.withdraw(new BigDecimal("200.00")));
    }
}

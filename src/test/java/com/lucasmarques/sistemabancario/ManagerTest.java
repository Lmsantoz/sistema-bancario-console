package com.lucasmarques.sistemabancario;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class ManagerTest {


    @Test
    public void transferTest() {
        ManagerAccount managerAccount = new ManagerAccount();

        Account account1 = new Account("Lucas", "1234567891");
        Account account2 = new Account("pedro", "1234567892");

        managerAccount.getAccounts().add(account1);
        managerAccount.getAccounts().add(account2);

        account1.deposit(new BigDecimal("300.00"));
        managerAccount.transfer(new BigDecimal("200.00"), account2.getIdAccount(), account1.getIdAccount());
        Assertions.assertEquals(new BigDecimal("100.00"), account1.getBalance());
    }

    @Test
    public void transferBalanceTest() {
        ManagerAccount managerAccount = new ManagerAccount();

        Account account1 = new Account("Lucas", "1234567891");
        Account account2 = new Account("pedro", "1234567892");

        managerAccount.getAccounts().add(account1);
        managerAccount.getAccounts().add(account2);

        account1.deposit(new BigDecimal("100.00"));

        Assertions.assertThrows(IllegalArgumentException.class, () -> managerAccount.transfer(new BigDecimal("200.00"), account2.getIdAccount(), account1.getIdAccount()));
    }

}

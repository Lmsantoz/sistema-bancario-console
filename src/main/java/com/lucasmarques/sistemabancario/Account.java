package com.lucasmarques.sistemabancario;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Account {
    private final int idAccount;
    private final  String name;
    private final String cpf;
    private BigDecimal balance;
    private final  List<Transaction> bankStatement;


    private static final Random random = new Random();

    public Account(String name, String cpf) {
        this.name = name;
        this.cpf = cpf;
        this.balance = BigDecimal.valueOf(0.0);
        this.idAccount = random.nextInt(900000) + 100000;
        this.bankStatement = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getIdAccount() {
        return idAccount;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public List<Transaction> getBankStatement() {
        return bankStatement;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Numero da conta: " + idAccount + "\nName: " + name + "\nCPF: " + cpf;
    }

    public void deposit(BigDecimal depositValue) {
        if (depositValue == null || depositValue.signum() == -1) {
            throw new IllegalArgumentException("O valor do deposito deve ser Positivo.");
        }
        System.out.println("Depositando o valor de: " + depositValue);
        setBalance(getBalance().add(depositValue));
    }

    public void withdraw(BigDecimal withdrawValue) {
        if (withdrawValue == null) {
            throw new IllegalArgumentException("Para realizar o saque o valor preciser válido");
        } else if (withdrawValue.signum() == -1) {
            throw new IllegalArgumentException("O valor sacado não deve ser Negativo.");
        } else  if (withdrawValue.compareTo(getBalance()) > 0) {
            throw new IllegalArgumentException("Saldo insuficiente.");
        }
        BigDecimal amountWithdraw = getBalance().subtract(withdrawValue);
        setBalance(amountWithdraw);
    }
}



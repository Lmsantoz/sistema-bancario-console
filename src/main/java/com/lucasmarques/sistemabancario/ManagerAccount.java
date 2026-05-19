package com.lucasmarques.sistemabancario;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManagerAccount {

    private final List<Account> accounts = new ArrayList<>();
    int typedNumber;

    public void addAccount(String accountName, String accountCpf) {

        boolean cpfNumber = accountCpf.matches("[0-9]+");
        if (accountCpf.length() != 11 || !cpfNumber) {
            throw new IllegalArgumentException("ERROR: CPF inválido");
        }
        Account newAccount = new Account(accountName, accountCpf);
        accounts.add(newAccount);
        System.out.println("Account adicionado com sucesso!");
        System.out.println("Esse é seu number de Account para acessa-lá: " + newAccount.getIdAccount());
    }

    public void enterAccount(int accountNumber) {
        Scanner reader = new Scanner(System.in);
        accounts.forEach(account -> {
            if (account.getIdAccount() == accountNumber) {
                System.out.println("Entrando na Conta...");
                System.out.println("Olá " + account.getName() + "!");
                do{
                    System.out.println("====== Oque deseja realizar hoje ? ======");
                    System.out.println("1- Saque");
                    System.out.println("2- Depositar");
                    System.out.println("3- Tranferir");
                    System.out.println("4- Extrato");
                    System.out.println("5- Sair");
                    typedNumber = reader.nextInt();
                } while (typedNumber != 5);
            }
        });
    }
}

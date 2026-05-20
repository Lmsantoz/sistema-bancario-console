package com.lucasmarques.sistemabancario;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ManagerAccount {
    private final List<Account> accounts = new ArrayList<>();
    private int typedNumber;

    public List<Account> getAccounts() {
        return accounts;
    }

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

    public void transfer(BigDecimal transferValue, int destinationAccount, int originAccount) {
        accounts.stream()
                .filter(account -> account.getIdAccount() == originAccount)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Conta de origem não encontrada!"))
                .withdraw(transferValue);

        accounts.stream()
                .filter(account -> account.getIdAccount() == destinationAccount)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Conta de destinatario não encontrada!"))
                .deposit(transferValue);

    }

    public void enterAccount(int accountNumber) {
        Scanner reader = new Scanner(System.in);
        accounts.forEach(account -> {
            if (account.getIdAccount() == accountNumber) {
                System.out.println("Entrando na Conta...");
                System.out.println("Olá " + account.getName() + "!");
                do {
                    System.out.println("===== Informações da sua conta ======");
                    System.out.println("Nome: " + account.getName());
                    System.out.println("Numero da conta: " + account.getIdAccount());
                    System.out.println("Saldo: " + account.getBalance());
                    System.out.println("====== Oque deseja realizar hoje ? ======");
                    System.out.println("1- Saque");
                    System.out.println("2- Depositar");
                    System.out.println("3- Tranferir");
                    System.out.println("4- Extrato");
                    System.out.println("5- Sair");
                    System.out.println("=========================================");
                    typedNumber = reader.nextInt();

                    if (typedNumber == 1) {
                        System.out.println("Digite o valor do saque:");
                        BigDecimal typedValue = new BigDecimal(reader.next());
                        account.withdraw(typedValue);
                        System.out.println("Saque realizado com sucesso!");
                    } else if (typedNumber == 2) {
                        System.out.println("Digite o valor do depósito:");
                        BigDecimal typedValue = new BigDecimal(reader.next());
                        account.deposit(typedValue);
                        System.out.println("Depósito realizado com sucesso!");
                    } else if (typedNumber == 3) {
                        System.out.println("Digite o valor do deposito:");
                        BigDecimal typedValue = new BigDecimal(reader.next());
                        System.out.println("Digite o numero da conta para qual vai depositar:");
                        int typedNumberDestination = reader.nextInt();
                        System.out.println("Digite o numero da conta da qual vai transferir:");
                        int typedNumberOrigin = reader.nextInt();
                        transfer(typedValue, typedNumberDestination, typedNumberOrigin);
                        System.out.println("Transferencia concluida com sucesso!");
                    } else if (typedNumber == 4) {
                        System.out.println("Esse é o extrato da sua conta");
                        account.displayBankStatement();
                    }
                } while (typedNumber != 5);
            }
        });
    }
}

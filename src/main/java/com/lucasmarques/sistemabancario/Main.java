package com.lucasmarques.sistemabancario;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ManagerAccount manager = new ManagerAccount();

        int typedNumber;
        do {
            System.out.println("====== Olá Bem vindo ao banco LifeBank ======");
            System.out.println("1- Adicionar conta");
            System.out.println("2- Entrar em sua conta");
            System.out.println("3- Sair");
            System.out.println("=============================================");

            typedNumber = scanner.nextInt();

            if (typedNumber == 1) {
                System.out.println("Adicionar Conta");

                System.out.println("Qual seu nome ?");
                scanner.nextLine();
                String accountName = scanner.nextLine();

                System.out.println("Digite o seu CPF");
                String accountCpf = scanner.nextLine();

                manager.addAccount(accountName, accountCpf);

            } else if (typedNumber == 2) {
                System.out.println("Digite o numero da conta");
                int typedNumberAccount = scanner.nextInt();
                manager.enterAccount(typedNumberAccount);
            }
        } while (typedNumber != 3);
    }
}
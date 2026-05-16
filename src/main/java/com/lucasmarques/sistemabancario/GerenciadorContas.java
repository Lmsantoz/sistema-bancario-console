package com.lucasmarques.sistemabancario;

import java.util.ArrayList;
import java.util.List;

public class GerenciadorContas {
    private List<Conta> contas = new ArrayList<Conta>();


    public void adicionarConta(String cpfConta, String nomeConta) {

        boolean cpfNumero = cpfConta.matches("[0-9]+");
        if (cpfConta.length() != 11 || !cpfNumero) {
            throw new IllegalArgumentException("CPF inválido: deve ter exatamente 11 dígitos.");
        }
        Conta novaConta = new Conta(cpfConta, nomeConta);
        contas.add(novaConta);
        System.out.println("Conta adicionado com sucesso!");
        System.out.println("Esse é seu numero de conta para acessa-lá: " + novaConta.identificadorConta);
    }
}

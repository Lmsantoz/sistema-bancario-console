# 🏦 Sistema Bancário Console

Sistema bancário simulado via console, desenvolvido em Java puro com Maven — focado em operações básicas de conta como depósito, saque e validação de regras de negócio.

> ⚠️ **Projeto em desenvolvimento ativo** — novas funcionalidades estão sendo adicionadas progressivamente.

---

## 📌 Sobre o projeto

Uma aplicação console que simula operações bancárias fundamentais:

- **Criar conta** com nome, CPF e ID gerado automaticamente (6 dígitos)
- **Depositar** valores (com validação contra valores negativos e nulos)
- **Sacar** valores (com validação de saldo insuficiente e valores inválidos)
- **Entrar na conta** com número da conta
- **Transferencias entre contas** com valor da transferência, número conta destinário e número conta origem

---

## 🛠️ Tecnologias e conceitos utilizados

| Tecnologia / Conceito    | Onde foi aplicado |
|--------------------------|---|
| **Testado em Java 23**   | Linguagem principal do projeto |
| **Maven**                | Gerenciamento de build e dependências |
| **BigDecimal**           | Precisão monetária — evita erros de arredondamento do `double` |
| **JUnit 5**              | Testes unitários para validar regras de depósito e saque |
| **Encapsulamento**       | Atributos `private final` com acesso controlado via getters |
| **Validação de entrada** | `IllegalArgumentException` para valores inválidos |

---

## 📁 Estrutura do projeto

```
sistema-bancario-console/
├── .mvn/                            # Maven Wrapper
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── com/lucasmarques/sistemabancario/
│   │   │   │  
│   │   │   ├── Account.java          # Conta bancária
│   │   │   ├── ManagerAccount.java   # Gerenciamento de contas
│   │   │   ├── Transaction.java      # Modelo de transação
│   │   │   ├── NatureTransaction.java # Enum de tipos de transação
│   │   │   └── Main.java             # Ponto de entrada
│   │   │       
│   │   └── resources/
│   └── test/
│       └── java/
│           └── com/lucasmarques/sistemabancario/
│               ├──AccountTest.java # Testes unitários (depósito e saque)
│               └── ManagerAccountTest.java
├── .gitignore
├── pom.xml                          # Configuração Maven (Java 23, JUnit 5)
├── LICENSE                          # MIT License
└── README.md
```

---

## 🚀 Como rodar

### Pré-requisitos

- **Testado em Java 23 mas requer Java 21** (ou superior) instalado → [Download](https://jdk.java.net/)
- **Maven** instalado → [Download](https://maven.apache.org/download.cgi)

Verifique se estão instalados:

```bash
java --version
mvn --version
```

### Passo a passo

1. **Clone o repositório**

```bash
git clone https://github.com/Lmsantoz/sistema-bancario-console.git
cd sistema-bancario-console
```

2. **Compile o projeto**

```bash
mvn compile
```

3. **Execute os testes**

```bash
mvn test
```

---

## 🧪 Testes implementados

| Teste | O que valida                                        |
|---|-----------------------------------------------------|
| `depositPositiveValue` | Depósito de 29.99 atualiza o saldo corretamente     |
| `depositNegativeValue` | Depósito de valor negativo lança exceção            |
| `positiveWithdrawal` | Saque de 30.00 com saldo de 100.00 resulta em R$70.00 |
| `negativeWithdrawal` | Saque maior que o saldo lança exceção   <            |
| `transferTest`        | Transferência de 200.00 entre contas atualiza saldos corretamente |
| `transferBalanceTest` | Transferência com saldo insuficiente lança exceção               |
---

## 📄 Licença

Este projeto está sob a licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.

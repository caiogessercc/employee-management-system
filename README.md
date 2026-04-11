# Employee Management System

---

## Funcionalidades

O sistema executa as seguintes operações:

* Inserção de funcionários
* Remoção de funcionário por nome
* Listagem de funcionários com formatação
* Aplicação de aumento salarial (10%)
* Agrupamento por função
* Filtro por mês de aniversário (Outubro e Dezembro)
* Identificação do funcionário mais velho
* Ordenação alfabética
* Cálculo do total de salários
* Cálculo de salários mínimos por funcionário

---

## Estrutura do Projeto

```txt
employee-management-system/
 ├── application/
 │    └── EmployeeService.java
 │
 ├── domain/
 │    ├── Employee.java
 │    └── Person.java
 │
 ├── infrastructure/
 │    ├── bootstrap/
 │    │    └── DataProvider.java
 │    │
 │    └── formatting/
 │         └── Formatter.java
 │
 └── Main.java
```

---

## Como testar

### 1. Compilar

```bash
javac Main.java application/*.java domain/*.java infrastructure/bootstrap/*.java infrastructure/formatting/*.java
```

### 2. Executar

```bash
java Main
```

---

## Decisões

### 1. Estrutura

O projeto foi organizado em camadas para manter responsabilidades bem definidas:

* **domain**: entidades e regras de negócio
* **application**: orquestração das operações
* **infrastructure**: suporte externo (dados e formatação)
* **main**: execução do fluxo

Essa organização foi feita para melhorar legibilidade, manutenção e escalabilidade do projeto.

---

### 2. Classe Formatter isolada

A formatação de data e valores foi isolada em uma classe específica:

* Evita misturar regra de negócio com apresentação
* Facilita manutenção e reutilização

---

### 3. DataProvider

A classe `DataProvider` simula uma fonte de dados inicial:

* Permite execução sem banco de dados
* Representa um ponto de inicialização do sistema

---

## Melhorias futuras

* Implementação de testes unitários (JUnit)
* Introdução de camada de persistência (Repository + banco de dados)
* Aplicação de imutabilidade em entidades
* Uso de DTOs para saída
* Desenvolvimento de novas funcionalidades
* Criação de um Frontend

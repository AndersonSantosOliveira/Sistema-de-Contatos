# 📒 Sistema de Gerenciamento de Agenda (Java)

Projeto desenvolvido em **Java** com o objetivo de praticar conceitos fundamentais da linguagem, como **Programação Orientada a Objetos (POO)**, **encapsulamento**, **listas**, **streams**, **validações** e **menu interativo via terminal**.

O sistema simula uma **agenda de contatos**, permitindo cadastrar, buscar, listar e excluir contatos durante a execução do programa.

---

## 🚀 Funcionalidades

- ✅ Cadastrar contatos na agenda
- 🔍 Buscar contato pelo CPF
- ❌ Excluir contato pelo CPF
- 📋 Listar todos os contatos cadastrados
- 📑 Menu interativo no terminal
- 🛡️ Validação de campos obrigatórios

---

## 🛠️ Tecnologias Utilizadas

- Java (JDK 8+)
- IntelliJ IDEA
- Git e GitHub
- Collections (`List`, `ArrayList`)
- Stream API
- Scanner (entrada de dados)

---

## 📂 Estrutura do Projeto
src/
├── Main.java
└── br/com/domain
├── Agenda.java
└── Contato.java


### 📌 Responsabilidade das Classes

- **Main**
    - Controla o menu interativo
    - Recebe as opções do usuário
    - Chama os métodos da classe `Agenda`

- **Agenda**
    - Gerencia a lista de contatos
    - Contém as regras de negócio:
        - cadastro
        - busca
        - exclusão
        - listagem

- **Contato**
    - Representa o modelo de dados
    - Possui validação de campos obrigatórios
    - Implementa `toString()` para exibição no console

---

## ▶️ Como Executar o Projeto

### 1️⃣ Clone o repositório
```bash
git clone git@github.com:AndersonSantosOliveira/Sistema-de-Contatos.git

===== MENU =====
1 - Cadastrar contatos
2 - Buscar contato por CPF
3 - Excluir contatos
4 - Listar contatos
0 - Sair




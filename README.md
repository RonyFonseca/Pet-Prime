# 🐾 PetPrime Terminal System

Um sistema de terminal em **Java puro** para gestão de um PetShop completo, com funcionalidades voltadas para controle de funcionários, produtos, atendimentos e serviços veterinários — tudo isso sem usar interface gráfica ou banco de dados, ideal para fins didáticos ou projetos acadêmicos.

---

## 🚀 Funcionalidades

- 👨‍💼 **Login de Funcionário**
- 📋 **Cadastro de Clientes e Funcionários**
- 🗓️ **Agendamento de Serviços**
- 🐶 **Gestão de Serviços Pet (Banho, Tosa, Vacina, etc.)**
- 📦 **Controle de Estoque**
- 🛒 **Venda e Reposição de Produtos**
- 📊 **Geração de Relatórios**
- 🐾 Produtos organizados por categorias:
  - Cosméticos
  - Rações e Petiscos
  - Produtos de Limpeza

---

## 🧱 Estrutura do Projeto

```bash
PetPrime/
├── src/
│   ├── Main.java
│   ├── Modules/
│   │   ├── Pessoa.java
│   │   ├── Cliente.java
│   │   ├── Funcionario.java
│   │   ├── Produto.java
│   │   ├── Servico.java
│   │   ├── Agendamento.java
│   │   └── Estoque.java
│   └── Services/
│       ├── EstoqueService.java
│       ├── VendaService.java
│       └── AgendamentoService.java
├── data/                  # Simulação de persistência em .txt
│   ├── usuarios.txt
│   ├── estoque.txt
│   └── atendimentos.txt
└── README.md

💻 Tecnologias Utilizadas
Java SE 17+

Sistema de arquivos local (.txt) para persistência

Estrutura modular com pacotes (Modules, Services, etc.)

Orientação a Objetos completa (abstração, herança, encapsulamento)

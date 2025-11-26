# 📚 Scripta - Cliente Java Console

![Java](https://img.shields.io/badge/Java-21-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Status](https://img.shields.io/badge/Status-Concluído-brightgreen?style=for-the-badge)
![License](https://img.shields.io/badge/License-MIT-blue?style=for-the-badge)

> **Aplicação cliente baseada em linha de comando (CLI) para o ecossistema de microsserviços Scripta.**

Este projeto foi desenvolvido como parte adicional da avaliação **A3 - Sistemas Distribuídos** da Universidade do Sul de Santa Catarina (UNISUL). O objetivo é demonstrar a comunicação entre sistemas distribuídos utilizando Java puro para consumir APIs REST.

---

## 📋 Sobre o Projeto

O **ClienteJavaConsole** atua como um *Front-end* simplificado. Ele roda no terminal e permite que o usuário interaja com os microsserviços do sistema de biblioteca **Scripta** (Usuários, Catálogo e Empréstimos).

O diferencial deste projeto é a utilização da biblioteca nativa **`java.net.http.HttpClient`**, demonstrando como realizar requisições HTTP (GET, POST, PUT, DELETE) e manipular JSON sem depender de frameworks pesados no lado do cliente.

## 🚀 Funcionalidades

O sistema permite realizar as seguintes operações via terminal:

* **👤 Usuários:** Cadastro e listagem de usuários.
* **📖 Catálogo:** Consulta de livros disponíveis no acervo.
* **🔄 Integração:** Comunicação síncrona com o Back-end rodando em `localhost`.

## 🛠️ Tecnologias Utilizadas

* **Linguagem:** Java 21 LTS.
* **Comunicação:** `java.net.http.HttpClient`.
* **Manipulação de JSON:** `org.json` ou manipulação de String (Native).
* **IDE:** IntelliJ IDEA.

---

## ⚙️ Pré-requisitos

Antes de rodar este cliente, certifique-se de que o **Back-end (Scripta API)** esteja rodando na sua máquina.

1.  **Java JDK 21** instalado.
2.  **Servidor Scripta** rodando na porta `8082` (ou a porta configurada no seu `Main.java`).

## 🏃‍♂️ Como Rodar

1.  **Clone o repositório:**
    ```bash
    git clone [https://github.com/LAYSEGABI/ClienteJavaConsole.git](https://github.com/LAYSEGABI/ClienteJavaConsole.git)
    ```

2.  **Abra o projeto na sua IDE** (IntelliJ, Eclipse ou VS Code).

3.  **Configure a URL (se necessário):**
    Verifique no arquivo `Main.java` se a `BASE_URL` aponta para a porta correta do seu servidor (ex: `http://localhost:8082`).

4.  **Execute a classe Main:**
    Rode a aplicação e siga as instruções do menu no terminal.

    ```text
    === BEM VINDO AO SCRIPTA (CONSOLE) ===
    1. Login
    2. Cadastrar Usuário
    3. Listar Livros
    4. Sair
    Digite a opção: _
    ```

---

## 🧩 Arquitetura de Comunicação

Este cliente se comunica com os microsserviços através de endpoints REST:

| Método | Endpoint | Descrição |
| :--- | :--- | :--- |
| `POST` | `/auth/login` | Envia credenciais e recebe Bearer Token |
| `POST` | `/usuarios` | Envia JSON para cadastrar novo usuário |
| `GET` | `/livros` | Busca lista de livros (requer Token) |

---

## 👥 Autores

Trabalho desenvolvido por:

 **Layse Gabrielly** 

---

<div align="center">
  <sub>Universidade do Sul de Santa Catarina - 2025</sub>
</div>

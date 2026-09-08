# 🚗 API de Gerenciamento de Frota de Veículos

API RESTful desenvolvida com Spring Boot e Java para o gerenciamento de frota de veículos. O projeto utiliza o banco de dados H2 com persistência em arquivo local e implementa as operações fundamentais de CRUD.

---

## 🛠️ Tecnologias Utilizadas

* **Linguagem:** Java 17+
* **Framework:** Spring Boot
* **Persistência de Dados:** Spring Data JPA / Hibernate
* **Banco de Dados:** H2 Database
* **Build & Dependências:** Apache Maven
* **Arquitetura:** MVC (Model, Repository, Service, Controller)

---

## 📐 Estrutura do Projeto
---

## 📡 Endpoints da API

| Método | Rota | Descrição | Corpo da Requisição (JSON) |
| :--- | :--- | :--- | :--- |
| `GET` | `/veiculos` | Retorna a lista de todos os veículos | N/A |
| `GET` | `/veiculos/{id}` | Retorna um veículo específico pelo ID | N/A |
| `POST` | `/veiculos` | Cadastra um novo veículo | `{"placa":"ABC-1234","marca":"VW","modelo":"Fusca","ano":1975}` |
| `PUT` | `/veiculos/{id}` | Atualiza um veículo existente | `{"placa":"ABC-1234","marca":"VW","modelo":"Fusca","ano":1980}` |
| `DELETE` | `/veiculos/{id}` | Remove um veículo pelo ID | N/A |

---

## 🛢️ Acesso ao Console H2

O console interativo do banco de dados H2 fica disponível enquanto a aplicação está rodando:
* **URL:** `http://localhost:8080/h2-console`
* **JDBC URL:** `jdbc:h2:file:./dbVeiculos`
* **Usuário:** `root`
* **Senha:** `root`

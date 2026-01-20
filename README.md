# API de Produtos

API REST desenvolvida em Java com Spring Boot para gerenciamento de produtos, com foco em boas práticas de backend, organização de código e aplicação de regras de negócio.

---

## 📌 Visão Geral

Este projeto consiste em uma API REST responsável pelo gerenciamento de produtos, permitindo operações de criação, consulta, atualização, desativação e exclusão.
A API foi construída com foco em clareza arquitetural, separação de responsabilidades e validações de negócio, simulando cenários comuns encontrados em aplicações reais.

---

## 🎯 Objetivo do Projeto

O principal objetivo deste projeto é consolidar conhecimentos em desenvolvimento backend utilizando Java e Spring Boot, aplicando conceitos como:

* Arquitetura em camadas (Controller, Service e Repository)
* Separação entre entidades e objetos de transporte de dados (DTOs)
* Implementação de regras de negócio no Service
* Tratamento global de exceções
* Paginação e filtros em consultas

---

## 🧠 Decisões de Arquitetura

Algumas decisões importantes tomadas no projeto:

* **Arquitetura em camadas** para manter responsabilidades bem definidas
* **Uso de DTOs (Request e Response)** para evitar exposição direta das entidades do banco de dados
* **Camada de Service** responsável por regras de negócio, validações e fluxo da aplicação
* **Exceções personalizadas** combinadas com handler global para respostas padronizadas
* **Paginação e filtros** para simular consultas eficientes em cenários reais

Essas decisões visam facilitar manutenção, legibilidade e evolução do projeto.

---

## 🧱 Arquitetura em Camadas

O projeto está organizado da seguinte forma:

* **Controller**
  Responsável por receber as requisições HTTP, validar entradas e retornar respostas adequadas.

* **Service**
  Camada central da aplicação, onde estão concentradas as regras de negócio, validações e decisões de fluxo.

* **Repository**
  Responsável pelo acesso aos dados, utilizando Spring Data JPA para abstração da persistência.

---

## 🔗 Endpoints Principais

Alguns dos principais endpoints disponíveis na API:

* `POST /produto/criar` – Criação de um novo produto
* `GET /produto/listar` – Listagem de produtos com paginação
* `GET /produto/listar/{id}` – Busca de produto por ID
* `GET /produto/buscar/{nome}` – Busca de produto ativo por nome
* `PUT /produto/{id}` – Atualização de produto ativo
* `PATCH /produto/desativar/{id}` – Desativação lógica de produto
* `DELETE /produto/{id}` – Exclusão de produto sem estoque

---

## 🧪 Validações e Regras de Negócio

A API implementa diversas regras de negócio, entre elas:

* Não é permitido criar produtos duplicados com o mesmo nome se estiverem ativos
* Produtos inativos não podem ser atualizados
* Produtos com estoque maior que zero não podem ser deletados
* Validação de dados de entrada utilizando Bean Validation
* Tratamento centralizado de erros com mensagens claras para o cliente

---

## ⚙️ Tecnologias Utilizadas

* **Java** – Linguagem principal do projeto
* **Spring Boot** – Framework para construção da API REST
* **Spring Data JPA** – Abstração para acesso ao banco de dados
* **Hibernate** – ORM para mapeamento objeto-relacional
* **Bean Validation** – Validação de dados de entrada
* **MySQL** – Banco de dados relacional
* **Maven** – Gerenciamento de dependências
* **Postman** - Ferramenta para validação de testes de API

---

## 🚀 Como Executar o Projeto

### Pré-requisitos

* Java 17 ou superior
* Maven
* MySQL
* Postman (ou ferramenta similar para testes de API)

### Passos

1. Clone o repositório:

   ```bash
   git clone https://github.com/seu-usuario/seu-repositorio.git
   ```

2. Configure o banco de dados no `application.properties`

3. Execute o projeto:

   ```bash
   mvn spring-boot:run
   ```

4. Valide endpoints pelo Postman ou ferramentas similares:

```bash
http://localhost:8080/produto/criar

"nome":"Abacaxi",
"descricao":"Abacaxi da Terra",
"preco"1,
"qtdEstoque":20
```

## 📚 Aprendizados

Durante o desenvolvimento deste projeto, foi possível aprofundar conhecimentos em:

* Organização e estruturação de projetos backend
* Implementação de regras de negócio reais
* Uso correto de DTOs e exceções
* Paginação e filtros com Spring Data JPA
* Importância da documentação e clareza de código

---

## 🔮 Possíveis Melhorias Futuras

* Implementação de autenticação e autorização (Spring Security)
* Criação de testes unitários e de integração
* Containerização com Docker
* Cache de consultas frequentes
* Documentação automática com Swagger/OpenAPI

---

## 📌 Status do Projeto

Projeto finalizado para fins de estudo e portfólio, aberto a evoluções e melhorias futuras.

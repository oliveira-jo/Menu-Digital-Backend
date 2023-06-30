# MENU DIGITAL

## Cardapio - BackEnd

- Spring (Boot) Initializr 
  - Criando, gerando configurações e baixa o projeto
  - Gerenciador de Pacotoes Maven
  - Linguagem Java
  - Versão do Spring
  - Dependencias / modulos 
    - spring boot dev tools (reload automático
    - Spring Web ( App Web)
    - Lombock (cria get e set através de anotações)
    - Spring Java JPA (Persistência e manuseio de dados SQP com spring)
    - PostgreSQL Driver (Drive do Banco de Daodos) 
    

- IDE e abre projeto Maven
  - Terminal e instalar dependências
  - Arquivo que lista as dependencias (pom.xml) 

- @SpringBootAplication / main (ponto de start da aplicação)

- Controller
  - FoodController  
    - Concentra os request para pegar e adicionar informações no Banco 
    - @RestController (mapeia) 

- Configurar BD
  - aplication.prpperties
    - url, user e password

- Conexção e Visão do Bando de Dados com ApAdmin4

- Entity
  - Food 
  - Spring notações -> @Table / @Entity
  - Representa a tabela no BDR, em formado do java

- Repository
  - Interface c/ métodos abstratos para manupular e persistir os dados no BD
  - FoodRepository extends JpaRepository<Food, Long>
  - CRUD

- Insomia app
  - aplicação para disparar requisição ao servidor e fazer testes
  - localhost:8080/food

- FoodDateDTO
  - Representação de dados 

# Documentação Geral da API
**Nome do Projeto:** Pacto Recrutamento API

**Descrição:** API para o sistema de recrutamento interno, permitindo a gestão de usuários, vagas, candidaturas, autenticação e autorização.

**Autenticação:** A API utiliza autenticação JWT (JSON Web Token). Para acessar a maioria dos endpoints, é necessário incluir um token JWT válido no cabeçalho Authorization das requisições.

## Sumário

- [Tecnologias Utilizadas](#tecnologias-utilizadas)
- [Instalação e Configuração](#instalação-e-configuração)
- [Estrutura do Projeto](#estrutura-do-projeto)

## Tecnologias Utilizadas

- **Java 8+**
- **Spring Boot 2.0+**
- **Spring Security** para autenticação e autorização.
- **JPA/Hibernate** para persistência de dados.
- **PostgreSQL** como banco de dados relacional.
-  **pgAdmin 4** para manipulação do banco de dados.


## Instalação e Configuração

### Pré-requisitos

- **Java 8+**
- **Maven**
- **PostgreSQL** instalado e configurado

### Passos para Configuração

1. Clone o repositório:

   ```bash
   git clone https://github.com/lucaspk91/recrutamento.git
   cd recrutamento
2. Configure o banco de dados no arquivo 'application.properties':
   
   ```bash
   spring.datasource.url=jdbc:postgresql://localhost:5432/pacto_recrutamento
   spring.datasource.username=seu-usuario
   spring.datasource.password=sua-senha
   spring.jpa.hibernate.ddl-auto=update
3. Compile o projeto:

   ```bash
   mvn clean install
4. Execute a aplicação:

   ```bash
   mvn spring-boot:run

A aplicação estará disponível em http://localhost:8080.

## Estrutura do Projeto

      pacto-recrutamento-backend/
      ├── src/
      │   ├── main/
      │   │   ├── java/
      │   │   │   ├── pacto/recrutamento/
      │   │   │   │   ├── model/          # Modelos de Entidade
      │   │   │   │   ├── repository/     # Repositórios JPA
      │   │   │   │   ├── service/        # Serviços
      │   │   │   │   ├── controller/     # Controladores REST
      │   │   │   │   ├── security/       # Configurações e filtros de segurança
      │   │   │   │   ├── config/         # Configurações
      │   │   └── resources/
      │   │       ├── application.properties  # Configurações da aplicação
      ├── pom.xml                          # Dependências do Maven
      └── README.md                        # Documentação do projeto 

## Endpoints Principais
   
- POST /auth/register: Cadastro de novos usuários.
- POST /auth/login: Autenticação de usuários e geração de token JWT.
- GET /vagas: Listagem de todas as vagas disponíveis.
- POST /vagas: Criação de uma nova vaga (apenas para ADMIN).
- GET /candidaturas/vaga/{vagaId}: Listagem de candidaturas para uma vaga específica.





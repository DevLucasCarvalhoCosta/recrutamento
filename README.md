# Documentação Geral da API
**Nome do Projeto:** Pacto Recrutamento API
 **Descrição:** API para o sistema de recrutamento interno, permitindo a gestão de usuários, vagas, candidaturas, autenticação e autorização.
 **Autenticação:** A API utiliza autenticação JWT (JSON Web Token). Para acessar a maioria dos endpoints, é necessário incluir um token JWT válido no cabeçalho Authorization das requisições.

## Sumário

- [Tecnologias Utilizadas](#tecnologias-utilizadas)
- [Instalação e Configuração](#instalação-e-configuração)

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
   git clone https://github.com/seu-usuario/pacto-recrutamento-backend.git
   cd pacto-recrutamento-backend
  bash```


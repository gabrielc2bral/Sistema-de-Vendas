# API de Vendas

API REST para sistema de vendas com Spring Boot. Permite criar, ler, atualizar e deletar usuários, pedidos e produtos, gerenciar roles com segurança via JWT e Spring Security, além de boas práticas em Java moderno.

## ⚙ Funcionalidades

- Cadastro e gerenciamento de usuários, produtos e pedidos.
- Autenticação e autorização via JWT.
- Roles de acesso (`ROLE_ADMIN`, `ROLE_USER`) e proteção de endpoints com `@PreAuthorize`.
- Senhas criptografadas com BCrypt.

##  Segurança
A segurança é feita com **Spring Security**, usando **JWT** para autenticação. Cada token contém email e role do usuário, garantindo acesso apenas aos endpoints permitidos. 
O `JwtAuthenticationFilter` intercepta as requisições e valida os tokens, colocando a autenticação no `SecurityContextHolder`. Roles são prefixadas com `ROLE_` para compatibilidade com Spring Security.
---
## Começando

Para rodar o projeto, você precisa ter **Java 17+**, **Maven 3.8+** e Docker configurado com as imagens: banco de dados **PostgreSQL 17.7** e pgadmin_gui (prod). Clone o repositório, crie o .env (exemplo a baixo) com seus dados do banco e rode o projeto com `mvn spring-boot:run`. Mais informações técnicas sobre o projeto estão na documentação: [DOC](https://github.com/gabrielc2bral/Sistema-de-Vendas/tree/main/docs).

## Perfis Spring

O projeto já possui três perfis:

- **global** – configurações comuns, não alterar.
- **dev** – H2 em memória para desenvolvimento local.
- **prod** – PostgreSQL para produção.
- **Migrations** separadas por commun, prod, dev.
## Docker Compose

1. Crie o arquivo `.env` com as variáveis:

```env
# Banco de dados
POSTGRES_DB=api_vendas
POSTGRES_USER=postgres
POSTGRES_PASSWORD=senha123

# JWT
JWT_SECRET=SUA KEY, EX: kfOmtzsh3b2PuNd1R5yWIgoEYJcSAU9X

# Spring Profile
SPRING_PROFILES_ACTIVE=prod

# Conexão Spring Boot
DB_URL=jdbc:postgresql://postgres:5432/api_vendas
DB_USER=postgres
DB_PASS=senha123

# PgAdmin
PGADMIN_EMAIL=admin@admin.com
PGADMIN_PASSWORD=admin123
```
2 - Docker Compose e Docker file já existem

3- Suba em prod com docker-compose up --build ou configure o intelij com as variáveis  de ambiente com: SPRING_PROFILES_ACTIVE=dev 

## Extras
- Para testar a API, use o Postman ou Curl com o header `Authorization: Bearer <TOKEN>`.  
- Documentação Swagger disponível nos endpoints `/swagger-ui.html` 
- Sinta-se livre para contribuir, abrir issues ou sugerir melhorias.

## Mini Blog 

# API de Vendas

API REST para sistema de vendas com Spring Boot. Permite criar, ler, atualizar e deletar usuários, pedidos e produtos, gerenciar roles com segurança via JWT e Spring Security, além de boas práticas em Java moderno.

## Funcionalidades

- CRUD Completo: Gerenciamento de usuários, produtos e pedidos.
- Estoque: Controle automatizado de entrada e saída de produtos.
- Segurança: - Autenticação e autorização via JWT.
  - Proteção de endpoints com @PreAuthorize.
  - Criptografia de senhas com BCrypt.

##  Segurança

A segurança é implementada com Spring Security. O fluxo funciona da seguinte forma:

1. O JwtAuthenticationFilter intercepta a requisição.
2. O token é validado e as informações de email/role são extraídas.
3. A autenticação é injetada no SecurityContextHolder.

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
2. Docker Compose e Docker file já existem.

3. Suba em prod com docker-compose up --build ou configure o intelij com as variáveis  de ambiente com: SPRING_PROFILES_ACTIVE=dev 

---

## Extras
- Para testar a API, use o Postman ou Curl com o header `Authorization: Bearer <TOKEN>`.  
- Documentação Swagger disponível nos endpoints `/swagger-ui.html` 
- Sinta-se livre para contribuir, abrir issues ou sugerir melhorias.

---

## Mini Blog 

01/03/2026 
 - Criei o  endpoint "/me/pedidos" e "/me/pedidos/{id}/itens-pedido. Mudei o padrão de exception no projeto para a classe [StandardErro](https://github.com/gabrielc2bral/Sistema-de-Vendas/blob/main/src/main/java/com/gabrieldev/apiVendas/exceptions/StandardError.java). Exemplo do payload:
  ```payload
  {
  "timestamp": "2026-03-02T00:26:49.866573900Z",
  "status": 400,
  "error": "Estoque Insuficiente",
  "message": "Estoque insuficiente para o produto: Cabo HDMI 2m",
  "path": "/pedidos/"
  }
  ```
26/02/2026 
- Mudando a estrutura dos endpoints para o usuário autenticado. Cada pedido sendo exibido pelo endpoint "/me/pedidos" e ".../{id}" para separar os itens e deixar o sistema clean.  

25/02/2026 

- Criei um endpoint para pegar um resumo dos pedidos e dos itens de cada usuário logado no sistema. Futuramente penso em separar em dois endpoints.

24/02/2026 
- Estou aprendendo um novo padrão de Exeption usando a classe "StandardError".
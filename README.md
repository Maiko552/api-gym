Resumo do Projeto: Cadastro de Pessoas com API REST em Java Spring Boot
Este projeto consiste em uma API REST para cadastro de pessoas, utilizando o framework Java Spring Boot. O sistema está estruturado no padrão MVC, utilizando tecnologias como Hibernate para persistência de dados, PostgreSQL como banco de dados, Flyway para controle de migrações, Lombok para redução de código repetitivo e Maven como ferramenta de build.
Utilizando coisas que aprendi com faculdade e cursos, sem seguir tutorial.

A API possui as seguintes funcionalidades:

Cadastro de Pessoas (POST /cadastro): Permite adicionar novas pessoas ao sistema.
Busca por ID (GET /{id}): Recupera uma pessoa específica pelo seu ID.
Listagem de Pessoas (GET /lista): Retorna uma lista de todas as pessoas cadastradas.
Busca por Nome (GET /searchnome/{nome}): Permite buscar pessoas pelo nome ou sobrenome.
Desativação de Pessoa (PATCH /desativar): Marca uma pessoa como desativada no sistema.
O desenvolvimento foi realizado com foco em boas práticas de código, integração de banco de dados e criação de uma API robusta e escalável. A API ainda está em desenvolvimento e, embora funcional, algumas partes estão sendo aprimoradas para garantir uma experiência de uso mais fluida.

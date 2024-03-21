Desafio Lifters Tech - Desenvolvedor Java

Este repositório contém a solução desenvolvida para o Desafio Lifters Tech. Abaixo estão detalhadas as tecnologias utilizadas, bem como as funcionalidades implementadas.
Tecnologias Utilizadas

    Java 17 LTS: Linguagem de programação utilizada para o desenvolvimento.
    Spring Boot Versão 3.2.3: Framework utilizado para construir a aplicação.
        spring web: Para o desenvolvimento de APIs REST.
        spring jpa: Para integração com o banco de dados.
        spring validator: Para validações de dados.
    OpenAPI/Swagger: Ferramenta utilizada para documentação e teste das APIs.
    H2 Database (para teste): Banco de dados em memória utilizado para testes.
    PostgreSQL: Banco de dados utilizado em ambiente de produção.

Funcionalidades Implementadas

    CRUD: Funcionalidades básicas de criação, leitura, atualização e exclusão foram implementadas para as entidades:
        Cargo
        Candidatos
        Eleitores
    PATCH /fechar-sessao: Endpoint para encerrar uma sessão de votação.
    POST /eleitores/{id}/votar: Endpoint para que eleitores realizem seus votos.
    Validações: Foram implementadas validações para evitar a inserção de candidatos e eleitores duplicados no sistema.

Como Executar

    Certifique-se de ter o Java 17 LTS instalado em sua máquina.
    Clone este repositório.
    Configure as credenciais do banco de dados PostgreSQL conforme necessário.
    Execute a aplicação utilizando o comando específico para sua ferramenta de build ou IDE.

Documentação da API

A documentação da API pode ser acessada através do Swagger UI, após a execução da aplicação. Por padrão, pode ser encontrada em http://localhost:8080/swagger-ui.html.

Este projeto foi desenvolvido como parte do Desafio Lifters Tech.


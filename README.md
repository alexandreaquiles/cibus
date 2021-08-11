# cibus

- Problema:

criar e rodar scripts no BD

criar (OK): createDatabaseIfNotExist=true
rodar os scripts
   spring.sql.init.mode = always (vai dar pau na segunda vez que vc rodar)
            foi criado para BDs em memória
            poderia dropar as tabelas no schema

Eu quero manter scripts de evolução do meu BD.

Migration

https://databaserefactoring.com/

versões do BD

- Problema: 
    se editar sem mudar nada, fala que tipo de cozinha ja existe

no BD tem:

79 Francesa

Editar a Francesa (id é 79) e salvar sem mudar nada

tipoDeCozinhaRepository.existsByNome("Francesa")

Temos que verificar se é um nome que já existe, com um ID diferente

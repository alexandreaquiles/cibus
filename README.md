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



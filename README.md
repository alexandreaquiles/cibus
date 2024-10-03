# README

### Contexto

O Cibus é uma aplicação de entrega de comida.

Queremos concorrer com as soluções do mercado, em cidades pequenas do interior do Brasil.

Pra começar, só aceitamos cartões:  débito, crédito e vale refeição.

Ainda não teremos delivery. O próprio restaurante cuida da entrega.

Teremos três perfis de usuário:

- o cliente, que efetua um pedido.
- o dono do restaurante, que mantém os dados do restaurante e muda os status de pedidos pendentes.
- o administrador do Cibus, que mantém os dados básicos do sistema e aprova novos restaurantes.

### Sobre as tecnologias escolhidas

Usamos as seguintes tecnologias:

- Java 21
- Maven 3+
- Spring Boot 3
- Bean Validation
- Spring Data JPA
- Flyway DB, para migrations
- MySQL 8+

### O que já está feito no projeto

- Definição da estrutura e carga inicial das tabelas de Tipo de Cozinha e Restaurantes
- Endpoints de listagem e criação de Tipo de Cozinha em uma API REST
- Alguns testes de integração

### O que você deve fazer

- Um endpoint na API REST com um relatório contendo a quantidade de restaurantes cadastrados por tipo de cozinha. Caso não haja restaurantes, a quantidade deve ser 0.
- Um CRUD de restaurantes com listagem, detalhamento, adição, atualização e remoção de restaurantes
- Um CRUD para as formas de pagamento do restaurante entre: Cartão de Crédito, Cartão de Débito, Vale Refeição ou PIX
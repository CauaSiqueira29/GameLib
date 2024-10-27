# GamesLib
## Descrição do Projeto
O GamesLib é uma API desenvolvida para praticar e aplicar conhecimentos em desenvolvimento backend com Spring Boot. Este projeto foca na criação de uma biblioteca de jogos que pode ser consultada e gerenciada através de requisições HTTP. A API permite operações CRUD, consultas filtradas, e busca por jogos baseados em suas características.

## Tecnologias Utilizadas
- Java 17
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Postman (para testes de rota da API)
- Maven

## Endpoints da API
- `POST: /games` - Adiciona um novo jogo.
  - Para adicionar, estas são as informações necessárias:
  - {"name":"",
    "releaseDate":"",
    "metacritic":,
    "platforms":[""],
    "developer":"",
    "poster":""}
- `GET: /games` - Retorna uma lista paginada de todos os jogos.
- `GET: /games/{id}` - Retorna um jogo específico por ID.
- `GET: /games/platforms?platform={plataforma}` - Retorna jogos filtrados por plataforma.
- `GET: /games/metacritic?note={note}` - Retorna jogos com nota de metacritic acima de um valor especificado.
- `PUT: /games/{id}` - Atualiza informações de um jogo.
- `DELETE: /games/{id}` - Deleta um jogo específico.

## Próximos Passos e Melhorias
- Implementar autenticação e autorização
- Adicionar validação e mensagens de erro mais detalhadas
- Melhorar a performance das consultas
- Implementar testes unitários e de integração

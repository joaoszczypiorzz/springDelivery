# Spring Delivery

Mini API REST de delivery desenvolvida com Java 21, Spring Boot, Spring Data JPA, Hibernate e MySQL. O projeto demonstra uma arquitetura MVC tradicional com separação por domínio e aplicação prática dos princípios SOLID.

## Objetivos

- Disponibilizar operações básicas para pedidos, entregas e produtos.
- Manter `Pedido` como raiz de agregação no processo de criação.
- Persistir o pedido antes dos seus itens e associar cada item ao produto existente.
- Padronizar paginação e respostas de erro.
- Manter regras de negócio desacopladas de implementações concretas de pagamento e notificação.

## Stack

- Java 21
- Spring Boot 4.1.2
- Spring Web MVC
- Spring Data JPA
- Hibernate
- MySQL
- Lombok
- SpringDoc OpenAPI
- Maven Wrapper

## Organização dos packages

```text
joaoszczypior.com.SpringDelivery
├── configuration
├── controller
│   ├── entrega
│   ├── pedido
│   └── produto
├── dto
│   ├── pageable
│   └── pedido
├── enums
│   ├── entrega
│   └── pedido
├── exception
├── models
│   ├── entrega
│   ├── pagamento
│   ├── pedido
│   └── produto
├── repository
│   ├── entrega
│   ├── pedido
│   └── produto
├── service
│   ├── entrega
│   ├── notificacao
│   ├── pedido
│   ├── produto
│   └── relatorio
└── strategy
    └── pagamento
```

Essa organização evita packages genéricos e mantém classes relacionadas próximas, facilitando manutenção, navegação e evolução do projeto.

## Princípios SOLID aplicados

- **SRP:** cada service concentra regras do seu domínio. `PedidoService` coordena exclusivamente o fluxo de pedidos.
- **OCP:** o contrato `PagamentoStrategy` permite adicionar novos métodos de pagamento sem alterar as estratégias existentes.
- **LSP:** os itens utilizam a abstração `Produto`, permitindo trabalhar com `Pizza`, `Hamburger` e `Bebida`.
- **ISP:** contratos menores foram separados em `IPedidoService`, `IEntregaService`, `IRelatorioService` e `INotificacaoService`.
- **DIP:** regras de negócio dependem de interfaces para notificações e serviços, e não de implementações concretas.

## Fluxo de criação de pedido

O endpoint `POST /pedidos` recebe a data opcional e uma lista de itens contendo somente o identificador do produto e a quantidade:

```json
{
  "dataPedido": "2026-11-10T22:30:00",
  "itens": [
    {
      "produtoId": 1,
      "quantidade": 2
    }
  ]
}
```

O `PedidoService` executa as etapas abaixo dentro de uma transação:

1. Cria o pedido com status `CRIADO`.
2. Persiste o pedido para obter seu identificador.
3. Busca cada produto pelo ID informado.
4. Cria cada `ItemPedido` com pedido, produto, quantidade e preço atual do produto.
5. Persiste os itens com `ItemPedidoRepository.saveAll`.

Caso algum produto não exista, uma `EntityNotFoundException` é lançada e a transação não é concluída.

## Endpoints

### Pedidos

| Método | Endpoint | Descrição |
|---|---|---|
| `POST` | `/pedidos` | Cria um pedido e persiste seus itens |
| `GET` | `/pedidos/{id}` | Busca um pedido por ID |
| `GET` | `/pedidos` | Lista pedidos com paginação |
| `GET` | `/pedidos/relatorio` | Retorna o total de pedidos |

### Entregas

| Método | Endpoint | Descrição |
|---|---|---|
| `POST` | `/entregas` | Cria uma entrega |
| `GET` | `/entregas` | Lista entregas com paginação |

### Produtos

| Método | Endpoint | Descrição |
|---|---|---|
| `GET` | `/produtos` | Lista produtos com paginação |

## Paginação

Todos os endpoints de listagem recebem os parâmetros obrigatórios de `FilterPageable`:

```text
page=0
size=10
direction=ASC
orderBy=id
```

Exemplo:

```text
GET /pedidos?page=0&size=10&direction=ASC&orderBy=id
```

As respostas utilizam `ResponsePagedCommom<T>`:

```json
{
  "data": [],
  "totalRecords": 0,
  "totalPages": 0,
  "pageSize": 10
}
```

## Tratamento de erros

`GlobalExceptionHandler` centraliza os erros da API e retorna `ErrorResponse` sem expor stacktrace ou detalhes internos:

```json
{
  "timestamp": "2026-11-10T22:30:00",
  "status": 404,
  "error": "Produto não encontrado: 1"
}
```

São tratados:

- `EntityNotFoundException`: HTTP 404.
- `MethodArgumentNotValidException`: HTTP 400.

## Estratégias de pagamento e notificações

As estratégias disponíveis são:

- Cartão.
- PIX.
- Dinheiro.

Novos métodos podem implementar `PagamentoStrategy` sem modificar o código existente.

As notificações são abstraídas por `INotificacaoService`. As implementações de WhatsApp, e-mail e SMS imprimem a mensagem no console, permitindo substituir posteriormente o mecanismo de envio sem alterar as regras de negócio.

## Configuração do banco

Configure a conexão MySQL no arquivo `src/main/resources/application.properties` ou `application.yml`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/spring_delivery
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=validate
```

As entidades e tabelas devem existir no banco conforme o modelo do projeto.

## Como executar

No Windows:

```bash
mvnw.cmd spring-boot:run
```

No Linux ou macOS:

```bash
./mvnw spring-boot:run
```

Para compilar sem executar os testes:

```bash
mvnw.cmd -DskipTests compile
```

## Documentação da API

Com a aplicação em execução, a documentação Swagger pode ser acessada em:

```text
http://localhost:8080/swagger-ui.html
```

## Observações

- Não existe controller ou service independente para `ItemPedido`; sua persistência é orquestrada pelo `PedidoService`.
- A API utiliza as entidades de produto polimórficas `Pizza`, `Hamburger` e `Bebida`.
- O projeto contém um teste de carregamento do contexto Spring, que exige uma configuração de banco disponível para execução completa.

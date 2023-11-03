# Backend do Projeto LOL

Desenvolver uma API completa para um sistema como o LOL - Lavanderia On-Line requer uma estrutura sólida e organizada.

## Entidades do Sistema
- Cliente
- Funcionário
- Pedido
- ItemPedido (para representar as roupas no pedido)
- Peça de Roupa
- Relatório
- Usuário (para autenticação)

## Rotas


| Categoria                 | Endpoint                                                | Descrição                                         |
|---------------------------|---------------------------------------------------------|---------------------------------------------------|
| **Cliente**               | `POST /clientes`                                        | Cadastrar um cliente                              |
|                           | `GET /clientes/{clienteId}`                            | Consultar detalhes do cliente logado              |
|                           | `GET /clientes/{clienteId}/pedidos`                    | Listar pedidos do cliente                        |
|                           | `POST /clientes/{clienteId}/pedidos`                   | Fazer um pedido                                   |
|                           | `POST /clientes/{clienteId}/pedidos/{pedidoId}/aprovar` | Aprovar um orçamento                             |
|                           | `POST /clientes/{clienteId}/pedidos/{pedidoId}/rejeitar` | Rejeitar um orçamento                           |
|                           | `POST /clientes/{clienteId}/pedidos/{pedidoId}/cancelar` | Cancelar um pedido                               |
|                           | `GET /clientes/{clienteId}/pedidos/{pedidoId}`          | Consultar detalhes de um pedido                  |
|                           | `POST /clientes/{clienteId}/pedidos/{pedidoId}/pagar`   | Pagar um pedido                                   |
| **Funcionário**           | `GET /funcionarios/pedidos`                             | Listar pedidos em aberto                         |
|                           | `POST /funcionarios/pedidos/{pedidoId}/recolher`        | Registrar recolhimento de pedido                |
|                           | `GET /funcionarios/pedidos/todos`                       | Listar todos os pedidos                          |
|                           | `POST /funcionarios/pedidos/{pedidoId}/confirmarLavagem` | Confirmar lavagem de pedido                     |
|                           | `POST /funcionarios/pedidos/{pedidoId}/finalizar`       | Finalizar um pedido                               |
|                           | **Manutenção de Peças de Roupas (CRUD)**               |                                                   |
|                           | `POST /funcionarios/pecas-de-roupas`                   | Inserir peça de roupa                            |
|                           | `PUT /funcionarios/pecas-de-roupas/{pecaId}`            | Atualizar peça de roupa                          |
|                           | `DELETE /funcionarios/pecas-de-roupas/{pecaId}`         | Remover peça de roupa                            |
|                           | `GET /funcionarios/pecas-de-roupas`                     | Listar peças de roupas                          |
|                           | **Manutenção de Funcionários (CRUD)**                  |                                                   |
|                           | `POST /funcionarios/funcionarios`                       | Inserir funcionário                             |
|                           | `PUT /funcionarios/funcionarios/{funcionarioId}`        | Atualizar funcionário                           |
|                           | `DELETE /funcionarios/funcionarios/{funcionarioId}`     | Remover funcionário                             |
|                           | `GET /funcionarios/funcionarios`                         | Listar funcionários                             |
| **Relatórios**            | `GET /relatorios/receitas?dataInicial={dataInicial}&dataFinal={dataFinal}` | Gerar relatório de receitas em PDF  |
|                           | `GET /relatorios/clientes`                               | Gerar relatório de clientes em PDF              |
|                           | `GET /relatorios/clientes-fieis`                          | Gerar relatório de clientes fiéis em PDF       |
| **Autenticação**          | `POST /auth/login`                                       | Login                                             |
| **Outros Endpoints**      | `POST /autocadastro`                                     | Autocadastro de clientes                        |
|                           | `GET /pedidos/{numeroPedido}`                           | Consulta de pedido por número                    |
|                           | `GET /busca-cep?cep={cep}`                             | Busca de CEP (para consultar automaticamente o endereço) |

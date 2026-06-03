# Objetivo do sistema

O sistema tem como objetivo gerenciar pedidos de um restaurante,
permitindo que clientes realizem pedidos e que funcionários acompanhem
todo o fluxo de preparação e entrega dos produtos.

# Problemas que o sistema resolve

* Organização dos pedidos.
* Controle do fluxo de preparo.
* Gerenciamento do cardápio.
* Controle de usuários e permissões.
* Acompanhamento dos status dos pedidos.

 Quem usara o sistema?

* Usuario - Fara o pedido para a loja.
* Garçom - Visualizar os pedidos e montara de acordo.
* Cozinheiro - Responsavel por preparo dos alimentos.
* Gerente - Controle sobre os pedidos e deinifição de demandas.
* Administrador - Controle total sobre a aplicação.

# O que cada pessoa faz?
## Gerente:
* Cadastrar produtos.
* Ver pedidos.
* Editar carápio.
* Atribuir tarefas.

## Cozinheiro:
* Visualizar pedidos.
* Visualizar itens de preparo (carne, batata, tudo que envolver preparo referente a cozinha).

## Garçom:
* Criar pedidos.
* Visualizar pedidos.
* Definir status do pedido.

## Usuario:
* Visualizar cardapio.
* Editar pedido (remover item do produto ou adicionar).

# O que o sistema precisa armazenar?
* Produtos.
* Pedido.
* Usuario.

# O que preciso saber sobre cada coisa?
## Produto:
* Preço.
* Descrição.
* Itens.

## Pedido:
* Data.
* Status.
* Valor.
* Usuario.

## Usuario:
* Nome.
* Email.
* Senha.

# Como essas coisas se conectam?
* Um pedido pode conter varios produtos.
* Um usuario pode fazer varios pedidos.
* Um produto pode vir em varios pedidos.
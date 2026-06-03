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

* Cliente - Fara o pedido para a loja.
* Atendente - Visualizar os pedidos e montara de acordo.
* Cozinheiro - Responsavel por preparo dos alimentos.
* Gerente - Controle sobre os pedidos e deinifição de demandas.
* Administrador - Controle total sobre a aplicação.

# O que cada pessoa faz?

## Administrador
* Gerenciar usuários.
* Gerenciar permissões.

## Gerente:
* Cadastrar produtos.
* Editar produtos.
* Visualizar pedidos.
* Acompanhar operação.

## Cozinheiro:
* Visualizar pedidos em preparo.
* Iniciar preparo dos itens.
* Finalizar preparo dos itens.

## Atendente:
* Criar pedidos.
* Visualizar pedidos.
* Definir status do pedido.

## Cliente:
* Visualizar cardápio.
* Criar pedido.
* Personalizar pedido.
* Acompanhar status do pedido.

# O que o sistema precisa armazenar?
* Produtos.
* Pedido.
* Cliente.

# O que preciso saber sobre cada coisa?
## Produto:
* Preço.
* Descrição.
* Itens.

## Pedido:
* Data.
* Status.
* Valor.
* Cliente.

## Cliente:
* Nome.
* Email.
* Senha.

# Como essas coisas se conectam?
* Um pedido pode conter varios produtos.
* Um usuario pode fazer varios pedidos.
* Um produto pode vir em varios pedidos.
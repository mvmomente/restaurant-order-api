# Entidades do Domínio

## Usuário (User)

Representa qualquer pessoa que acessa o sistema.

### Responsabilidades

* Autenticar-se no sistema.
* Possuir um perfil de acesso.

---

## Perfil (Role)

Define as permissões de um usuário.

### Tipos

* Administrador
* Gerente
* Atendente
* Cozinheiro
* Cliente

---

## Produto (Product)

Representa um item disponível no cardápio.

### Exemplos

* Hambúrguer
* Batata frita
* Refrigerante
* Sorvete

---

## Pedido (Order)

Representa uma solicitação realizada por um cliente.

### Responsabilidades

* Armazenar itens solicitados.
* Controlar o status do pedido.
* Registrar data e valor total.

---

## Item do Pedido (OrderItem)

Representa um produto dentro de um pedido.

### Responsabilidades

* Armazenar quantidade.
* Armazenar valor do produto no momento da compra.

---

## Status do Pedido (OrderStatus)

Representa a etapa atual do pedido.

### Possíveis Status

* RECEIVED
* IN_PREPARATION
* READY
* DELIVERED
* CANCELED

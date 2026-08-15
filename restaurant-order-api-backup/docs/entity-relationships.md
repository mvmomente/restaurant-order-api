# Relacionamentos das Entidades

## User → Role

Um usuário possui um perfil.

### Cardinalidade

* Um User possui um Role.
* Um Role pode estar associado a vários Users.

```text
Role 1 ---- N User
```

---

## User → Order

Um cliente pode realizar vários pedidos.

### Cardinalidade

* Um User pode possuir vários Orders.
* Um Order pertence a apenas um User.

```text
User 1 ---- N Order
```

---

## Order → OrderItem

Um pedido é composto por vários itens.

### Cardinalidade

* Um Order possui vários OrderItems.
* Um OrderItem pertence a apenas um Order.

```text
Order 1 ---- N OrderItem
```

---

## Product → OrderItem

Um produto pode aparecer em diversos pedidos.

### Cardinalidade

* Um Product pode estar presente em vários OrderItems.
* Um OrderItem referencia apenas um Product.

```text
Product 1 ---- N OrderItem
```

---

## Order → OrderStatus

Um pedido possui um status atual.

### Cardinalidade

* Um Order possui um único OrderStatus.

```text
Order 1 ---- 1 OrderStatus
```

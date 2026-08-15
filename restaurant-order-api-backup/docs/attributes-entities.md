# Atributos das Entidades

## User

| Atributo | Descrição                   |
| -------- | --------------------------- |
| id       | Identificador único         |
| name     | Nome do usuário             |
| email    | E-mail utilizado para login |
| password | Senha do usuário            |
| role     | Perfil de acesso            |

---

## Role

| Atributo | Descrição           |
| -------- | ------------------- |
| id       | Identificador único |
| name     | Nome do perfil      |

### Valores possíveis

* ADMIN
* MANAGER
* ATTENDANT
* COOK
* CUSTOMER

---

## Product

| Atributo    | Descrição            |
| ----------- | -------------------- |
| id          | Identificador único  |
| name        | Nome do produto      |
| description | Descrição do produto |
| price       | Preço do produto     |

---

## Order

| Atributo    | Descrição                       |
| ----------- | ------------------------------- |
| id          | Identificador único             |
| createdAt   | Data de criação                 |
| totalAmount | Valor total do pedido           |
| status      | Status atual do pedido          |
| customer    | Cliente responsável pelo pedido |

---

## OrderItem

| Atributo  | Descrição                           |
| --------- | ----------------------------------- |
| id        | Identificador único                 |
| quantity  | Quantidade do produto               |
| unitPrice | Preço unitário no momento da compra |
| subtotal  | Valor total do item                 |

---

## OrderStatus

| Valor          |
| -------------- |
| RECEIVED       |
| IN_PREPARATION |
| READY          |
| DELIVERED      |
| CANCELED       |
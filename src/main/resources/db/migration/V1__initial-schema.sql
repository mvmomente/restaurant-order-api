CREATE TABLE roles (
                       id UUID PRIMARY KEY,
                       name VARCHAR(100) NOT NULL
);

CREATE TABLE users (
                       id UUID PRIMARY KEY,
                       name VARCHAR(100) NOT NULL,
                       email VARCHAR(255) NOT NULL UNIQUE,
                       password VARCHAR(255) NOT NULL,
                       role_id UUID NOT NULL,

                       FOREIGN KEY (role_id) REFERENCES roles(id)
);

CREATE TABLE products (
                          id UUID PRIMARY KEY,
                          name VARCHAR(100) NOT NULL,
                          description VARCHAR(255),
                          price DECIMAL(10,2) NOT NULL
);

CREATE TABLE orders (
                        id UUID PRIMARY KEY,
                        user_id UUID NOT NULL,
                        created_at TIMESTAMP NOT NULL,
                        total_amount DECIMAL(10,2) NOT NULL,
                        status VARCHAR(30) NOT NULL,

                        FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE order_items (
                             id UUID PRIMARY KEY,
                             order_id UUID NOT NULL,
                             product_id UUID NOT NULL,
                             quantity INTEGER NOT NULL,
                             unit_price DECIMAL(10, 2) NOT NULL,
                             subtotal DECIMAL(10,2) NOT NULL,

                             FOREIGN KEY (order_id) REFERENCES orders(id),
                             FOREIGN KEY (product_id) REFERENCES products(id)
);
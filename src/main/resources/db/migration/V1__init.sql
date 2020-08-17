CREATE TABLE products
(
    id           BIGSERIAL PRIMARY KEY,
    product_name VARCHAR(255) NOT NULL,
    price        DECIMAL      NOT NULL,
    date         TIMESTAMP    NOT NULL
);

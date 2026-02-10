CREATE TABLE IF NOT EXISTS itens_pedido (
    id BIGSERIAL PRIMARY KEY,

    pedido_id BIGSERIAL NOT NULL,
    produto_id BIGSERIAL NOT NULL,

    quantidade INT NOT NULL,
    preco_unitario DECIMAL(15,2) NOT NULL,

    CONSTRAINT fk_itens_pedido_pedido
        FOREIGN KEY (pedido_id)
        REFERENCES pedidos(id),

    CONSTRAINT fk_itens_pedido_produto
        FOREIGN KEY (produto_id)
        REFERENCES produtos(id)
);

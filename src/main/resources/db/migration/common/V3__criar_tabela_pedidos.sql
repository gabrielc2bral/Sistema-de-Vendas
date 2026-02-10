CREATE TABLE IF NOT EXISTS pedidos(
    id BIGSERIAL PRIMARY KEY,
    usuario_id BIGSERIAL NOT NULL,
    vendedor_id BIGSERIAL NOT NULL,

    data_pedido TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT fk_pedidos_usuario
            FOREIGN KEY (usuario_id)
            REFERENCES usuarios(id),

    CONSTRAINT fk_pedidos_vendedor
             FOREIGN KEY (vendedor_id)
             REFERENCES usuarios(id)
);
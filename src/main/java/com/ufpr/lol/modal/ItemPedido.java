package com.ufpr.lol.modal;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class ItemPedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private PedidoModal pedido;

    @ManyToOne
    @JoinColumn(name = "roupa_id")
    private int quantidade;
}

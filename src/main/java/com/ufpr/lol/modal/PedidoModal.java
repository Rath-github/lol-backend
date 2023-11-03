package com.ufpr.lol.modal;

import com.ufpr.lol.modal.FuncionarioModal;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Entity
@Data
public class PedidoModal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricao;
    private double valor;
    private Date dataPedido;
    private String status; // Pode ser um enum para representar o status do pedido

    @ManyToOne
    @JoinColumn(name = "funcionario_id")
    private FuncionarioModal funcionario;

    @OneToMany(mappedBy = "pedido")
    private List<ItemPedido> itens;
}
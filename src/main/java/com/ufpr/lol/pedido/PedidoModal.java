package com.ufpr.lol.pedido;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class PedidoModal {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;
    
    private int pedidoNum;
    private String pedidoCliente;
    //private List<> pedidoRoupas;
    private int pedidoOrcamento;
    private int pedidoPrazo;
    private int pedidoHora;
    private int pedidoDia;
    private int pedidoMes;
    private int pedidoAno;
    private String pedidoEstado;
    private String descricao;

    public PedidoModal() {
    }

    
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public int getPedidoNum() {
        return pedidoNum;
    }

    public void setPedidoNum(int pedidoNum) {
        this.pedidoNum = pedidoNum;
    }

    public String getPedidoCliente() {
        return pedidoCliente;
    }

    public void setPedidoCliente(String pedidoCliente) {
        this.pedidoCliente = pedidoCliente;
    }

//   public List<Roupa> getPedidoRoupas() {
//        return pedidoRoupas;   }

 //   public void setPedidoRoupas(List<Roupa> pedidoRoupas) {
 //       this.pedidoRoupas = pedidoRoupas;}
 
    public int getPedidoOrcamento() {
        return pedidoOrcamento;
    }

    public void setPedidoOrcamento(int pedidoOrcamento) {
        this.pedidoOrcamento = pedidoOrcamento;
    }

    public int getPedidoPrazo() {
        return pedidoPrazo;
    }

    public void setPedidoPrazo(int pedidoPrazo) {
        this.pedidoPrazo = pedidoPrazo;
    }

    public int getPedidoHora() {
        return pedidoHora;
    }

    public void setPedidoHora(int pedidoHora) {
        this.pedidoHora = pedidoHora;
    }

    public int getPedidoDia() {
        return pedidoDia;
    }

    public void setPedidoDia(int pedidoDia) {
        this.pedidoDia = pedidoDia;
    }

    public int getPedidoMes() {
        return pedidoMes;
    }

    public void setPedidoMes(int pedidoMes) {
        this.pedidoMes = pedidoMes;
    }

    public int getPedidoAno() {
        return pedidoAno;
    }

    public void setPedidoAno(int pedidoAno) {
        this.pedidoAno = pedidoAno;
    }

    public String getPedidoEstado() {
        return pedidoEstado;
    }

    public void setPedidoEstado(String pedidoEstado) {
        this.pedidoEstado = pedidoEstado;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}




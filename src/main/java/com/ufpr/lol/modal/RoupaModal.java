package com.ufpr.lol.modal;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity(name = "tb_roupas")
@Data
public class RoupaModal {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;
    private String nome;
    private double preco;
    private int prazoLavagem;

}
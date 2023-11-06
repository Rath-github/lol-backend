package com.ufpr.lol.modal;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity(name = "tb_clientes")
@Data
public class ClienteModal {

    @Id
    @GeneratedValue(generator = "uuid")
    private UUID id;
    private String cpf;
    private String nome;
    @Column(unique = true)
    private String email;
    private String endereco;
    private String telefone;
    private String senha;
}

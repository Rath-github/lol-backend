package com.ufpr.lol.modal;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Entity(name = "tb_funcionarios")
@Data
public class FuncionarioModal {
    @Id
    @GeneratedValue(generator = "uuid")
    private UUID id;
    @Column(unique = true)
    private String email;
    private String nome;
    private LocalDate dataNascimento;
    private String senha; // A senha deve ser criptografada com SHA-256 + SALT

}

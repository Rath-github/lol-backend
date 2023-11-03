package com.ufpr.lol.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender javaMailSender;

    public void enviarSenhaPorEmail(String destinatario, String senha) {
        SimpleMailMessage mensagem = new SimpleMailMessage();
        mensagem.setTo(destinatario);
        mensagem.setSubject("Senha de Autocadastro");
        mensagem.setText("Sua senha de autocadastro é: " + senha);

        javaMailSender.send(mensagem);
    }
}

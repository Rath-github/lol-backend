package com.ufpr.lol.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class GerarSenhas {

    public static String generateRandomPassword() {
        int len = 4;
        final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder();

        // Gere uma senha aleatória de 4 caracteres a partir dos caracteres especificados
        for (int i = 0; i < len; i++) {
            int randomIndex = random.nextInt(chars.length());
            sb.append(chars.charAt(randomIndex));
        }

        String senhaAleatoria = sb.toString();

        try {
            // Gere um salt aleatório
            byte[] salt = getSalt();

            // Gere uma senha segura usando o hash SHA-256 com o salt
            String senhaHash = getSecurePassword(senhaAleatoria, salt);

            // Retorne a senha hash para armazenamento seguro no banco de dados
            return senhaHash;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            // Lide com a exceção adequadamente
            return null;
        }
    }

    private static byte[] getSalt() throws NoSuchAlgorithmException {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        return salt;
    }

    public static String getSecurePassword(String password, byte[] salt) {
        String generatedPassword = null;
        try {
            // Crie uma instância do MessageDigest para calcular o hash SHA-256
            MessageDigest md = MessageDigest.getInstance("SHA-256");

            // Atualize o MessageDigest com o salt
            md.update(salt);

            // Calcule o hash da senha
            byte[] bytes = md.digest(password.getBytes());

            StringBuilder sb = new StringBuilder();

            // Converta os bytes do hash em uma representação hexadecimal
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }

            // A senha gerada é o hash resultante
            generatedPassword = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            // Lide com a exceção adequadamente
        }
        return generatedPassword;
    }
}

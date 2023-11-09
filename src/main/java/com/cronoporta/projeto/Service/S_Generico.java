package com.cronoporta.projeto.Service;

import org.springframework.stereotype.Service;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class S_Generico {
    private static final String chave = "chaveDe16Bytes!!"; // Chave de 16 bytes para AES

    //Criptografar CPF
    public static String criptografarCPF(String cpf) {
        try {
            SecretKeySpec key = new SecretKeySpec(chave.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] encrypted = cipher.doFinal(cpf.getBytes());
            return Base64.getEncoder().encodeToString(encrypted);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    //Descriptografar CPF
    public static String descriptografarCPF(String cpfCriptografado) {
        try {
            SecretKeySpec key = new SecretKeySpec(chave.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] decrypted = cipher.doFinal(Base64.getDecoder().decode(cpfCriptografado));
            return new String(decrypted);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean validarEmail(String email) {
        // Define a expressão regular para validar o formato do e-mail
        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";

        // Compila a expressão regular em um objeto Pattern
        Pattern pattern = Pattern.compile(regex);

        // Cria um objeto Matcher para o e-mail fornecido
        Matcher matcher = pattern.matcher(email);

        // Retorna true se o e-mail corresponder à expressão regular, caso contrário, retorna false
        return matcher.matches();
    }

    public static boolean textoEstaVazio(String texto) {
        return texto == null || texto.trim().equals("");
    }

    public static String limparNumero(String number) {
        if (number == null) {
            return null;
        }
        String numeroLimpo = number.replaceAll("[^\\d]", "");

        return numeroLimpo;
    }

    public static String gerarSenha(int qtdLetras, int numeros, int especias) {
        final char[] CARACTER_TEXTO = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".toCharArray();
        final char[] CARACTER_NUMERICO = "0123456789".toCharArray();
        final char[] CARACTER_ESPECIAIS = "!@#$%^&*()-_=+[]{}|;:,.<>?".toCharArray();
        String senha = "";
        Random rand = new Random();

        //preenche caracteres textuais
        for (int i = 0; i < qtdLetras; i++) {
            senha += CARACTER_TEXTO[rand.nextInt(0, CARACTER_TEXTO.length)];
        }
        //preenche caracteres numéricos
        for (int i = 0; i < qtdLetras; i++) {
            senha += CARACTER_NUMERICO[rand.nextInt(0, CARACTER_NUMERICO.length)];
        }
        //preenche caracteres especiais
        for (int i = 0; i < qtdLetras; i++) {
            senha += CARACTER_ESPECIAIS[rand.nextInt(0, CARACTER_ESPECIAIS.length)];
        }
        return senha;
    }

}
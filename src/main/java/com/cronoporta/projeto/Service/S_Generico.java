package com.cronoporta.projeto.Service;

import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class S_Generico {
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
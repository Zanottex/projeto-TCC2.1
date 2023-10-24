package com.cronoporta.projeto.Service;

import com.cronoporta.projeto.Model.M_Usuario;
import com.cronoporta.projeto.Repository.R_Usuario;
import org.springframework.stereotype.Service;

@Service
public class S_Usuario {
    private static R_Usuario usuario;
    public S_Usuario(R_Usuario usuario) {
        this.usuario = usuario;
    }
    public static M_Usuario checarLogin(String nome, String senha) {
        return usuario.findByUsuarioESenha(nome,senha);
    }

}
package com.cronoporta.projeto.Service;

import com.cronoporta.projeto.Model.M_Resposta;
import com.cronoporta.projeto.Model.M_Usuario;
import com.cronoporta.projeto.Repository.R_Usuario;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class S_Usuario {
    private static R_Usuario r_usuario;
    public S_Usuario(R_Usuario usuario) {
        this.r_usuario = usuario;
    }

    public static M_Usuario checarLogin(String nome, String senha) {
        M_Usuario m_usuario = r_usuario.findByUsuarioESenha(nome,senha);
        m_usuario.setCpf(S_Generico.descriptografarCPF(m_usuario.getCpf()));
        return m_usuario;

    }

    public static M_Resposta updateUsuario(String nome, String senha,String novaSenha,String confSenha, String cpf  ){
        boolean podeEnviar = false;
        String mensagem = "";

        M_Usuario m_usuario = checarLogin(nome,senha);


        if(senha.equals(m_usuario.getSenha())){
            podeEnviar = true;
            S_Generico.limparNumero(cpf);
            if(S_Generico.textoEstaVazio(nome)){
                podeEnviar = false;
                mensagem += "O nome precisa ser preenchido";
            }
            if(S_Generico.textoEstaVazio(cpf)){
                podeEnviar = false;
                mensagem += "O nome precisa ser preenchido";
            }
            if(!novaSenha.equals(confSenha) && !S_Generico.textoEstaVazio(novaSenha)){
                podeEnviar = false;
                mensagem += "A confirmação de senha deve ser igual a nova senha";
            }
            if(podeEnviar){

                m_usuario.setNome(nome);
                if(!S_Generico.textoEstaVazio(novaSenha)){
                    m_usuario.setSenha(novaSenha);
                }
                try {
                    m_usuario.setNome(nome);
                    m_usuario.setSenha(novaSenha);
                    m_usuario.setCpf(S_Generico.criptografarCPF(cpf));
                    m_usuario.setId(1);
                    r_usuario.save(m_usuario);
                    mensagem += "Perfil atualizado com sucesso";
                }catch (DataIntegrityViolationException e){
                    podeEnviar = false;
                    mensagem += "Falha ao tentar atualizar o cadastro: "+ e.getMessage();
                }
            }
        }else{
            mensagem += "Senha inválida, o cadastro não pode ser editado";
        }
        return new M_Resposta(podeEnviar,mensagem);
    }
}
package com.cronoporta.projeto.Model;

public class M_Resposta {
    private boolean sucesso;
    private String mensagem;

    public M_Resposta(boolean sucesso, String mensagem){
        this.mensagem = mensagem;
        this.sucesso = sucesso;
    }

    public boolean isSucesso() {
        return sucesso;
    }

    public void setSucesso(boolean sucesso) {
        this.sucesso = sucesso;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
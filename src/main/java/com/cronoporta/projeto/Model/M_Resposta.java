package com.cronoporta.projeto.Model;

public class M_Resposta {
    private boolean sucesso;
    private String mensagem;
    private Long id;

    public M_Resposta(boolean sucesso, String mensagem) {
        this.mensagem = mensagem;
        this.sucesso = sucesso;
    }

    public M_Resposta(boolean sucesso, String mensagem, Long id) {
        this.mensagem = mensagem;
        this.sucesso = sucesso;
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
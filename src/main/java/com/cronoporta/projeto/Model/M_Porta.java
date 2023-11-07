package com.cronoporta.projeto.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "portas")
public class M_Porta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long sala;
    private boolean ativo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSala() {
        return sala;
    }

    public void setSala(Long sala) {
        this.sala = sala;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}

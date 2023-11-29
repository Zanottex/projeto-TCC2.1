package com.cronoporta.projeto.Model;


import jakarta.persistence.*;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDateTime;

@Entity
@Table(name = "reservas_semanais")
public class M_ReservaSema {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean segunda;
    private boolean terça;
    private boolean quarta;
    private boolean quinta;
    private boolean sexta;
    private boolean sabado;
    private boolean domingo;
    private Time data_aberturasema;
    private Time data_fechamentosema;
    private int id_porta;
    private Date data_inicio;
    private Date data_fim;

    public Date getData_Inicio() {
        return data_inicio;
    }

    public void setData_Inicio(Date data_inicio) {
        this.data_inicio = data_inicio;
    }

    public Date getData_Fim() {
        return data_fim;
    }

    public void setData_Fim(Date data_fim) {
        this.data_fim = data_fim;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isSegunda() {
        return segunda;
    }

    public void setSegunda(boolean segunda) {
        this.segunda = segunda;
    }

    public boolean isTerça() {
        return terça;
    }

    public void setTerça(boolean terça) {
        this.terça = terça;
    }

    public boolean isQuarta() {
        return quarta;
    }

    public void setQuarta(boolean quarta) {
        this.quarta = quarta;
    }

    public boolean isQuinta() {
        return quinta;
    }

    public void setQuinta(boolean quinta) {
        this.quinta = quinta;
    }

    public boolean isSexta() {
        return sexta;
    }

    public void setSexta(boolean sexta) {
        this.sexta = sexta;
    }

    public boolean isSabado() {
        return sabado;
    }

    public void setSabado(boolean sabado) {
        this.sabado = sabado;
    }

    public boolean isDomingo() {
        return domingo;
    }

    public void setDomingo(boolean domingo) {
        this.domingo = domingo;
    }

    public Time getData_abertura() {
        return data_aberturasema;
    }

    public void setData_abertura(Time data_aberturasema) {
        this.data_aberturasema = data_aberturasema;
    }

    public Time getData_fechamento() {
        return data_fechamentosema;
    }

    public void setData_fechamento(Time data_fechamentosema) {this.data_fechamentosema = data_fechamentosema;}

    public int getId_porta() {
        return id_porta;
    }

    public void setId_porta(int id_porta) {
        this.id_porta = id_porta;
    }
}

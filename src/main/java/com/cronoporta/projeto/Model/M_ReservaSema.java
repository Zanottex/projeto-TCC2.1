package com.cronoporta.projeto.Model;


import jakarta.persistence.*;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "reservas_semanais")
public class M_ReservaSema {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean segunda;
    private boolean terca;
    private boolean quarta;
    private boolean quinta;
    private boolean sexta;
    private boolean sabado;
    private boolean domingo;
    private LocalTime horario_aberturasema;
    private LocalTime horario_fechamentosema;
    private int  porta_id;
    private LocalDate data_inicio;
    private LocalDate data_fim;

    public LocalDate getData_inicio() {
        return data_inicio;
    }

    public void setData_Inicio(LocalDate data_inicio) {
        this.data_inicio = data_inicio;
    }

    public LocalDate getData_fim() {
        return data_fim;
    }

    public void setData_Fim(LocalDate data_fim) {
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

    public boolean isTerca() {
        return terca;
    }

    public void setTerca(boolean terca) {
        this.terca = terca;
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

    public LocalTime getHorario_aberturasema() {
        return horario_aberturasema;
    }

    public void setHorario_aberturasema(LocalTime horario_aberturasema) {
        this.horario_aberturasema = horario_aberturasema;}

    public LocalTime getHorario_fechamentosema() {
        return horario_fechamentosema;
    }

    public void setHorario_fechamentosema(LocalTime horario_fechamentosema) {this.horario_fechamentosema = horario_fechamentosema;}

    public int getPorta_id() {
        return  porta_id;
    }

    public void setporta_id(int  porta_id) {
        this. porta_id =  porta_id;
    }


}

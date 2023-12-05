package com.cronoporta.projeto.Model;


import jakarta.persistence.*;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;


public class M_dias {

    private Long id;
    private String dias;

    private LocalTime horario_aberturasema;
    private LocalTime horario_fechamentosema;
    private int  porta_id;
    private LocalDate data_inicio;
    private LocalDate data_fim;

    public String getDias() {
        return dias;
    }

    public void setDias(String dias) {
        this.dias = dias;
    }

    public void setPorta_id(int porta_id) {
        this.porta_id = porta_id;
    }

    public void setData_inicio(LocalDate data_inicio) {
        this.data_inicio = data_inicio;
    }

    public void setData_fim(LocalDate data_fim) {
        this.data_fim = data_fim;
    }

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

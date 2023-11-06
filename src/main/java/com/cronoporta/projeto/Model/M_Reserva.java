package com.cronoporta.projeto.Model;

import jakarta.persistence.*;

import java.time.LocalDateTime;


@Entity
@Table(name = "reservas")
public class M_Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime data_abertura;
    private LocalDateTime data_fechamento;
    private int id_porta;

    public int getid_porta() {
        return id_porta;
    }

    public void setid_porta(int id_porta) {
        this.id_porta = id_porta;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getData_abertura() {
        return data_abertura;
    }

    public void setData_abertura(LocalDateTime data_abertura) {
        this.data_abertura = data_abertura;
    }

    public LocalDateTime getData_fechamento() {
        return data_fechamento;
    }

    public void setData_fechamento(LocalDateTime data_fechamento) {
        this.data_fechamento = data_fechamento;
    }
}
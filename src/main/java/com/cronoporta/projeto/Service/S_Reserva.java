package com.cronoporta.projeto.Service;

import InciandoNoSpring.PrimeiraAplicacao.Model.M_Reserva;
import InciandoNoSpring.PrimeiraAplicacao.Repository.R_Reserva;
import com.cronoporta.projeto.Model.M_Reserva;
import com.cronoporta.projeto.Repository.R_Reserva;
import org.springframework.stereotype.Service;

@Service
public class S_Reserva {
    private static R_Reserva reserva;
    public S_Reserva(R_Reserva reserva) {
        this.reserva = reserva;
    }
    public static M_Reserva criarReserva (String usuario, String senha, String data_entrada, String data_saida,
                                          Long quarto) {
        return reserva.fazerReserva(usuario, senha, data_entrada, data_saida, quarto);
    }
}
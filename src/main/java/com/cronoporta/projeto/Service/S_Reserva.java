package com.cronoporta.projeto.Service;

import com.cronoporta.projeto.Model.M_Reserva;
import com.cronoporta.projeto.Repository.R_Reserva;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class S_Reserva {
    private static R_Reserva reserva;
    public S_Reserva(R_Reserva reserva) {
        this.reserva = reserva;
    }

    public static String reservas(int sala, String data_abertura, String data_fechamento){
        boolean podeSalvar = true;
        String mensagem = "";
        if (S_Generico.textoEstaVazio(String.valueOf(sala))) {
            podeSalvar = false;
            mensagem += "A sala precisa ser preenchida.";
        }
        if (S_Generico.textoEstaVazio(data_abertura)) {
            podeSalvar = false;
            mensagem += "A data precisa ser informada.";
        }
        if (S_Generico.textoEstaVazio(data_fechamento)) {
            podeSalvar = false;
            mensagem += "A data precisa ser informada.";
        }
        if (podeSalvar) {
            M_Reserva m_reserva = new M_Reserva();

            try {
                reserva.save(m_reserva);
                mensagem += "Deu bom";
            } catch (DataIntegrityViolationException e) {
                mensagem += "Deu n";
            }
        }
        return mensagem;
    }
}
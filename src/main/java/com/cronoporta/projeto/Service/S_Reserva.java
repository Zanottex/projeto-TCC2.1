package com.cronoporta.projeto.Service;

import com.cronoporta.projeto.Model.M_Reserva;
import com.cronoporta.projeto.Model.M_Resposta;
import com.cronoporta.projeto.Repository.R_Reserva;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Service
public class S_Reserva {
    private static R_Reserva reserva;
    public S_Reserva(R_Reserva reserva) {
        this.reserva = reserva;
    }

    public static String reservas(int id_porta, LocalDateTime data_abertura, LocalDateTime  data_fechamento){
        boolean podeSalvar = true;
        String mensagem = "";
        if (S_Generico.textoEstaVazio(String.valueOf(id_porta))) {
            podeSalvar = false;
            mensagem += "A sala precisa ser preenchida.";
        }
        if (S_Generico.textoEstaVazio(String.valueOf(data_abertura))) {
            podeSalvar = false;
            mensagem += "O horario de abertura precisa ser informada.";
        }
        if (S_Generico.textoEstaVazio(String.valueOf(data_fechamento))) {
            podeSalvar = false;
            mensagem += "O horario de fechamento precisa ser informada.";
        }
        if (podeSalvar) {
            M_Reserva m_reserva = new M_Reserva();
            m_reserva.setData_abertura(data_abertura);
            m_reserva.setData_fechamento(data_fechamento);
            m_reserva.setId_porta(id_porta);
            try {
                reserva.save(m_reserva);
                mensagem += "Deu bom";
            } catch (DataIntegrityViolationException e) {
                mensagem += "Deu n";
            }
        }
        return mensagem;
    }
    public static boolean deletarHorario(long id){
        boolean deletou;
        try {
            reserva.deleteById(id);
            deletou = true;
        }catch (DataIntegrityViolationException e){
            deletou = false;
        }
        return deletou;
    }
    public static ArrayList<M_Reserva> listReservas(){
        return reserva.listReservas();
    }


}
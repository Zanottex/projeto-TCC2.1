package com.cronoporta.projeto.Service;

import com.cronoporta.projeto.Model.M_ReservaSema;
import com.cronoporta.projeto.Model.M_Resposta;
import com.cronoporta.projeto.Repository.R_Reserva;
import com.cronoporta.projeto.Repository.R_ReservaSema;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDateTime;
import java.util.ArrayList;

@Service
public class S_ReservaSema {

    private static R_ReservaSema reservaSema;
    public S_ReservaSema(R_ReservaSema reservaSema) {
        this.reservaSema = reservaSema;
    }


    public static M_Resposta reservasSema(int id_porta, boolean segunda, boolean terça, boolean quarta, boolean quinta, boolean sexta, boolean sabado, boolean domingo, Time data_abertura, Time  data_fechamento, Date data_ini, Date data_fim){
        boolean podeSalvar = true;
        String mensagem = "";
        Date dataAtual = new Date();
        listReservasSema();
        if(data_abertura.equals(dataAtual)){
            podeSalvar = false;
            mensagem += "O Horario de abertura tem que ser maior que a data atual.";
        }
        if(!segunda && !terça && !quarta && !quinta && !sexta && !sabado && !domingo){
            podeSalvar = false;
            mensagem += "Ao menos um dia deve ser selecionado!";
        }
        if(data_ini.before(dataAtual)){
            podeSalvar = false;
            mensagem += "A data de inicio tem que ser maior que a data atual.";
        }
        if(data_ini.after(data_fim)){
            podeSalvar = false;
            mensagem += "A data de inicio tem que ser maior que a data de fim.";
        }
        if(data_fechamento.before(data_abertura)){
            podeSalvar = false;
            mensagem += "O Horario de abertura não pode ser maior que o horario de fechamento.";
        }
        if(data_fechamento.equals(data_abertura)){
            podeSalvar = false;
            mensagem += "O Horario de abertura não pode ser maior que o horario de fechamento.";
        }
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
            M_ReservaSema m_reservasema = new M_ReservaSema();
            m_reservasema.setData_abertura(data_abertura);
            m_reservasema.setData_fechamento(data_fechamento);
            m_reservasema.setId_porta(id_porta);
            m_reservasema.setDomingo(domingo);
            m_reservasema.setSabado(sabado);
            m_reservasema.setSexta(sexta);
            m_reservasema.setQuinta(quinta);
            m_reservasema.setQuarta(quarta);
            m_reservasema.setTerça(terça);
            m_reservasema.setSegunda(segunda);
            m_reservasema.setData_Inicio(data_ini);
            m_reservasema.setData_Fim(data_fim);
            try {
                M_ReservaSema m_reserva1Sema = reservaSema.save(m_reservasema);
                mensagem += "Horario Salvo com sucesso!";
                return new M_Resposta(podeSalvar,mensagem,m_reserva1Sema.getId());
            } catch (DataIntegrityViolationException e) {
                mensagem += "Deu n";
                podeSalvar = false;
            }
        }
        return new M_Resposta(podeSalvar,mensagem);
    }

    public static M_Resposta deletarHorarioSema(long id){

        boolean deletou;
        String mensagem = "";
        try {
            reservaSema.deleteById(id);
            deletou = true;
            mensagem += "Horario deletado com sucesso!";
        }catch (DataIntegrityViolationException e){
            deletou = false;
            mensagem += "Houve um problema ao tentar deletar o horario!";
        }
        M_Resposta m_resposta = new M_Resposta(deletou,mensagem);
        return m_resposta;
    }

    public static ArrayList<M_ReservaSema> listReservasSema(){
        return reservaSema.listReservasSema();
    }
}


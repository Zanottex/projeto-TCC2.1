package com.cronoporta.projeto.Service;


import com.cronoporta.projeto.Model.M_ReservaSema;
import com.cronoporta.projeto.Model.M_Resposta;
import com.cronoporta.projeto.Model.M_dias;

import com.cronoporta.projeto.Repository.R_ReservaSema;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.sql.Array;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class S_ReservaSema {

    private static R_ReservaSema reservaSema;
    public S_ReservaSema(R_ReservaSema reservaSema) {
        this.reservaSema = reservaSema;
    }


    public static M_Resposta reservasSema(int id_porta, boolean segunda, boolean terca, boolean quarta, boolean quinta, boolean sexta, boolean sabado, boolean domingo, String horario_abertura, String  data_fechamento,String data_ini, String data_fim){
        boolean podeSalvar = true;
        String mensagem = "";
        LocalDate dataAtual = LocalDate.now();
        listReservasSema();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate data1 = LocalDate.parse(data_ini, formatter);
        LocalDate data2 = LocalDate.parse(data_fim, formatter);

        DateTimeFormatter formatterTime = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime hora1 = LocalTime.parse(horario_abertura, formatterTime);
        LocalTime hora2 = LocalTime.parse(data_fechamento, formatterTime);

        if(horario_abertura.equals(dataAtual)){
            podeSalvar = false;
            mensagem += "O Horario de abertura tem que ser maior que a data atual.";
        }
        if(!segunda && !terca && !quarta && !quinta && !sexta && !sabado && !domingo){
            podeSalvar = false;
            mensagem += "Ao menos um dia deve ser selecionado!";
        }
        if(data1.isBefore(dataAtual)){
            podeSalvar = false;
            mensagem += "A data de inicio tem que ser maior que a data atual.";
        }
        if(data1.isAfter(data2)){
            podeSalvar = false;
            mensagem += "A data de inicio tem que ser maior que a data de fim.";
        }
        if(hora2.isBefore(hora1)){
            podeSalvar = false;
            mensagem += "O Horario de abertura não pode ser maior que o horario de fechamento.";
        }
        if(data_fechamento.equals(horario_abertura)){
            podeSalvar = false;
            mensagem += "O Horario de abertura não pode ser maior que o horario de fechamento.";
        }
        if (S_Generico.textoEstaVazio(String.valueOf(id_porta))) {
            podeSalvar = false;
            mensagem += "A sala precisa ser preenchida.";
        }
        if (S_Generico.textoEstaVazio(horario_abertura)) {
            podeSalvar = false;
            mensagem += "O horario de abertura precisa ser informada.";
        }
        if (S_Generico.textoEstaVazio(data_fechamento)) {
            podeSalvar = false;
            mensagem += "O horario de fechamento precisa ser informada.";
        }
        if (podeSalvar) {
            M_ReservaSema m_reservasema = new M_ReservaSema();
            m_reservasema.setHorario_aberturasema(hora1);
            m_reservasema.setHorario_fechamentosema(hora2);
            m_reservasema.setporta_id(id_porta);
            m_reservasema.setDomingo(domingo);
            m_reservasema.setSabado(sabado);
            m_reservasema.setSexta(sexta);
            m_reservasema.setQuinta(quinta);
            m_reservasema.setQuarta(quarta);
            m_reservasema.setTerca(terca);
            m_reservasema.setSegunda(segunda);
            m_reservasema.setData_Inicio(data1);
            m_reservasema.setData_Fim(data2);
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

    public static String listdias(Long id){
        String mensagem = "";
            M_ReservaSema mReservaSema = reservaSema.listar1reserva(id);
            if(mReservaSema.isDomingo()) {
                mensagem += " Domingo, ";
            }
            if(mReservaSema.isSegunda()) {
                mensagem += " Segunda, ";
            }
            if(mReservaSema.isTerca()) {
                mensagem += " Terça, ";
            }
            if(mReservaSema.isQuarta()) {
                mensagem += " Quarta, ";
            }
            if(mReservaSema.isQuinta()) {
                mensagem += " Quinta, ";
            }
            if(mReservaSema.isSexta()) {
                mensagem += " Sexta, ";
            }
            if(mReservaSema.isSabado()) {
                mensagem += " Sábado, ";
        }
        return mensagem;
    }
    public static ArrayList<M_ReservaSema> listReservasSema(){

        return reservaSema.listReservasSema();


    }

    public static ArrayList<M_dias> listReservasSema2(){
        ArrayList<M_ReservaSema> array = reservaSema.listReservasSema();
        ArrayList<M_dias> arrayfinal = new ArrayList<>();

        for (M_ReservaSema r: reservaSema.listReservasSema()) {
            M_dias mDias = new M_dias();
            mDias.setDias(listdias(r.getId()));
            mDias.setData_Fim(r.getData_fim());
            mDias.setData_Inicio(r.getData_inicio());
            mDias.setHorario_aberturasema(r.getHorario_aberturasema());
            mDias.setHorario_fechamentosema(r.getHorario_fechamentosema());
            mDias.setId(r.getId());
            mDias.setporta_id(r.getPorta_id());

            arrayfinal.add(mDias);
        }
        return arrayfinal;


    }

}


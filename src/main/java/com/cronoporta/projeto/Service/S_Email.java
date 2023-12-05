package com.cronoporta.projeto.Service;


import com.cronoporta.projeto.Model.M_Reserva;
import com.cronoporta.projeto.Model.M_ReservaSema;
import com.cronoporta.projeto.Model.M_Resposta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class S_Email {

    @Autowired
    private static JavaMailSender mailSender;

    public S_Email(JavaMailSender mailSender) {
        S_Email.mailSender = mailSender;
    }

    public static M_Resposta sendMail(String email){
            String mensagem = "";
            boolean deubom;

            //E-Mail 1
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(email);
            message.setSubject("Relatório dos horarios especificos ativos:");
            List<M_Reserva> reservas = S_Reserva.listReservas();
            String reservas_texto = "";
            for(M_Reserva r : reservas){
                reservas_texto += "Reserva: " + r.getId();
                reservas_texto += " Porta: " + r.getId_porta();
                reservas_texto += " Abertura: " + r.getData_abertura();
                reservas_texto += " Fechamento: " + r.getData_fechamento() + "\n\n";
            }


            List<M_ReservaSema> reservasSema = S_ReservaSema.listReservasSema();
            reservas_texto += "\nReservas semanais:\n";
            for(M_ReservaSema r : reservasSema){
                reservas_texto += "Reserva: " + r.getId();
                reservas_texto += " Dias: " + S_ReservaSema.listdias(r.getId());
                reservas_texto += " Porta: " + r.getPorta_id();
                reservas_texto += " Horario de Abertura: " + r.getHorario_aberturasema();
                reservas_texto += " Horario de Fechamento: " + r.getHorario_fechamentosema();
                reservas_texto += " Data de inicio: " + r.getData_inicio();
                reservas_texto += " Data de fim: " + r.getData_fim() + "\n\n";
            }
            message.setText(reservas_texto);

            try {
                mailSender.send(message);
                mensagem = "E-mail de relatório enviado!";
                deubom = true;
            }catch (Exception e){
                mensagem = "Falha no envido do e-mail do relatório!";
                deubom = false;
            }

        return new M_Resposta(deubom, mensagem);
    }
}



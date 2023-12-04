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
//            String e_mail1 = Arrays.toString();
            message.setText("e_mail1");


            //E-Mail 2

            SimpleMailMessage message2 = new SimpleMailMessage();
            message2.setTo(email);
            message2.setSubject("Relatório dos horarios Semanais ativos:");
//            String e_mail2 = Arrays.toString();
            message2.setText("e_mail2");

            try {
                mailSender.send(message);
                mailSender.send(message2);
                mensagem = "E-mail de relatório enviado!";
                deubom = true;
            }catch (Exception e){
                mensagem = "Falha no envido do e-mail do relatório!";
                deubom = false;
            }

        return new M_Resposta(deubom, mensagem);
    }
}



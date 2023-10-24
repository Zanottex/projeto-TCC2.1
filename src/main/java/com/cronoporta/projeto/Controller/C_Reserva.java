package com.cronoporta.projeto.Controller;

import InciandoNoSpring.PrimeiraAplicacao.Service.S_Reserva;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("reserva")

public class C_Reserva {

    @GetMapping("/Reserva")
    public String reserva() {
        return "Reserva/reserva";
    }

    @PostMapping("/Reserva")
    public String processReserva(@RequestParam("usuario") String usuario, @RequestParam("senha") String senha,
                                 @RequestParam("data_entrada") String data_entrada,
                                 @RequestParam("data_saida") String data_saida,
                                 @RequestParam("quarto") Long quarto, HttpSession session,
                                 HttpServletRequest request) {

        session.setAttribute("reserva", S_Reserva.criarReserva(usuario, senha, data_entrada, data_saida,
                quarto));
        if(session.getAttribute("reserva") != null) {
            session.setAttribute("sucesso", "Reserva realizada com sucesso!");
            request.setAttribute("reserva", session.getAttribute("reserva"));
            return "redirect/reserva";
        } else {
            return "redirect:/?error";
        }
    }
}
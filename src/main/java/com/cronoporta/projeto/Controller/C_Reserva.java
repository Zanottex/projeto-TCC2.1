package com.cronoporta.projeto.Controller;

import com.cronoporta.projeto.Service.S_Reserva;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@SessionAttributes("reserva")

public class C_Reserva {

    @GetMapping("/Reserva")
    public String reserva() {
        return "Reserva/reserva";
    }

    @PostMapping("/Reserva")
    @ResponseBody
    public String processReserva(@RequestParam("sala") int sala,
                                 @RequestParam("data_abertura") String data_abertura,
                                 @RequestParam("data_fechamento") String data_fechamento,
                                  HttpSession session,
                                 HttpServletRequest request) {

        session.setAttribute("reserva", S_Reserva.reservas(sala, data_abertura, data_fechamento));
        if(session.getAttribute("reserva") != null) {
            session.setAttribute("sucesso", "Reserva realizada com sucesso!");
            request.setAttribute("reserva", session.getAttribute("reserva"));
            return "redirect/reserva";
        } else {
            return "redirect:/?error";
        }
    }
}
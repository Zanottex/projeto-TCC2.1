package com.cronoporta.projeto.Controller;

import com.cronoporta.projeto.Service.S_Reserva;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Controller
@SessionAttributes("usuario")
public class C_Home {

    @GetMapping("/home")
    public String home(HttpSession session, Model model) {
        if (session.getAttribute("usuario") != null) {
            model.addAttribute("usuario",session.getAttribute("usuario"));
            return "Home/home";
        } else {
            // A sessão não existe, redirecionar para a página de login
            return "redirect:/";
        }
    }
    @PostMapping("/Reserva")
    @ResponseBody
    public String processReserva(
                                 @RequestParam("horarioE") LocalDateTime data_abertura,
                                 @RequestParam("horarioS") LocalDateTime data_fechamento,
                                 @RequestParam("sala") int sala,
                                 HttpSession session,
                                 HttpServletRequest request) {

        session.setAttribute("reserva", S_Reserva.reservas(sala, data_abertura, data_fechamento ));
        if(session.getAttribute("reserva") != null) {
            session.setAttribute("sucesso", "Reserva realizada com sucesso!");
            request.setAttribute("reserva", session.getAttribute("reserva"));
            return "redirect/reserva";
        } else {
            return "redirect:/?error";
        }
    }
}

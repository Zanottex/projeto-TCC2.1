package com.cronoporta.projeto.Controller;

import com.cronoporta.projeto.Model.M_Resposta;
import com.cronoporta.projeto.Service.S_Reserva;
import com.cronoporta.projeto.Service.S_ReservaSema;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class C_Hominha {
    @GetMapping("/Hominha")
    public String gethominha(HttpServletRequest request,HttpSession session, Model model){
        model.addAttribute("reserva",session.getAttribute("reserva"));
        model.addAttribute("reservaSema",S_ReservaSema.listReservasSema2());
        if(request.getHeader("Referer") != null){
            model.addAttribute("reservas",S_Reserva.listReservas());
            return "Home/Hominha";
        }else{
            return "redirect:/";
        }
    }

    @PostMapping("/deletar")
    @ResponseBody
    public M_Resposta botoes(@RequestParam("idHorario") long id){
        return S_Reserva.deletarHorario(id);
    }


    @PostMapping("/deletarSema")
    @ResponseBody
    public M_Resposta deletarhorariosema(@RequestParam("idHorario") long id){
        return S_ReservaSema.deletarHorarioSema(id);
    }

}
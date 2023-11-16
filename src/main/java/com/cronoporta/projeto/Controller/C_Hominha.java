package com.cronoporta.projeto.Controller;

import com.cronoporta.projeto.Service.S_Reserva;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;

@Controller
public class C_Hominha {
    @GetMapping("/Hominha")
    public String gethominha(HttpServletRequest request,HttpSession session, Model model){
        model.addAttribute("reserva",session.getAttribute("reserva"));
        if(request.getHeader("Referer") != null){
            model.addAttribute("reservas",S_Reserva.listReservas());
            return "Home/Hominha";
        }else{
            return "redirect:/";
        }
    }

}
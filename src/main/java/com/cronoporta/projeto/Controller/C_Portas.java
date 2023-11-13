package com.cronoporta.projeto.Controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class C_Portas {
    @GetMapping("/Portas")
    public String getPortas(HttpServletRequest request, HttpSession session, Model model){
        if(request.getHeader("Referer") != null){
            Object portas = session.getAttribute("portas");
            model.addAttribute("portas",portas);
            return "Portas/Portas";
        }else{
            return "redirect:/";
        }
    }

//    @PostMapping("/Portas")
//    @Repository
//    public
}

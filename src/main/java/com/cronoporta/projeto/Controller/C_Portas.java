package com.cronoporta.projeto.Controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class C_Portas {
    @GetMapping("/Portas")
    public String getPortas(HttpServletRequest request){
        if(request.getHeader("Referer") != null){
            return "Portas/Portas";
        }else{
            return "redirect:/";
        }
    }

//    @PostMapping("/Portas")
//    @Repository
//    public
}

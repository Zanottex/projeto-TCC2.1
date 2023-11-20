package com.cronoporta.projeto.Controller;

import com.cronoporta.projeto.Model.M_Resposta;
import com.cronoporta.projeto.Service.S_Porta;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class C_Portas {
    @GetMapping("/Portas")
    public String getPortas(HttpServletRequest request, HttpSession session, Model model){
        if(request.getHeader("Referer") != null){
            model.addAttribute("portas",S_Porta.listPorta());
            return "Portas/Portas";
        }else{
            return "redirect:/";
        }
    }

    @GetMapping("/PortasA/{id}")
    @ResponseBody
    public M_Resposta botoes(@PathVariable("id") int id){
        return S_Porta.abrirPortas(id);
    }


}

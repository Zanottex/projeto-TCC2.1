package com.cronoporta.projeto.Controller;

import com.cronoporta.projeto.Model.M_Resposta;
import com.cronoporta.projeto.Service.S_Porta;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


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
    @PostMapping("/Portas")
    @ResponseBody
    public String botoes(@RequestParam("abrir") boolean abrir,
                         @RequestParam("sala") String sala,
                         @RequestParam("id") int id){
        return S_Porta.abrirPortas(abrir,id,sala);
    }
}

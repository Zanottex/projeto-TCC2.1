package com.cronoporta.projeto.Controller;

import com.cronoporta.projeto.Model.M_Resposta;
import com.cronoporta.projeto.Model.M_Usuario;
import com.cronoporta.projeto.Service.S_Usuario;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class C_Perfil {

    @GetMapping("/edit/usuario")
    public String getEditUsuario(HttpServletRequest request,
                                 HttpSession session,
                                 Model model){
        if (request.getHeader("Referer") != null){
            model.addAttribute("usuario",session.getAttribute("usuario"));
            return "/edit/usuario";
        }else{
            return "redirect:/";
        }
    }
    @PostMapping("/edit/usuario")
    @ResponseBody
    public M_Resposta posteditUsuario(@RequestParam("nome") String nome,
                                      @RequestParam("senha") String senha,
                                      @RequestParam("novaSenha") String novaSenha,
                                      @RequestParam("confSenha") String confSenha,
                                      @RequestParam("cpf") String cpf){

        return S_Usuario.updateUsuario(nome,senha,novaSenha,confSenha,cpf);
    }
}

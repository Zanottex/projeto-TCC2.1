package com.cronoporta.projeto.Controller;

import com.cronoporta.projeto.Service.S_Usuario;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class C_Login {

    @GetMapping("/")
    public String login() {
        return "Login/login";
    }


    @PostMapping("/")
    @ResponseBody
    public boolean processLogin(@RequestParam("Usuario") String usuario,
                               @RequestParam("senha") String senha,
                               HttpSession session, HttpServletRequest request) {
        session.setAttribute("usuario",S_Usuario.checarLogin(usuario,senha));
        if(session.getAttribute("usuario")== null){
            return false;
        }else{
            return true;
        }

    }
    @GetMapping("/logout")
    public String getCadastro(HttpSession session){
        session.setAttribute("usuario",null);
        return "redirect:/";
    }
}
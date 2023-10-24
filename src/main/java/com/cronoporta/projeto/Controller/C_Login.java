package com.cronoporta.projeto.Controller;

import InciandoNoSpring.PrimeiraAplicacao.Service.S_Cadastro;
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
    public String processLogin(@RequestParam("usuario") String usuario,
                               @RequestParam("senha") String senha,
                               HttpSession session, HttpServletRequest request) {



    }
}
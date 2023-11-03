package com.cronoporta.projeto.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
@SessionAttributes("usuario")
public class C_Home {

    @GetMapping("/home")
    public String home(@ModelAttribute("usuario") String usuario) {
        if (usuario != null) {
            // A sessão existe, redirecionar para a página home
            return "Home/home";
        } else {
            // A sessão não existe, redirecionar para a página de login
            return "redirect:Login/login";
        }
    }
}

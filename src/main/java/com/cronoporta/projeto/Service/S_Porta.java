package com.cronoporta.projeto.Service;

import com.cronoporta.projeto.Model.M_Porta;
import com.cronoporta.projeto.Repository.R_Porta;
import org.springframework.stereotype.Service;

@Service
public class S_Porta {
    private static R_Porta r_porta;
    public S_Porta(R_Porta r_porta){this.r_porta = r_porta;}

    public static M_Porta portas(int id){
        return r_porta.findPorta(id);
    }


}

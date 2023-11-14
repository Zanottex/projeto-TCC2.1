package com.cronoporta.projeto.Service;

import com.cronoporta.projeto.Model.M_Porta;
import com.cronoporta.projeto.Model.M_Reserva;
import com.cronoporta.projeto.Model.M_Resposta;
import com.cronoporta.projeto.Repository.R_Porta;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class S_Porta {
    private static R_Porta r_porta;
    public S_Porta(R_Porta r_porta){this.r_porta = r_porta;}

    public static ArrayList<M_Porta> listPorta(){
        return r_porta.listPortas();
    }

    public static String abrirPortas(boolean abrir, long id, String sala){
        M_Porta m_porta = new M_Porta();
        String mensagem ="";
        m_porta.setAtivo(abrir);
        m_porta.setId(id);
        m_porta.setSala(sala);
        try{
            r_porta.save(m_porta);
            mensagem += "Deu Bom";
        }catch (DataIntegrityViolationException e){

            mensagem += "Deu ruim";
        }

        return mensagem;
    }
}

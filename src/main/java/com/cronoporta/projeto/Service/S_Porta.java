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

    public static M_Resposta abrirPortas(long id){
        M_Porta m_porta = r_porta.findPorta(id);
        m_porta.setAtivo(!m_porta.isAtivo());
        String mensagem ="";
        boolean sucesso;
        try{
            r_porta.save(m_porta);
            if(m_porta.isAtivo()) {
                mensagem += "Porta Aberta com Sucesso!";
            }
            else{
                mensagem += "Porta fechada com Sucesso!";
            }
            sucesso = true;
        }catch (DataIntegrityViolationException e){
            if(m_porta.isAtivo()) {
                mensagem += "Houve um problema ao tentar abrir a porta!";
            }
            else{
                mensagem += "Houve um problema ao tentar fechar a porta!";
            }
            sucesso = false;
        }
        M_Resposta m_resposta = new M_Resposta(sucesso,mensagem);

        return m_resposta;
    }
}

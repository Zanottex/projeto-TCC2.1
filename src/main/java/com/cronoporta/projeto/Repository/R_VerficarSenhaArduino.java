package com.cronoporta.projeto.Repository;

import InciandoNoSpring.PrimeiraAplicacao.Model.M_Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface R_VerificarSenhaArduino extends JpaRepository<M_Usuario, Long> {
    @Query(value = "SELECT * FROM usuario WHERE senha = :senha", nativeQuery = true)
    M_Usuario findBySenha(@Param("senha") String senha);
}
package com.cronoporta.projeto.Repository;

import com.cronoporta.projeto.Model.M_Cadastro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface R_Arduino extends JpaRepository<M_Cadastro, Long> {
    @Query(value = "SELECT * FROM usuario WHERE senha = :senha", nativeQuery = true)
    M_Cadastro findBySenha(@Param("senha") String senha);
}
package com.cronoporta.projeto.Repository;

import com.cronoporta.projeto.Model.M_Porta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface R_Porta extends JpaRepository<M_Porta, Long> {
    @Query(value = "SELECT * FROM portas WHERE id = :id", nativeQuery = true)
    M_Porta findPorta(@Param("id") int id);

}

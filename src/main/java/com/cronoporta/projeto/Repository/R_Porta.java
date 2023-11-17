package com.cronoporta.projeto.Repository;

import com.cronoporta.projeto.Model.M_Porta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface R_Porta extends JpaRepository<M_Porta, Long> {
    @Query(value = "select * from portas order by id", nativeQuery = true)
    ArrayList<M_Porta> listPortas();
    @Query(value="select * from portas where id = :id",nativeQuery = true)
    M_Porta findPorta(@Param("id") Long id);
}

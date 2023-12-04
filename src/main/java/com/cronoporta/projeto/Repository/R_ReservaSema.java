package com.cronoporta.projeto.Repository;

import com.cronoporta.projeto.Model.M_ReservaSema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface R_ReservaSema extends JpaRepository<M_ReservaSema, Long> {

    @Query(value="select * from reservas_semanais order by id",nativeQuery = true)
    ArrayList<M_ReservaSema> listReservasSema();


}

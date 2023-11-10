package com.cronoporta.projeto.Repository;

import com.cronoporta.projeto.Model.M_Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface R_Reserva extends JpaRepository<M_Reserva, Long> {
    @Query(value="select * from reservas",nativeQuery = true)
    ArrayList<M_Reserva> listReservas();
}
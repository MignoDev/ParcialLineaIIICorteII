package com.example.ParcialCorteII.Repositories;

import com.example.ParcialCorteII.Models.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JugadorRepository extends JpaRepository<Jugador, Integer> {

    @Query("select p from jugador p where p.idEquipo = :id")
    List<Object[]> buscaJugadoresEquipo(@Param("id") int id);
}

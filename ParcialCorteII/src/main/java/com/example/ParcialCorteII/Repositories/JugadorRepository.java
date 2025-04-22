package com.example.ParcialCorteII.Repositories;

import com.example.ParcialCorteII.Models.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JugadorRepository extends JpaRepository<Jugador, Integer> {

    @Query(value = "select * from jugador p where p.id_equipo = :id", nativeQuery = true)
    List<Jugador> buscaJugadoresEquipo(@Param("id") int id);

    @Query(value = """
            SELECT j.*
            FROM jugador j
            JOIN estadisticas_jugador e ON j.id_jugador = e.id_jugador
            GROUP BY j.id_jugador
            HAVING SUM(e.goles) >= :goles
        """, nativeQuery = true)
    List<Jugador> buscarJugadoresGoleadores(@Param("goles") int goles);
}

package com.example.ParcialCorteII.Repositories;

import com.example.ParcialCorteII.Models.Equipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipoRepository extends JpaRepository<Equipo, Integer> {
    @Query(value = """
            SELECT
                (SELECT COALESCE(SUM(m1.goles_local), 0)
                 FROM partido m1
                 WHERE m1.equipo_local = :idEquipo) +
                (SELECT COALESCE(SUM(m2.goles_visita), 0)
                 FROM partido m2
                 WHERE m2.equipo_visita = :idEquipo) AS total_goles;
            """, nativeQuery = true)
    int totalGoles(@Param("idEquipo") int equipo);
}

package com.example.ParcialCorteII.Repositories;

import com.example.ParcialCorteII.Models.Equipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipoRepository extends JpaRepository<Equipo, Integer> {
    @Query(value = """
            select
              e.*,
              (
                select
                  (
                    select
                      COALESCE(SUM(m1.goles_local), 0)
                    from
                      partido m1
                    where
                      m1.equipo_local = :idEquipo
                  ) + (
                    select
                      COALESCE(SUM(m2.goles_visita), 0)
                    from
                      partido m2
                    where
                      m2.equipo_visita = :idEquipo
                  ) as total_goles
              ) goles
            from
              equipo e
            where
              e.id_equipo = :idEquipo
            group by e.id_equipo
            """, nativeQuery = true)
    Object[] totalGoles(@Param("idEquipo") int idEquipo);
}

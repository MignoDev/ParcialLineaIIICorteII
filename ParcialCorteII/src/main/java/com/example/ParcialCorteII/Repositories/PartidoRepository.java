package com.example.ParcialCorteII.Repositories;

import com.example.ParcialCorteII.Models.Partido;
import com.example.ParcialCorteII.Models.PartidoDetalle;
import jakarta.servlet.http.Part;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PartidoRepository extends JpaRepository<Partido, Integer> {

//    @Query(value = """
//            select m, tl, tv from partido m
//            join equipo tl on m.equipo_local = tl.id_equipo
//            join equipo tv on m.equipo_visita = tv.id_equipo
//            """, nativeQuery = true)
//    List<Object[]> detallePartidos();

    @Query("SELECT new com.example.ParcialCorteII.Models.PartidoDetalle(p, el, ev) " +
       "FROM Partido p " +
       "JOIN Equipo el ON p.equipoLocal.idEquipo = el.idEquipo " +
       "JOIN Equipo ev ON p.equipoVisita.idEquipo = ev.idEquipo")
    List<PartidoDetalle> detallePartidos();
}

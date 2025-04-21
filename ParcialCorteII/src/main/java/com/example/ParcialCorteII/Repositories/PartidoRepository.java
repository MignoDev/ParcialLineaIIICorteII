package com.example.ParcialCorteII.Repositories;

import com.example.ParcialCorteII.Models.Partido;
import jakarta.servlet.http.Part;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartidoRepository extends JpaRepository<Partido, Integer> {
}

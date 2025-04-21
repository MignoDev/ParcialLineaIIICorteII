package com.example.ParcialCorteII.Repositories;

import com.example.ParcialCorteII.Models.Entrenador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntrenadorRepository extends JpaRepository<Entrenador, Integer> {


}

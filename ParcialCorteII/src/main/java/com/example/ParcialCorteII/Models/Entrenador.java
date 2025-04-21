package com.example.ParcialCorteII.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class Entrenador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEntrenador;

    @Column(length = 100)
    private String nombre;

    @Column(length = 100)
    private String especialidad;

    @Column(name = "id_equipo")
    private int idEquipo;

    @ManyToOne
    @JoinColumn(name = "id_equipo", insertable = false, updatable = false)
    @JsonIgnore
    private Equipo equipo;

    public Entrenador() {
    }

    public Entrenador(int idEntrenador, String nombre, String especialidad, int idEquipo, Equipo equipo) {
        this.idEntrenador = idEntrenador;
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.idEquipo = idEquipo;
        this.equipo = equipo;
    }

    public int getIdEntrenador() {
        return idEntrenador;
    }

    public void setIdEntrenador(int idEntrenador) {
        this.idEntrenador = idEntrenador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public int getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }
}

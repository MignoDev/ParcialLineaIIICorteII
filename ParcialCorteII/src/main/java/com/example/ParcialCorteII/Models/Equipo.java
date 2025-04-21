package com.example.ParcialCorteII.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Equipo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEquipo;

    @Column(length = 100)
    private String nombre;

    @Column(length = 100)
    private String ciudad;

    private LocalDate fundacion;

    @OneToMany(mappedBy = "idEquipo")
    @JsonIgnore
    private List<Jugador> jugadores;

    @OneToMany(mappedBy = "idEquipoLocal")
    @JsonIgnore
    private List<Partido> partidosLocal;

    @OneToMany(mappedBy = "idEquipoVisita")
    @JsonIgnore
    private List<Partido> partidosVisita;

    @OneToMany(mappedBy = "idEquipo")
    @JsonIgnore
    private List<Entrenador> entrenadores;

    public Equipo() {
    }

    public Equipo(int idEquipo, String nombre, String ciudad, LocalDate fundacion, List<Jugador> jugadores, List<Partido> partidosLocal, List<Partido> partidosVisita, List<Entrenador> entrenadores) {
        this.idEquipo = idEquipo;
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.fundacion = fundacion;
        this.jugadores = jugadores;
        this.partidosLocal = partidosLocal;
        this.partidosVisita = partidosVisita;
        this.entrenadores = entrenadores;
    }

    public int getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public LocalDate getFundacion() {
        return fundacion;
    }

    public void setFundacion(LocalDate fundacion) {
        this.fundacion = fundacion;
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(List<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public List<Partido> getPartidosLocal() {
        return partidosLocal;
    }

    public void setPartidosLocal(List<Partido> partidosLocal) {
        this.partidosLocal = partidosLocal;
    }

    public List<Partido> getPartidosVisita() {
        return partidosVisita;
    }

    public void setPartidosVisita(List<Partido> partidosVisita) {
        this.partidosVisita = partidosVisita;
    }

    public List<Entrenador> getEntrenadores() {
        return entrenadores;
    }

    public void setEntrenadores(List<Entrenador> entrenadores) {
        this.entrenadores = entrenadores;
    }
}

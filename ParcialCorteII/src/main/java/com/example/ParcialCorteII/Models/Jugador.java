package com.example.ParcialCorteII.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Jugador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idJugador;

    @Column(length = 100)
    private String nombre;

    @Column(length = 50)
    private String posicion;

    private int dorsal;

    private LocalDate fechaNacimiento;

    @Column(length = 100)
    private String nacionalidad;

    @Column(name = "id_equipo")
    private int idEquipo;

    @ManyToOne
    @JoinColumn(name = "id_equipo", insertable = false, updatable = false)
    @JsonIgnore
    private Equipo equipo;

    @OneToMany(mappedBy = "idJugador")
    @JsonIgnore
    private List<EstadisticasJugador> estadisticasJugadorList;

    public Jugador() {
    }

    public Jugador(int idJugador, String nombre, String posicion, int dorsal, LocalDate fechaNacimiento, String nacionalidad, int idEquipo, Equipo equipo, List<EstadisticasJugador> estadisticasJugadorList) {
        this.idJugador = idJugador;
        this.nombre = nombre;
        this.posicion = posicion;
        this.dorsal = dorsal;
        this.fechaNacimiento = fechaNacimiento;
        this.nacionalidad = nacionalidad;
        this.idEquipo = idEquipo;
        this.equipo = equipo;
        this.estadisticasJugadorList = estadisticasJugadorList;
    }

    public int getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(int idJugador) {
        this.idJugador = idJugador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public int getDorsal() {
        return dorsal;
    }

    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
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

    public List<EstadisticasJugador> getEstadisticasJugadorList() {
        return estadisticasJugadorList;
    }

    public void setEstadisticasJugadorList(List<EstadisticasJugador> estadisticasJugadorList) {
        this.estadisticasJugadorList = estadisticasJugadorList;
    }
}

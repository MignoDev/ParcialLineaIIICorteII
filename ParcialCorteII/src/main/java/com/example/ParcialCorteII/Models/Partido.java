package com.example.ParcialCorteII.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Partido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPartido;

    private LocalDate fecha;

    @Column(length = 100)
    private String estadio;

    @Column(name = "equipo_local")
    private int idEquipoLocal;

    @ManyToOne
    @JoinColumn(name = "equipoo_local", insertable = false, updatable = false)
    @JsonIgnore
    private Equipo equipoLocal;

    @Column(name = "equipo_visita")
    private int idEquipoVisita;

    @ManyToOne
    @JoinColumn(name = "equipo_visita", updatable = false, insertable = false)
    @JsonIgnore
    private Equipo equipoVisita;

    private int golesLocal;

    private int golesVisita;

    public Partido() {
    }

    public Partido(int idPartido, LocalDate fecha, String estadio, int idEquipoLocal, Equipo equipoLocal, int idEquipoVisita, Equipo equipoVisita, int golesLocal, int golesVisita) {
        this.idPartido = idPartido;
        this.fecha = fecha;
        this.estadio = estadio;
        this.idEquipoLocal = idEquipoLocal;
        this.equipoLocal = equipoLocal;
        this.idEquipoVisita = idEquipoVisita;
        this.equipoVisita = equipoVisita;
        this.golesLocal = golesLocal;
        this.golesVisita = golesVisita;
    }

    public int getIdPartido() {
        return idPartido;
    }

    public void setIdPartido(int idPartido) {
        this.idPartido = idPartido;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getEstadio() {
        return estadio;
    }

    public void setEstadio(String estadio) {
        this.estadio = estadio;
    }

    public int getIdEquipoLocal() {
        return idEquipoLocal;
    }

    public void setIdEquipoLocal(int idEquipoLocal) {
        this.idEquipoLocal = idEquipoLocal;
    }

    public Equipo getEquipoLocal() {
        return equipoLocal;
    }

    public void setEquipoLocal(Equipo equipoLocal) {
        this.equipoLocal = equipoLocal;
    }

    public int getIdEquipoVisita() {
        return idEquipoVisita;
    }

    public void setIdEquipoVisita(int idEquipoVisita) {
        this.idEquipoVisita = idEquipoVisita;
    }

    public Equipo getEquipoVisita() {
        return equipoVisita;
    }

    public void setEquipoVisita(Equipo equipoVisita) {
        this.equipoVisita = equipoVisita;
    }

    public int getGolesLocal() {
        return golesLocal;
    }

    public void setGolesLocal(int golesLocal) {
        this.golesLocal = golesLocal;
    }

    public int getGolesVisita() {
        return golesVisita;
    }

    public void setGolesVisita(int golesVisita) {
        this.golesVisita = golesVisita;
    }
}

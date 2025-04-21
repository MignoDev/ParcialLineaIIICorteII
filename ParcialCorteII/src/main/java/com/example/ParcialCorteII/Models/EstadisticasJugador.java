package com.example.ParcialCorteII.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class EstadisticasJugador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEstadistica;

    @Column(name = "id_jugador")
    private int idJugador;

    @ManyToOne
    @JoinColumn(name = "id_jugador", insertable = false, updatable = false)
    @JsonIgnore
    private Jugador jugador;

    @Column(name = "id_partido")
    private int idPartido;

    @ManyToOne
    @JoinColumn(name = "id_partido", updatable = false, insertable = false)
    @JsonIgnore
    private Partido partido;

    private int minutosJugados;

    private int goles;

    private int asistencias;

    private int tarjetasAmarillas;

    private int tarjetasRojas;

    public EstadisticasJugador() {
    }

    public EstadisticasJugador(int idEstadistica, int idJugador, Jugador jugador, int idPartido, Partido partido, int minutosJugados, int goles, int asistencias, int tarjetasAmarillas, int tarjetasRojas) {
        this.idEstadistica = idEstadistica;
        this.idJugador = idJugador;
        this.jugador = jugador;
        this.idPartido = idPartido;
        this.partido = partido;
        this.minutosJugados = minutosJugados;
        this.goles = goles;
        this.asistencias = asistencias;
        this.tarjetasAmarillas = tarjetasAmarillas;
        this.tarjetasRojas = tarjetasRojas;
    }

    public int getIdEstadistica() {
        return idEstadistica;
    }

    public void setIdEstadistica(int idEstadistica) {
        this.idEstadistica = idEstadistica;
    }

    public int getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(int idJugador) {
        this.idJugador = idJugador;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public int getIdPartido() {
        return idPartido;
    }

    public void setIdPartido(int idPartido) {
        this.idPartido = idPartido;
    }

    public Partido getPartido() {
        return partido;
    }

    public void setPartido(Partido partido) {
        this.partido = partido;
    }

    public int getMinutosJugados() {
        return minutosJugados;
    }

    public void setMinutosJugados(int minutosJugados) {
        this.minutosJugados = minutosJugados;
    }

    public int getGoles() {
        return goles;
    }

    public void setGoles(int goles) {
        this.goles = goles;
    }

    public int getAsistencias() {
        return asistencias;
    }

    public void setAsistencias(int asistencias) {
        this.asistencias = asistencias;
    }

    public int getTarjetasAmarillas() {
        return tarjetasAmarillas;
    }

    public void setTarjetasAmarillas(int tarjetasAmarillas) {
        this.tarjetasAmarillas = tarjetasAmarillas;
    }

    public int getTarjetasRojas() {
        return tarjetasRojas;
    }

    public void setTarjetasRojas(int tarjetasRojas) {
        this.tarjetasRojas = tarjetasRojas;
    }
}

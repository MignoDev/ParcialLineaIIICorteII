package com.example.ParcialCorteII.Models;

public class PartidoDetalle {

    private Partido partido;

    private Equipo equipoLocal;

    private Equipo equipoVisita;

    public PartidoDetalle(Partido partido, Equipo equipoLocal, Equipo equipoVisita) {
        this.partido = partido;
        this.equipoLocal = equipoLocal;
        this.equipoVisita = equipoVisita;
    }

    public Partido getPartido() {
        return partido;
    }

    public void setPartido(Partido partido) {
        this.partido = partido;
    }

    public Equipo getEquipoLocal() {
        return equipoLocal;
    }

    public void setEquipoLocal(Equipo equipoLocal) {
        this.equipoLocal = equipoLocal;
    }

    public Equipo getEquipoVisita() {
        return equipoVisita;
    }

    public void setEquipoVisita(Equipo equipoVisita) {
        this.equipoVisita = equipoVisita;
    }
}

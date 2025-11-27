package com.udla.scisriant.licencia.cache;

import java.time.LocalDateTime;

public class LicenciaCacheEntry {

    private String cedula;
    private String placa;
    private int puntos;
    private boolean tieneCitaciones;
    private LocalDateTime ultimaActualizacion;

    public LicenciaCacheEntry(String cedula, String placa, int puntos, boolean tieneCitaciones, LocalDateTime ultimaActualizacion) {
        this.cedula = cedula;
        this.placa = placa;
        this.puntos = puntos;
        this.tieneCitaciones = tieneCitaciones;
        this.ultimaActualizacion = ultimaActualizacion;
    }

    public String getCedula() {
        return cedula;
    }

    public String getPlaca() {
        return placa;
    }

    public int getPuntos() {
        return puntos;
    }

    public boolean isTieneCitaciones() {
        return tieneCitaciones;
    }

    public LocalDateTime getUltimaActualizacion() {
        return ultimaActualizacion;
    }
}

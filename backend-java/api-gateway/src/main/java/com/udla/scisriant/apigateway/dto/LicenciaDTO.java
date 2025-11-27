package com.udla.scisriant.apigateway.dto;

import java.time.LocalDateTime;

public class LicenciaDTO {

    private String cedula;
    private int puntos;
    private boolean tieneCitaciones;
    private LocalDateTime ultimaActualizacion;
    private String mensaje;

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public boolean isTieneCitaciones() {
        return tieneCitaciones;
    }

    public void setTieneCitaciones(boolean tieneCitaciones) {
        this.tieneCitaciones = tieneCitaciones;
    }

    public LocalDateTime getUltimaActualizacion() {
        return ultimaActualizacion;
    }

    public void setUltimaActualizacion(LocalDateTime ultimaActualizacion) {
        this.ultimaActualizacion = ultimaActualizacion;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}

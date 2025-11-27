package com.udla.scisriant.apigateway.dto;

public class ContribuyenteDTO {

    private boolean esContribuyente;
    private String tipoPersona;
    private String nombreCompleto;

    public boolean isEsContribuyente() {
        return esContribuyente;
    }

    public void setEsContribuyente(boolean esContribuyente) {
        this.esContribuyente = esContribuyente;
    }

    public String getTipoPersona() {
        return tipoPersona;
    }

    public void setTipoPersona(String tipoPersona) {
        this.tipoPersona = tipoPersona;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }
}

package com.udla.scisriant.apigateway.dto;

public class RespuestaCompletaDTO {

    private String email;
    private ContribuyenteDTO contribuyente;
    private VehiculoDTO vehiculo;
    private LicenciaDTO licencia;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ContribuyenteDTO getContribuyente() {
        return contribuyente;
    }

    public void setContribuyente(ContribuyenteDTO contribuyente) {
        this.contribuyente = contribuyente;
    }

    public VehiculoDTO getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(VehiculoDTO vehiculo) {
        this.vehiculo = vehiculo;
    }

    public LicenciaDTO getLicencia() {
        return licencia;
    }

    public void setLicencia(LicenciaDTO licencia) {
        this.licencia = licencia;
    }
}

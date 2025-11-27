package com.udla.scisriant.licencia.service;

import com.udla.scisriant.licencia.dto.LicenciaDTO;
import org.springframework.stereotype.Component;

@Component
public class AntWebClient {

    public LicenciaDTO consultarLicencia(String cedula, String placa) {
        LicenciaDTO dto = new LicenciaDTO();
        dto.setCedula(cedula);
        dto.setPuntos(25);
        dto.setTieneCitaciones(false);
        dto.setMensaje("Datos obtenidos desde la web de la ANT (simulados).");
        return dto;
    }
}

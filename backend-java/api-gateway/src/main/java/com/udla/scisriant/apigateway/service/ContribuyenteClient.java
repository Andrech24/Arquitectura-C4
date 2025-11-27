package com.udla.scisriant.apigateway.service;

import com.udla.scisriant.apigateway.dto.ContribuyenteDTO;
import org.springframework.stereotype.Component;

@Component
public class ContribuyenteClient {

    public ContribuyenteDTO obtenerContribuyente(String ruc) {
        ContribuyenteDTO dto = new ContribuyenteDTO();
        dto.setEsContribuyente(true);
        dto.setTipoPersona("NATURAL");
        dto.setNombreCompleto("Contribuyente " + ruc);
        return dto;
    }
}

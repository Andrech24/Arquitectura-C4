package com.udla.scisriant.apigateway.service;

import com.udla.scisriant.apigateway.dto.LicenciaDTO;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class LicenciaClient {

    private final RestTemplate restTemplate = new RestTemplate();

    public LicenciaDTO obtenerLicencia(String cedula, String placa) {
        String url = "http://localhost:8082/api/licencia?cedula=" + cedula + "&placa=" + placa;
        return restTemplate.getForObject(url, LicenciaDTO.class);
    }
}

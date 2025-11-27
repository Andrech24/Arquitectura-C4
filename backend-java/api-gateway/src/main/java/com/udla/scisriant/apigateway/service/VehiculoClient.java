package com.udla.scisriant.apigateway.service;

import com.udla.scisriant.apigateway.dto.VehiculoDTO;
import org.springframework.stereotype.Component;

@Component
public class VehiculoClient {

    public VehiculoDTO obtenerVehiculo(String placa) {
        VehiculoDTO dto = new VehiculoDTO();
        dto.setPlaca(placa.toUpperCase());
        dto.setMarca("MarcaEjemplo");
        dto.setModelo("ModeloEjemplo");
        dto.setAnio(2020);
        return dto;
    }
}

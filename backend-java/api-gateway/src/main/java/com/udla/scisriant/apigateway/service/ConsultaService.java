package com.udla.scisriant.apigateway.service;

import com.udla.scisriant.apigateway.dto.*;
import org.springframework.stereotype.Service;

@Service
public class ConsultaService {

    private final ContribuyenteClient contribuyenteClient;
    private final VehiculoClient vehiculoClient;
    private final LicenciaClient licenciaClient;

    public ConsultaService(
            ContribuyenteClient contribuyenteClient,
            VehiculoClient vehiculoClient,
            LicenciaClient licenciaClient
    ) {
        this.contribuyenteClient = contribuyenteClient;
        this.vehiculoClient = vehiculoClient;
        this.licenciaClient = licenciaClient;
    }

    public RespuestaCompletaDTO realizarConsulta(ConsultaRequest request) {
        ContribuyenteDTO contribuyente = contribuyenteClient.obtenerContribuyente(request.getRuc());
        VehiculoDTO vehiculo = vehiculoClient.obtenerVehiculo(request.getPlaca());
        LicenciaDTO licencia = licenciaClient.obtenerLicencia(request.getRuc(), request.getPlaca());

        RespuestaCompletaDTO respuesta = new RespuestaCompletaDTO();
        respuesta.setEmail(request.getEmail());
        respuesta.setContribuyente(contribuyente);
        respuesta.setVehiculo(vehiculo);
        respuesta.setLicencia(licencia);
        return respuesta;
    }
}

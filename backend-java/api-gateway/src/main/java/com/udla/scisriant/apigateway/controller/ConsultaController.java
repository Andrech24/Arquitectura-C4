package com.udla.scisriant.apigateway.controller;

import com.udla.scisriant.apigateway.dto.ConsultaRequest;
import com.udla.scisriant.apigateway.dto.RespuestaCompletaDTO;
import com.udla.scisriant.apigateway.service.ConsultaService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class ConsultaController {

    private final ConsultaService consultaService;

    public ConsultaController(ConsultaService consultaService) {
        this.consultaService = consultaService;
    }

    @PostMapping("/consulta")
    public RespuestaCompletaDTO consultar(@Valid @RequestBody ConsultaRequest request) {
        return consultaService.realizarConsulta(request);
    }
}

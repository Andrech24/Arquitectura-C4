package com.udla.scisriant.licencia.controller;

import com.udla.scisriant.licencia.dto.LicenciaDTO;
import com.udla.scisriant.licencia.service.LicenciaService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class LicenciaController {

    private final LicenciaService licenciaService;

    public LicenciaController(LicenciaService licenciaService) {
        this.licenciaService = licenciaService;
    }

    @GetMapping("/licencia")
    public LicenciaDTO obtenerLicencia(
            @RequestParam String cedula,
            @RequestParam String placa
    ) {
        return licenciaService.obtenerLicencia(cedula, placa);
    }
}

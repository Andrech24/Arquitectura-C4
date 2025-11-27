package com.udla.scisriant.licencia.service;

import com.udla.scisriant.licencia.cache.LicenciaCacheEntry;
import com.udla.scisriant.licencia.cache.LicenciaCacheRepository;
import com.udla.scisriant.licencia.dto.LicenciaDTO;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class LicenciaService {

    private final LicenciaCacheRepository cacheRepository;
    private final AntWebClient antWebClient;

    public LicenciaService(LicenciaCacheRepository cacheRepository, AntWebClient antWebClient) {
        this.cacheRepository = cacheRepository;
        this.antWebClient = antWebClient;
    }

    public LicenciaDTO obtenerLicencia(String cedula, String placa) {

        Optional<LicenciaCacheEntry> cacheOpt = cacheRepository.find(cedula, placa);

        if (cacheOpt.isPresent()) {
            LicenciaCacheEntry entry = cacheOpt.get();
            LicenciaDTO dto = new LicenciaDTO();
            dto.setCedula(entry.getCedula());
            dto.setPuntos(entry.getPuntos());
            dto.setTieneCitaciones(entry.isTieneCitaciones());
            dto.setUltimaActualizacion(entry.getUltimaActualizacion());
            dto.setMensaje("Datos obtenidos desde caché.");
            return dto;
        }

        try {
            LicenciaDTO desdeAnt = antWebClient.consultarLicencia(cedula, placa);
            desdeAnt.setUltimaActualizacion(LocalDateTime.now());

            LicenciaCacheEntry entry = new LicenciaCacheEntry(
                    cedula,
                    placa,
                    desdeAnt.getPuntos(),
                    desdeAnt.isTieneCitaciones(),
                    desdeAnt.getUltimaActualizacion()
            );
            cacheRepository.save(entry);

            return desdeAnt;

        } catch (Exception ex) {
            LicenciaDTO error = new LicenciaDTO();
            error.setCedula(cedula);
            error.setMensaje("No fue posible obtener información de la ANT y no hay datos en caché.");
            return error;
        }
    }
}

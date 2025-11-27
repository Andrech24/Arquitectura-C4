package com.udla.scisriant.licencia.cache;

import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class LicenciaCacheRepository {

    private final Map<String, LicenciaCacheEntry> cache = new ConcurrentHashMap<>();
    private final Duration ttl = Duration.ofDays(1);

    private String buildKey(String cedula, String placa) {
        return cedula + "|" + placa.toUpperCase();
    }

    public Optional<LicenciaCacheEntry> find(String cedula, String placa) {
        String key = buildKey(cedula, placa);
        LicenciaCacheEntry entry = cache.get(key);
        if (entry == null) {
            return Optional.empty();
        }
        if (entry.getUltimaActualizacion().plus(ttl).isBefore(LocalDateTime.now())) {
            cache.remove(key);
            return Optional.empty();
        }
        return Optional.of(entry);
    }

    public void save(LicenciaCacheEntry entry) {
        String key = buildKey(entry.getCedula(), entry.getPlaca());
        cache.put(key, entry);
    }
}

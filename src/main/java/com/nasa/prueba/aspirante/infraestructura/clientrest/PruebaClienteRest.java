package com.nasa.prueba.aspirante.infraestructura.clientrest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.nasa.prueba.aspirante.dominio.dto.PruebaDto;

@Service
public class PruebaClienteRest {

    private static final Logger logger = LoggerFactory.getLogger(PruebaClienteRest.class);
    private static final String NASA_API_URL = "https://images-api.nasa.gov/search?q=";
    private static final String SEARCH_PARAM = "apollo 11";
    private static final int MAX_RETRIES = 3;

    @Autowired
    private RestTemplate restTemplate;

    public PruebaDto fetchNasaData() {
        String url = NASA_API_URL + SEARCH_PARAM;
        
        for (int attempt = 1; attempt <= MAX_RETRIES; attempt++) {
            try {
                logger.info("Intento {} de obtener datos de NASA API", attempt);
                return restTemplate.getForObject(url, PruebaDto.class);
            } catch (RestClientException e) {
                logger.error("Error al obtener datos de NASA API (intento {}): {}", attempt, e.getMessage());
                
                if (attempt == MAX_RETRIES) {
                    logger.error("Se alcanzó el número máximo de intentos. No se pudieron obtener datos.");
                    throw e;
                }
                
                try {
                    Thread.sleep(1000 * attempt);
                } catch (InterruptedException ie) {
                    Thread.currentThread().interrupt();
                    throw new RuntimeException("Interrupción durante el reintento", ie);
                }
            }
        }
        return null;
    }
}
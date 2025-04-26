package com.nasa.prueba.aspirante.infraestructura.clientrest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.nasa.prueba.aspirante.dominio.dto.PruebaDto;

@Service
public class PruebaClienteRest {

    private static final String NASA_API_URL = "https://images-api.nasa.gov/search?q=";
    private static final String SEARCH_PARAM = "apollo 11";

    @Autowired
    private RestTemplate restTemplate;

    public PruebaDto fetchNasaData() {
        String url = NASA_API_URL + SEARCH_PARAM;
        return restTemplate.getForObject(url, PruebaDto.class);
    }
}
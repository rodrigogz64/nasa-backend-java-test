package com.nasa.prueba.aspirante.infraestructura.restcontroller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nasa.prueba.aspirante.dominio.entities.PruebaEntity;
import com.nasa.prueba.aspirante.infraestructura.repository.PruebaInterfaz;

@RestController
@RequestMapping("/api/nasa/estadisticas")
public class EstadisticasController {

    @Autowired
    private PruebaInterfaz pruebaInterfaz;
    
    @GetMapping
    public ResponseEntity<Map<String, Object>> getEstadisticas() {
        List<PruebaEntity> allData = pruebaInterfaz.findAll();
        
        Map<String, Object> estadisticas = new HashMap<>();
        
        estadisticas.put("totalRegistros", allData.size());
        
        Map<String, Long> conteosPorCentro = allData.stream()
                .collect(Collectors.groupingBy(PruebaEntity::getCenter, Collectors.counting()));
        estadisticas.put("registrosPorCentro", conteosPorCentro);
        
        long titulosUnicos = allData.stream()
                .map(PruebaEntity::getTitle)
                .distinct()
                .count();
        estadisticas.put("titulosUnicos", titulosUnicos);
        
        return ResponseEntity.ok(estadisticas);
    }
}
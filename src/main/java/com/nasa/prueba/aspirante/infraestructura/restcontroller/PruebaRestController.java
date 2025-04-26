package com.nasa.prueba.aspirante.infraestructura.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nasa.prueba.aspirante.dominio.entities.PruebaEntity;
import com.nasa.prueba.aspirante.infraestructura.repository.PruebaInterfaz;

@RestController
@RequestMapping("/api/nasa")
public class PruebaRestController {

    @Autowired
    private PruebaInterfaz pruebaInterfaz;

    @GetMapping
    public ResponseEntity<List<PruebaEntity>> getAllNasaData() {
        // Obtener todos los datos ordenados por ID de forma descendente
        List<PruebaEntity> nasaDataList = pruebaInterfaz.findAll(
            Sort.by(Sort.Direction.DESC, "id")
        );
        
        return ResponseEntity.ok(nasaDataList);
    }
}
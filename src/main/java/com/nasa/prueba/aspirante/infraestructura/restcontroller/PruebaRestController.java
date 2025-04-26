package com.nasa.prueba.aspirante.infraestructura.restcontroller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    
    @GetMapping("/paginado")
    public ResponseEntity<Page<PruebaEntity>> getNasaDataPaginado(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "id"));
        Page<PruebaEntity> nasaDataPage = pruebaInterfaz.findAll(pageable);
        
        return ResponseEntity.ok(nasaDataPage);
    }
    
    @GetMapping("/center/{center}")
    public ResponseEntity<List<PruebaEntity>> getByCenter(@PathVariable String center) {
        List<PruebaEntity> nasaDataList = pruebaInterfaz.findByCenter(center);
        return ResponseEntity.ok(nasaDataList);
    }
    
    @GetMapping("/title")
    public ResponseEntity<List<PruebaEntity>> getByTitle(@RequestParam String title) {
        List<PruebaEntity> nasaDataList = pruebaInterfaz.findByTitleContaining(title);
        return ResponseEntity.ok(nasaDataList);
    }
    
    @GetMapping("/nasaid/{nasaId}")
    public ResponseEntity<List<PruebaEntity>> getByNasaId(@PathVariable String nasaId) {
        List<PruebaEntity> nasaDataList = pruebaInterfaz.findByNasaId(nasaId);
        if (nasaDataList != null && !nasaDataList.isEmpty()) {
            return ResponseEntity.ok(nasaDataList);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @GetMapping("/id/{id}")
    public ResponseEntity<PruebaEntity> getById(@PathVariable Long id) {
        Optional<PruebaEntity> nasaData = pruebaInterfaz.findById(id);
        return nasaData.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
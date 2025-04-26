package com.nasa.prueba.aspirante.infraestructura.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nasa.prueba.aspirante.dominio.entities.PruebaEntity;

@Repository
public interface PruebaInterfaz extends JpaRepository<PruebaEntity, Long> {
    // Filtros personalizados para búsqueda
    List<PruebaEntity> findByCenter(String center);
    List<PruebaEntity> findByTitleContaining(String title);
    List<PruebaEntity> findByNasaId(String nasaId);
    
    //paginación
    Page<PruebaEntity> findByCenter(String center, Pageable pageable);
    Page<PruebaEntity> findByTitleContaining(String title, Pageable pageable);
}
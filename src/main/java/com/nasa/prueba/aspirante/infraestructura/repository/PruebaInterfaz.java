package com.nasa.prueba.aspirante.infraestructura.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nasa.prueba.aspirante.dominio.entities.PruebaEntity;

@Repository
public interface PruebaInterfaz extends JpaRepository<PruebaEntity, Long> {
}
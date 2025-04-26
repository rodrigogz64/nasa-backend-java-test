package com.nasa.prueba.aspirante.aplicacion.taskscheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.nasa.prueba.aspirante.dominio.dto.PruebaDto;
import com.nasa.prueba.aspirante.dominio.entities.PruebaEntity;
import com.nasa.prueba.aspirante.infraestructura.clientrest.PruebaClienteRest;
import com.nasa.prueba.aspirante.infraestructura.repository.PruebaInterfaz;

@Component
public class PruebaTask {

    private static final Logger logger = LoggerFactory.getLogger(PruebaTask.class);

    @Autowired
    private PruebaClienteRest pruebaClienteRest;

    @Autowired
    private PruebaInterfaz pruebaInterfaz;

    @Scheduled(fixedRate = 60000) // Ejecutar cada 1 minuto (60000 ms)
    public void fetchAndSaveNasaData() {
        logger.info("Iniciando tarea programada para obtener datos de NASA API");
        
        try {
            PruebaDto response = pruebaClienteRest.fetchNasaData();
            
            if (response != null && response.getCollection() != null && 
                response.getCollection().getItems() != null) {
                
                for (PruebaDto.Item item : response.getCollection().getItems()) {
                    if (item.getData() != null && !item.getData().isEmpty()) {
                        PruebaDto.Data data = item.getData().get(0); // Obtener solo el primer elemento
                        
                        PruebaEntity pruebaEntity = new PruebaEntity();
                        pruebaEntity.setHref(item.getHref());
                        pruebaEntity.setCenter(data.getCenter());
                        pruebaEntity.setTitle(data.getTitle());
                        pruebaEntity.setNasaId(data.getNasa_id());
                        
                        pruebaInterfaz.save(pruebaEntity);
                        logger.info("Guardado registro de NASA: {}", data.getTitle());
                    }
                }
            }
        } catch (Exception e) {
            logger.error("Error al obtener o guardar datos de NASA API", e);
        }
    }
}
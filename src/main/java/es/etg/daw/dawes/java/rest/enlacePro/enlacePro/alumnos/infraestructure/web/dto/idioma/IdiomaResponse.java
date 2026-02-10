package es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.infraestructure.web.dto.idioma;

import java.time.LocalDateTime;

import io.swagger.v3.oas.annotations.media.Schema;

public record IdiomaResponse(
        @Schema(description = "ID único del idioma", example = "23") 
        int id,
        @Schema(description = "Nombre del idioma", example = "Inglés") 
        String nombre,
        @Schema(description = "Fecha matriculación del idioma", example = "2024-05-20") 
        LocalDateTime createdAt) {
}
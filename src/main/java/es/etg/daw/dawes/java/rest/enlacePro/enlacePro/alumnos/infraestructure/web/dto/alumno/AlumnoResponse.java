package es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.infraestructure.web.dto.alumno;

import java.time.LocalDateTime;

import io.swagger.v3.oas.annotations.media.Schema;

public record AlumnoResponse(

        @Schema(description = "ID único del alumno", example = "23") 
        Integer id,

        @Schema(description = "Nombre del alumno", example = "Marcos") 
        String nombre,

        @Schema(description = "Apellido del alumno", example = "García Moreno") 
        String apellido,

        @Schema(description = "Email del alumno", example = "ejemplo@gmail.com") 
        String email,

        @Schema(description = "Número de télefono del alumno", example = "600123456") 
        String numeroTelefono,

        @Schema(description = "Fecha matriculación del alumno", example = "2024-05-20") 
        LocalDateTime createdAt,

        @Schema(description = "ID del idioma materno", example = "1") 
        int idioma) {
}

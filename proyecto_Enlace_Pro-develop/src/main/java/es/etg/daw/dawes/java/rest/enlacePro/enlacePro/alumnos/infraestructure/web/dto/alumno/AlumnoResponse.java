package es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.infraestructure.web.dto.alumno;

import java.time.LocalDateTime;

public record AlumnoResponse(Integer id, String nombre, String apellidos, String email, String numeroTelefono, LocalDateTime fechaCreacion, int idioma) {
} 

package es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.domain.model;

import java.time.LocalDateTime;

import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.domain.model.id.AlumnoId;
import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.domain.model.id.IdiomaId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Alumno {
    private AlumnoId id;
    private String nombre;
    private String apellidos;
    private String email;
    private String numeroTelefono;
    private LocalDateTime fechaCreacion;
    //FK(FOREIGN KEYS)
    private IdiomaId idiomaId;
}

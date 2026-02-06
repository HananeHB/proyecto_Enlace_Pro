package es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.application.command.alumno;

import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.domain.model.id.IdiomaId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.Accessors;

@Getter
@AllArgsConstructor
@Accessors(fluent = true)
public class CreateAlumnoCommand {
    
    private String nombre;
    private String apellidos;
    private String email;
    private String numeroTelefono;
    private IdiomaId idiomaId;
}

package es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.application.command.alumno;

import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.domain.model.id.AlumnoId;
import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.domain.model.id.IdiomaId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.Accessors;

@Getter
@Builder
@AllArgsConstructor
@Accessors(fluent = true)
public class EditAlumnoCommand {
    private AlumnoId id;
    private String nombre;
    private String apellidos;
    private String email;
    private String numeroTelefono;
    private IdiomaId idiomaId;
}

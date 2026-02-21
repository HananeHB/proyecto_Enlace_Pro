package es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.application.usecase.alumno;

import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.application.command.alumno.EditAlumnoCommand;
import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.domain.error.AlumnoNotFoundException;
import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.domain.model.Alumno;
import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.domain.repository.AlumnoRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class EditarAlumnoUseCase {
    
    private final AlumnoRepository alumnoRepository;

    public Alumno update(EditAlumnoCommand command) {
        return alumnoRepository.getById(command.id())
                .map(a -> {
                    a.setNombre(command.nombre());
                    a.setApellidos(command.apellidos());
                    a.setEmail(command.email());
                    a.setNumeroTelefono(command.numeroTelefono());
                    a.setIdiomaId(command.idiomaId());
                    return alumnoRepository.save(a);})
                .orElseThrow(() -> new AlumnoNotFoundException(command.id().getValue()));
    }
}

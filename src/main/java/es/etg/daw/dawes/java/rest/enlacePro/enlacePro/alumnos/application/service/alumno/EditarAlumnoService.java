package es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.application.service.alumno;

import org.springframework.stereotype.Service;

import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.application.command.alumno.EditAlumnoCommand;
import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.application.usecase.alumno.EditarAlumnoUseCase;
import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.domain.model.Alumno;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class EditarAlumnoService {
    
    private final EditarAlumnoUseCase editAlumnoUseCase;
    
    public Alumno update(EditAlumnoCommand command) {
        return editAlumnoUseCase.update(command);
    }
}

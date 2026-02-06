package es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.application.service.alumno;

import org.springframework.stereotype.Service;

import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.application.command.alumno.CreateAlumnoCommand;
import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.application.usecase.alumno.CreateAlumnoUseCase;
import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.domain.model.Alumno;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CreateAlumnoService {
    
    private final CreateAlumnoUseCase createAlumnoUseCase;

    public Alumno createAlumno(CreateAlumnoCommand command) {
        Alumno alumno = createAlumnoUseCase.create(command);
        return alumno;
    }
}

package es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.application.service.alumno;

import java.util.List;

import org.springframework.stereotype.Service;

import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.application.usecase.alumno.FindAlumnoUseCase;
import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.domain.model.Alumno;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class FindAlumnoService {

    private final FindAlumnoUseCase finAlumnoUseCase;

    public List<Alumno> findAll() {
        return finAlumnoUseCase.findAll();
    }

}

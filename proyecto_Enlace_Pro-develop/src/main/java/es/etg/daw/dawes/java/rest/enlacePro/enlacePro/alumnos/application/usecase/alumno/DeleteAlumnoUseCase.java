package es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.application.usecase.alumno;

import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.domain.model.id.AlumnoId;
import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.domain.repository.AlumnoRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DeleteAlumnoUseCase {
    
    private final AlumnoRepository alumnoRepository;

    public void delete(AlumnoId id) {
        alumnoRepository.deteteById(id);
    }
}

package es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.application.usecase.alumno;

import java.time.LocalDateTime;

import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.application.command.alumno.CreateAlumnoCommand;
import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.domain.model.Alumno;
import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.domain.repository.AlumnoRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CreateAlumnoUseCase {
    
    private final AlumnoRepository alumnoRepository;

    public Alumno create(CreateAlumnoCommand command) {
        
        Alumno alumno = Alumno.builder()
                                .nombre(command.nombre())
                                .apellidos(command.apellidos())
                                .email(command.email())
                                .numeroTelefono(command.numeroTelefono())
                                .idiomaId(command.idiomaId())
                                .fechaCreacion(LocalDateTime.now()).build();
                                
        return alumnoRepository.save(alumno);
    }
}

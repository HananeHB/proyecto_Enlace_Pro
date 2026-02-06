package es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.infraestructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.application.service.alumno.CreateAlumnoService;
import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.application.service.alumno.DeleteAlumnoService;
import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.application.service.alumno.EditarAlumnoService;
import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.application.service.alumno.FindAlumnoService;
import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.application.usecase.alumno.CreateAlumnoUseCase;
import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.application.usecase.alumno.DeleteAlumnoUseCase;
import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.application.usecase.alumno.EditarAlumnoUseCase;
import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.application.usecase.alumno.FindAlumnoUseCase;
import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.domain.repository.AlumnoRepository;
import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.infraestructure.db.jpa.repository.alumno.AlumnoEntityJpaRepository;
import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.infraestructure.db.jpa.repository.alumno.AlumnoJpaRepositoryImpl;
import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class AlumnoConfig {
    
    private final AlumnoEntityJpaRepository alumnoRepository;

    @Bean 
    public AlumnoRepository alumnoRepository(){
        return new AlumnoJpaRepositoryImpl(alumnoRepository);
    }

    @Bean
    public CreateAlumnoUseCase createAlumnoUseCase() {
        return new CreateAlumnoUseCase(alumnoRepository());
    }

    @Bean
    public CreateAlumnoService createAlumnoService() {
        return new CreateAlumnoService(createAlumnoUseCase());
    }

    @Bean
    public FindAlumnoUseCase findAlumnoUseCase() {
        return new FindAlumnoUseCase(alumnoRepository());
    }

    @Bean
    public FindAlumnoService findAlumnoService() {
        return new FindAlumnoService(findAlumnoUseCase());
    }

    @Bean
    public DeleteAlumnoUseCase deleteAlumnoUseCase() {
        return new DeleteAlumnoUseCase(alumnoRepository());
    }

    @Bean
    public DeleteAlumnoService deletAlumnoService() {
        return new DeleteAlumnoService(deleteAlumnoUseCase());
    }

    @Bean
    public EditarAlumnoUseCase editAlumnoUseCase() {
        return new EditarAlumnoUseCase(alumnoRepository());
    }

    @Bean
    public EditarAlumnoService editAlumnoService() {
        return new EditarAlumnoService(editAlumnoUseCase());
    }

    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        return mapper;
    }
}

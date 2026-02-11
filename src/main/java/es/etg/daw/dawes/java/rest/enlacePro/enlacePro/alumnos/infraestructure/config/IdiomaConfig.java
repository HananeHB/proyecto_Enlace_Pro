package es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.infraestructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.application.service.idioma.CreateIdiomaService;
import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.application.service.idioma.DeleteIdiomaService;
import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.application.service.idioma.FindIdiomaService;
import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.application.service.idioma.UpdateIdiomaService;
import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.application.usecase.idioma.CreateIdiomaUseCase;
import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.application.usecase.idioma.DeleteIdiomaUseCase;
import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.application.usecase.idioma.FindIdiomaUseCase;
import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.application.usecase.idioma.UpdateIdiomaUseCase;
import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.domain.repository.IdiomaRepository;
import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.infraestructure.db.jpa.repository.idioma.IdiomaEntityJpaRepository;
import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.infraestructure.db.jpa.repository.idioma.IdiomaJpaRepositoryImpl;
import lombok.RequiredArgsConstructor;


@Configuration
@RequiredArgsConstructor
public class IdiomaConfig {
    
    private final IdiomaEntityJpaRepository idiomaRepository;

    @Bean 
    public IdiomaRepository idiomaRepository(){
        return new IdiomaJpaRepositoryImpl(idiomaRepository);
    }

    @Bean
    public CreateIdiomaUseCase createIdiomaUseCase() {
        return new CreateIdiomaUseCase(idiomaRepository());
    }

    @Bean
    public CreateIdiomaService createIdiomaService(){
        return new CreateIdiomaService(createIdiomaUseCase());
    }

    @Bean
    public FindIdiomaUseCase findIdiomaUseCase(){
        return new FindIdiomaUseCase(idiomaRepository());
    }

    @Bean
    public FindIdiomaService findIdiomaService(){
        return new FindIdiomaService(findIdiomaUseCase());
    }   

    @Bean 
    public DeleteIdiomaUseCase deleteIdiomaUseCase(){
        return new DeleteIdiomaUseCase(idiomaRepository());
    }

    @Bean
    public DeleteIdiomaService deleteIdiomaService(){
        return new DeleteIdiomaService(deleteIdiomaUseCase());
    }

    @Bean 
    public UpdateIdiomaUseCase updateIdiomaUseCase(){
        return new UpdateIdiomaUseCase(idiomaRepository());
    }

    @Bean
    public UpdateIdiomaService updateIdiomaService(){
        return new UpdateIdiomaService(updateIdiomaUseCase());
    }
}

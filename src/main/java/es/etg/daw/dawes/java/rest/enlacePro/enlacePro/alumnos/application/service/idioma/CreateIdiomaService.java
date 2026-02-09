package es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.application.service.idioma;

import org.springframework.stereotype.Service;

import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.application.command.idioma.CreateIdiomaCommand;
import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.application.usecase.idioma.CreateIdiomaUseCase;
import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.domain.model.Idioma;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CreateIdiomaService {
    
    private final CreateIdiomaUseCase createIdiomaUseCase;

    public Idioma createIdioma(CreateIdiomaCommand command) {
        Idioma idioma = createIdiomaUseCase.create(command);
        return idioma;
    }

    public boolean idiomaExiste(String nombre){
        return createIdiomaUseCase.existsByNombre(nombre);
    }
}

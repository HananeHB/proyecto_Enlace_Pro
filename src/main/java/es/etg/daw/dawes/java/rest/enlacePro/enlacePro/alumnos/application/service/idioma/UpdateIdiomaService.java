package es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.application.service.idioma;

import org.springframework.stereotype.Service;

import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.application.command.idioma.UpdateIdiomaCommand;
import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.application.usecase.idioma.UpdateIdiomaUseCase;
import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.domain.model.Idioma;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UpdateIdiomaService {
    private final UpdateIdiomaUseCase updateIdiomaUseCase;
    public Idioma updateIdioma(UpdateIdiomaCommand command){
        return updateIdiomaUseCase.update(command);
    }
}

package es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.application.service.idioma;

import org.springframework.stereotype.Service;

import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.application.command.idioma.EditIdiomaCommand;
import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.application.usecase.idioma.EditIdiomaUseCase;
import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.domain.model.Idioma;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class EditIdiomaService {
    private final EditIdiomaUseCase editIdiomaUseCase;
    
    public Idioma update(EditIdiomaCommand command){
        Idioma idioma= editIdiomaUseCase.update(command);
        return idioma;

    }
}

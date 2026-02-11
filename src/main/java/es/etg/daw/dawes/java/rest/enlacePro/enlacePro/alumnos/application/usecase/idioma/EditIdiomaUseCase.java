package es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.application.usecase.idioma;

import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.application.command.idioma.EditIdiomaCommand;
import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.domain.error.IdiomaNotFoundException;
import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.domain.model.Idioma;
import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.domain.repository.IdiomaRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class EditIdiomaUseCase {
    private final IdiomaRepository idiomaRepository;

    public Idioma update(EditIdiomaCommand command){
        Idioma idioma = idiomaRepository.getById(command.id())
                        .orElseThrow(() -> new IdiomaNotFoundException(command.id().getValue()));
        
        idioma.setNombre(command.nombre());
        return idiomaRepository.save(idioma);
    }
}

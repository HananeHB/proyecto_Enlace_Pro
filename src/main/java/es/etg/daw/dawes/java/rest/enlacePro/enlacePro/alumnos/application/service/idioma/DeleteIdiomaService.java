package es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.application.service.idioma;

import org.springframework.stereotype.Service;

import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.application.command.idioma.DeleteIdiomaCommand;
import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.application.usecase.idioma.DeleteIdiomaUseCase;
import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.domain.model.id.IdiomaId;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class DeleteIdiomaService {
    private final DeleteIdiomaUseCase deleteIdiomaUseCase;

    public void deleteIdioma(IdiomaId id){
        deleteIdiomaUseCase.delete(new DeleteIdiomaCommand(id));
    }
}

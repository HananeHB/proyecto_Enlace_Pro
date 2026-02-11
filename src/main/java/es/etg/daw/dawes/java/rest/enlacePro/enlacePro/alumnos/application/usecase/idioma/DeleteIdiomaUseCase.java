package es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.application.usecase.idioma;

import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.application.command.idioma.DeleteIdiomaCommand;
import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.domain.repository.IdiomaRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DeleteIdiomaUseCase {
    private final IdiomaRepository idiomaRepository;

    public void delete(DeleteIdiomaCommand command){
        idiomaRepository.deleteById(command.id());
    }
}

package es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.application.usecase.idioma;

import java.util.Optional;

import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.domain.error.IdiomaNotFoundException;
import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.domain.model.Idioma;
import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.domain.model.id.IdiomaId;
import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.domain.repository.IdiomaRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DeleteIdiomaUseCase {
    private final IdiomaRepository idiomaRepository;

    public void delete(IdiomaId id){
        Optional<Idioma> idiomaOptional = idiomaRepository.getById(id);
        if(!idiomaOptional.isPresent()){
            throw new IdiomaNotFoundException(id.getValue());
        }
        idiomaRepository.deleteById(id);
    }
}

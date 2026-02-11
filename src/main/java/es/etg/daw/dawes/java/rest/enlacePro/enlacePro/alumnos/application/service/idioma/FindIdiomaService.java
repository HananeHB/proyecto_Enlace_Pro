package es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.application.service.idioma;

import java.util.List;
import java.util.Optional;

import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.application.usecase.idioma.FindIdiomaUseCase;
import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.domain.model.Idioma;
import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.domain.model.id.IdiomaId;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FindIdiomaService {
    private final FindIdiomaUseCase findIdiomaUseCase;

    public List<Idioma> findAll() {
        return findIdiomaUseCase.findAll();
    }

    public Optional<Idioma> findById(IdiomaId id){
        return findIdiomaUseCase.findById(id);
    }
}

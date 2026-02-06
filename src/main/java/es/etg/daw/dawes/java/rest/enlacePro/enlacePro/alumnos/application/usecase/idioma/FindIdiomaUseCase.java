package es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.application.usecase.idioma;

import java.util.List;

import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.domain.error.IdiomaNotFoundException;
import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.domain.model.Idioma;
import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.domain.repository.IdiomaRepository;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class FindIdiomaUseCase {

    private final IdiomaRepository idiomaRepository;

    public List<Idioma> findAll() {
        List<Idioma> idiomas = idiomaRepository.getAll();

        if (idiomas.isEmpty())
            throw new IdiomaNotFoundException();

        return idiomas;
    }
}

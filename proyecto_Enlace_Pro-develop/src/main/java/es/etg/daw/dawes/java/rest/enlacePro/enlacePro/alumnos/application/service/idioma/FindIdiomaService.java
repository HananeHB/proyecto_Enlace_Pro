package es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.application.service.idioma;

import java.util.List;

import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.application.usecase.idioma.FindIdiomaUseCase;
import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.domain.model.Idioma;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FindIdiomaService {
    private final FindIdiomaUseCase findIdiomaUseCase;

    public List<Idioma> findAll() {
        return findIdiomaUseCase.findAll();
    }
}

package es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.application.usecase.idioma;

import java.time.LocalDateTime;

import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.application.command.idioma.CreateIdiomaCommand;
import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.domain.model.Idioma;
import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.domain.repository.IdiomaRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateIdiomaUseCase {

    private final IdiomaRepository idiomaRepository;

    public Idioma create(CreateIdiomaCommand command) {

        Idioma idioma = Idioma.builder()
                .nombre(command.nombre())
                .fechaCreacion(LocalDateTime.now())
                .build();

        return idiomaRepository.save(idioma);
    }

    public boolean existsByNombre(String nombre) {
        return idiomaRepository.getAll()
                .stream()
                .anyMatch(i -> i.getNombre().equalsIgnoreCase(nombre.trim()));
    }

}

package es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.infraestructure.web.rest;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.domain.model.Idioma;
import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.domain.model.id.IdiomaId;
import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.domain.repository.IdiomaRepository;
import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.infraestructure.db.repository.mock.idioma.IdiomaFactory;
import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.infraestructure.db.repository.mock.idioma.IdiomaRepositoryMockImpl;

public class IdiomaControllerIT {
    
    IdiomaRepository repository = new IdiomaRepositoryMockImpl();

    @BeforeEach
    void setUp() {
        // Inicializamos las el repositorio
        repository = new IdiomaRepositoryMockImpl();

    }

    @Test
    void save() {
        var idioms = IdiomaFactory.create();

        Idioma i = repository.save(idioms);

        assertAll(
                () -> assertNotNull(i), // categoria no es nulo
                () -> assertNotNull(i.getId()), // categoria creado tiene id
                () -> assertNotNull(repository.getById(i.getId())) // si lo busco lo debo recuperar *opcional
        );

    }

    @Test
    void getAll() {
        var idiomas = repository.getAll();

        assertAll(
                () -> assertNotNull(idiomas),
                () -> assertEquals(IdiomaFactory.getDemoData().size(), idiomas.size()));
    }

    @Test
    void getById() {
        int idEsperado = 1;
        var idioma = repository.getById(new IdiomaId(idEsperado));

        assertAll(
                () -> assertNotNull(idioma),
                () -> assertEquals(idEsperado, idioma.get().getId().getValue()));

    }

    @Test
    void deleteById() {
        int idEsperado = 1;
        repository.deteteById(new IdiomaId(idEsperado));
        var idioma = repository.getById(new IdiomaId(idEsperado));

        assertAll(
                () -> assertNotNull(idioma),
                () -> assertEquals(false, idioma.isPresent()));

    }
}

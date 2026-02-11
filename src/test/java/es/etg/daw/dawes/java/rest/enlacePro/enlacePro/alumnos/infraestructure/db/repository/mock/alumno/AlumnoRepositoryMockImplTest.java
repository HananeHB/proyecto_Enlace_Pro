package es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.infraestructure.db.repository.mock.alumno;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.domain.model.Alumno;
import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.domain.model.id.AlumnoId;
import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.domain.repository.AlumnoRepository;

public class AlumnoRepositoryMockImplTest {
    
    AlumnoRepository repository = new AlumnoRepositoryMockImpl();

    @BeforeEach
    void setUp() {
        // Inicializamos las el repositorio
        repository = new AlumnoRepositoryMockImpl();

    }

    @Test
    void save() {
        var alumno = AlumnoFactory.create();

        Alumno a = repository.save(alumno);

        assertAll(
                () -> assertNotNull(a), // el producto no es nulo
                () -> assertNotNull(a.getId()), // el producto creado tiene id
                () -> assertNotNull(repository.getById(a.getId())) // si lo busco lo debo recuperar *opcional
        );

    }

    @Test
    void getAll() {
        var alumno = repository.getAll();

        assertAll(
                () -> assertNotNull(alumno),
                () -> assertEquals(AlumnoFactory.getDemoData().size(), alumno.size()));
    }

    @Test
    void getById() {
        int idEsperado = 1;
        var alumno = repository.getById(new AlumnoId(idEsperado));

        assertAll(
                () -> assertNotNull(alumno),
                () -> assertEquals(idEsperado, alumno.get().getId().getValue()));

    }

    @Test
    void deleteById() {
        int idEsperado = 1;
        repository.deleteById(new AlumnoId(idEsperado));
        var alumno = repository.getById(new AlumnoId(idEsperado));

        assertAll(
                () -> assertNotNull(alumno),
                () -> assertEquals(false, alumno.isPresent()));

    }
}

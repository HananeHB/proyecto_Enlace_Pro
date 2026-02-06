package es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.infraestructure.db.jpa.repository;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.infraestructure.db.jpa.repository.alumno.AlumnoEntityJpaRepository;
import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.infraestructure.db.repository.mock.alumno.AlumnoFactory;
import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.infraestructure.mapper.AlumnoMapper;

@DataJpaTest(showSql = true)
public class AlumnoEntityJpaRepositoryTest {
    
    @Autowired
    private AlumnoEntityJpaRepository repository;




    @Test
    @Order(1)
    void findAll() {

        var alumnos = repository.findAll();


        assertAll(
                () -> assertNotNull(alumnos),
                () -> assertTrue(!alumnos.isEmpty())
        );
    }

    @Test
    @Order(2)
    void findById(){
        update(); // Actualizo y recupero el dato controlado
        var p = AlumnoFactory.create(); //Producto cambiado antes, vamos a ve rsi está bien

        var alumnos = repository.findById(p.getId().getValue()).get();

        assertAll(
            () -> assertNotNull(alumnos),
            () -> assertEquals(alumnos.getId(), p.getId().getValue()),
            () -> assertEquals(alumnos.getNombre(), p.getNombre())
        );
    }


    @Test
    @Order(3)
    void findByName(){
        update(); // Actualizo y recupero el dato controlado
        var p = AlumnoFactory.create(); //Producto cambiado antes, vamos a ve rsi está bien

        var alumnos = repository.findByNombre(p.getNombre());

        assertAll(
            () -> assertNotNull(alumnos),
            () -> assertEquals(alumnos.getId(), p.getId().getValue()),
            () -> assertEquals(alumnos.getNombre(), p.getNombre())
        );
    }    

    @Test
    @Order(5)
    void create(){
        var nuevo = AlumnoMapper.toEntity(AlumnoFactory.create());
        nuevo.setId(null);
        var alumno = repository.save(nuevo);

                assertAll(
                () -> assertNotNull(alumno),
                () -> assertTrue(alumno.getId()!=null)
        );
    }

    @Test
    @Order(10)
    void update(){
        var nuevo = AlumnoMapper.toEntity(AlumnoFactory.create());
        var alumno = repository.save(nuevo);

                assertAll(
                () -> assertNotNull(alumno),
                () -> assertTrue(alumno.getId()!=null)
        );
    }


    @Test
    @Order(15)
    void delete(){
        var alumno = repository.findById(1); 
        repository.delete(alumno.get());

        var alumnoEliminado = repository.findById(1).isEmpty();
        assertAll(
            () -> assertTrue(alumnoEliminado)
        );
    }
}

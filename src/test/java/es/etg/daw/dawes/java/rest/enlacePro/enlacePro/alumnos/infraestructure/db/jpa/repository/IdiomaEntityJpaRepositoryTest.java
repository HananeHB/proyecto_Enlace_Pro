package es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.infraestructure.db.jpa.repository;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.infraestructure.db.jpa.repository.idioma.IdiomaEntityJpaRepository;
import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.infraestructure.db.repository.mock.idioma.IdiomaFactory;
import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.infraestructure.mapper.IdiomaMapper;
import jakarta.transaction.Transactional;

@Testcontainers
@SpringBootTest
@Transactional
@TestMethodOrder(MethodOrderer.OrderAnnotation.class) // Permite que los tests sigan el orden de @Order
public class IdiomaEntityJpaRepositoryTest {
    
    // Definición del contenedor de MySQL (se levanta una vez para toda la clase)
    @Container
    @ServiceConnection
    static MySQLContainer<?> mysql = new MySQLContainer<>("mysql:8.0");
    

    @Autowired
    private IdiomaEntityJpaRepository repository;

    @Test
    @Order(1)
    void findAll() {

        var idiomas = repository.findAll();


        assertAll(
                () -> assertNotNull(idiomas),
                () -> assertTrue(!idiomas.isEmpty())
        );
    }

    @Test
    @Order(2)
    void findById(){
        update(); // Actualizo y recupero el dato controlado
        var i = IdiomaFactory.create(); //Categoria actualizado antes, vamos a ve rsi está bien

        var idioma = repository.findById(i.getId().getValue()).get();

        assertAll(
            () -> assertNotNull(idioma),
            () -> assertEquals(idioma.getId(), i.getId().getValue()),
            () -> assertEquals(idioma.getNombre(), i.getNombre())
        );
    }


    

    @Test
    @Order(5)
    void create(){
        var nuevo = IdiomaMapper.toEntity(IdiomaFactory.create());
        nuevo.setId(null);
        var idioma = repository.save(nuevo);

        assertAll(
            () -> assertNotNull(idioma),
            () -> assertTrue(idioma.getId()!=null)
            );
    }

    @Test
    @Order(10)
    void update(){
        var nuevo = IdiomaMapper.toEntity(IdiomaFactory.create());
        var alumno = repository.save(nuevo);

                assertAll(
                () -> assertNotNull(alumno),
                () -> assertTrue(alumno.getId()!=null)
        );
    }


    @Test
    @Order(15)
    void delete(){
        var idioma = repository.findById(1); 
        repository.delete(idioma.get());

        var catEliminada = repository.findById(1).isEmpty();
        assertAll(
            () -> assertTrue(catEliminada)
        );
    }
}

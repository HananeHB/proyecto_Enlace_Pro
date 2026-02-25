package es.etg.daw.dawes.java.rest.enlacePro.enlacePro;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;

@SpringBootTest
class EnlaceProApplicationTests {

	// Definición del contenedor de MySQL (se levanta una vez para toda la clase)
    @Container
    @ServiceConnection
    static MySQLContainer<?> mysql = new MySQLContainer<>("mysql:8.0");
    
	@Test
	void contextLoads() {
	}

}

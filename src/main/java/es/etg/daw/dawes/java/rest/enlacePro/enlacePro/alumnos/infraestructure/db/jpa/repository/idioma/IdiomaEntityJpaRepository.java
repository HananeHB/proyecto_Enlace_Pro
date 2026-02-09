package es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.infraestructure.db.jpa.repository.idioma;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.infraestructure.db.jpa.entity.IdiomaEntity;

@Repository
public interface IdiomaEntityJpaRepository extends JpaRepository<IdiomaEntity, Integer>{
    boolean existsByNombreIgnoreCase(String nombre);
} 

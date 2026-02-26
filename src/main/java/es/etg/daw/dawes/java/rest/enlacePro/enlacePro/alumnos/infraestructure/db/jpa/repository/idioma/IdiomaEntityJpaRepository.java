package es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.infraestructure.db.jpa.repository.idioma;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.infraestructure.db.jpa.entity.IdiomaEntity;

@Repository
public interface IdiomaEntityJpaRepository extends JpaRepository<IdiomaEntity, Integer> {
    boolean existsByNombreIgnoreCase(String nombre);

    /*
    * Se carga la lista "alumnos" junto con IdiomaEntity porque,
    * al mapear la entidad a dominio, se accede a esa colección.
    * Como es LAZY, si no se trae en la consulta provoca
    * LazyInitializationException.
    */
    @EntityGraph(attributePaths = "alumnos")
    @Query("SELECT i FROM IdiomaEntity i")
    List<IdiomaEntity> findAllWithAlumnos();
}

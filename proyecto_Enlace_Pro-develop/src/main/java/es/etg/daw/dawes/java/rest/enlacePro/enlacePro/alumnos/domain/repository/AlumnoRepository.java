package es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.domain.repository;

import java.util.Optional;

import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.domain.model.Alumno;
import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.domain.model.id.AlumnoId;
import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.common.domain.repository.CRUDRepository;

public interface AlumnoRepository extends CRUDRepository<Alumno, AlumnoId> {

     public Optional<Alumno> getByName(String name);
}

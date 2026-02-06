package es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.infraestructure.db.repository.mock.alumno;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.domain.model.Alumno;
import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.domain.model.id.AlumnoId;
import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.domain.model.id.IdiomaId;

public class AlumnoFactory {
    
    public static final Map<AlumnoId, Alumno> getDemoData() {
        Map<AlumnoId, Alumno> datos = new LinkedHashMap<>();

        datos.put(new AlumnoId(1), new Alumno(new AlumnoId(1), "Juan", "Pérez", "juanPerez@gmail.com", "600000000", LocalDateTime.now(), new IdiomaId(1)));
        datos.put(new AlumnoId(2), new Alumno(new AlumnoId(1), "Lidia", "Hernández", "lidiaHernandez@gmail.com", "612345678", LocalDateTime.now(), new IdiomaId(2)));
        datos.put(new AlumnoId(3), new Alumno(new AlumnoId(1), "Lucía", "Díaz", "luciaDiaz@gmail.com", "698765432", LocalDateTime.now(), new IdiomaId(2)));
        datos.put(new AlumnoId(4), new Alumno(new AlumnoId(1), "Mario", "García", "marioGarcia@gmail.com", "629538761", LocalDateTime.now(), new IdiomaId(1)));

        return datos;
    }

    public static Alumno create() {
        return new Alumno(new AlumnoId(1), "alumnoPrueba", "apellidoPrueba", "correoPrueba@gmail.com", "612345678", LocalDateTime.now(), new IdiomaId(1));
    }
}

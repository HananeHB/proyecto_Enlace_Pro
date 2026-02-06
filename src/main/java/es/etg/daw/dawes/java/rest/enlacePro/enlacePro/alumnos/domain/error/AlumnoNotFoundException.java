package es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.domain.error;

import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.common.domain.error.EntityNotFoundException;

public class AlumnoNotFoundException extends EntityNotFoundException {

    private static final String ENTIDAD = "alumno";

    public AlumnoNotFoundException() {
        super(ENTIDAD);
    }

    public AlumnoNotFoundException(int id) {
        super(ENTIDAD, id);
    }
    
}

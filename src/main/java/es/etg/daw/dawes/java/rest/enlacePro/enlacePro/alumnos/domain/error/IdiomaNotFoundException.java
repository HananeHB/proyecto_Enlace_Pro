package es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.domain.error;

import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.common.domain.error.EntityNotFoundException;

public class IdiomaNotFoundException extends EntityNotFoundException {

    private static final String ENTIDAD = "idioma";

    public IdiomaNotFoundException() {
        super(ENTIDAD);
    }

    public IdiomaNotFoundException(int id) {
        super(ENTIDAD, id);
    }

    
}

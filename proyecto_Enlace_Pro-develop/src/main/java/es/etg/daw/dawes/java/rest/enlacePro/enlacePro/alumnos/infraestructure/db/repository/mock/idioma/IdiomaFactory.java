package es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.infraestructure.db.repository.mock.idioma;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.domain.model.Idioma;
import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.domain.model.id.IdiomaId;

public class IdiomaFactory {
    
    public static final Map<IdiomaId, Idioma> getDemoData(){

        Map<IdiomaId, Idioma> datos = new LinkedHashMap<>();

        datos.put(new IdiomaId(1), new Idioma(new IdiomaId(1), "Idioma 1", LocalDateTime.now()));
        datos.put(new IdiomaId(2), new Idioma(new IdiomaId(1), "Idioma 2", LocalDateTime.now()));
        return datos;
    }

    public static final Idioma create(){
        return new Idioma(new IdiomaId(1), "idiomaPrueba", LocalDateTime.now());
    }
}

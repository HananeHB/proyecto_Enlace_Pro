package es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.infraestructure.db.repository.mock.idioma;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.domain.model.Idioma;
import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.domain.model.id.IdiomaId;
import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.domain.repository.IdiomaRepository;

@Repository
public class IdiomaRepositoryMockImpl  implements IdiomaRepository{

    private final Map<IdiomaId, Idioma> idiomas = IdiomaFactory.getDemoData();

    @Override
    public Idioma save(Idioma t) {
        if (t.getId() == null)
            t.setId(new IdiomaId(obtenerSiguienteId()));

        idiomas.put(t.getId(), t);
        return t;
    }

    private int obtenerSiguienteId() {
        IdiomaId ultimo = null;
        if (!idiomas.isEmpty()) {
            Collection<Idioma> lista = idiomas.values();

            for (Idioma c : lista) {
                ultimo = c.getId();
            }

        }
        return ultimo.getValue() + 1;
    }

    @Override
    public List<Idioma> getAll() {
        return new ArrayList<>(idiomas.values());
    }

    @Override
    public Optional<Idioma> getById(IdiomaId id) {
        return Optional.ofNullable(idiomas.get(id));
    }

    @Override
    public void deleteById(IdiomaId id) {
        idiomas.remove(id);
    }
    
    
}

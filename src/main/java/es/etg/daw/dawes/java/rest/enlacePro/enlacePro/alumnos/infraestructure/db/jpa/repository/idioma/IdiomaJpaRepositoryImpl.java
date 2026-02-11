package es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.infraestructure.db.jpa.repository.idioma;

import java.util.List;
import java.util.Optional;

import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.domain.model.Idioma;
import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.domain.model.id.IdiomaId;
import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.domain.repository.IdiomaRepository;
import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.infraestructure.db.jpa.entity.IdiomaEntity;
import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.infraestructure.mapper.IdiomaMapper;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class IdiomaJpaRepositoryImpl implements IdiomaRepository {

    private final IdiomaEntityJpaRepository repository;

    @Override
    public Idioma save(Idioma t) {
        IdiomaEntity idioma = IdiomaMapper.toEntity(t);
        return IdiomaMapper.toDomain(repository.save(idioma));
    }

    @Override
    public List<Idioma> getAll() {
        return IdiomaMapper.toDomain(repository.findAll());
    }

    @Override
    public Optional<Idioma> getById(IdiomaId id) {
        Optional<Idioma> idiomas = null;
        Optional<IdiomaEntity> idio = repository.findById(id.getValue());

        if (idio.isEmpty()) {
            idiomas = Optional.empty();
        } else {
            idiomas = Optional.of(IdiomaMapper.toDomain(idio.get()));
        }

        return idiomas;
    }

    @Override
    public void deleteById(IdiomaId id) {
        repository.deleteById(id.getValue());
    }

}

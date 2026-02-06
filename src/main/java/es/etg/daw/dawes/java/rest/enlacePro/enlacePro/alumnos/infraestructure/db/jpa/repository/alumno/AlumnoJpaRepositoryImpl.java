package es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.infraestructure.db.jpa.repository.alumno;

import java.util.List;
import java.util.Optional;

import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.domain.model.Alumno;
import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.domain.model.id.AlumnoId;
import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.domain.repository.AlumnoRepository;
import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.infraestructure.db.jpa.entity.AlumnoEntity;
import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.infraestructure.mapper.AlumnoMapper;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AlumnoJpaRepositoryImpl implements AlumnoRepository {

    private final AlumnoEntityJpaRepository repository;

    @Override
    public Alumno save(Alumno a) {

        AlumnoEntity alumno = AlumnoMapper.toEntity(a);
        return AlumnoMapper.toDomain(repository.save(alumno));
    }

    @Override
    public List<Alumno> getAll() {
        return AlumnoMapper.toDomain(repository.findAll());
    }

    @Override
    public Optional<Alumno> getById(AlumnoId id) {
        Optional<Alumno> alumnos = null;
        Optional<AlumnoEntity> al = repository.findById(id.getValue());

        if (al.isEmpty()) {
            alumnos = Optional.empty();
        } else {
            alumnos = Optional.of(AlumnoMapper.toDomain(al.get()));
        }

        return alumnos;
    }

    @Override
    public void deteteById(AlumnoId id) {
        repository.deleteById(id.getValue());
    }

    @Override
    public Optional<Alumno> getByName(String name) {
        AlumnoEntity prod = repository.findByNombre(name);
        if (prod != null)
            return Optional.of(AlumnoMapper.toDomain(prod));
        else
            return Optional.empty();
    }
}

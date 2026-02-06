package es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.infraestructure.db.repository.mock.alumno;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.domain.model.Alumno;
import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.domain.model.id.AlumnoId;
import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.domain.repository.AlumnoRepository;

@Repository
public class AlumnoRepositoryMockImpl implements AlumnoRepository{
    
    public final Map<AlumnoId, Alumno> alumnos = AlumnoFactory.getDemoData();

    @Override
    public Alumno save(Alumno a) {
        if(a.getId()==null) a.setId(new AlumnoId(obtenerSiguienteId()));

        alumnos.put(a.getId(), a);
        return a;
    }

    private int obtenerSiguienteId(){
        AlumnoId ultimo = null;
        if(!alumnos.isEmpty()){
            Collection<Alumno> lista = alumnos.values();
            
            for (Alumno p : lista) {
                ultimo = p.getId();
            }

        }
        return ultimo.getValue()+1;
    }

    @Override
    public List<Alumno> getAll() {
        return new ArrayList<>(alumnos.values());
    }

    @Override
    public Optional<Alumno> getById(AlumnoId id) {
        return Optional.ofNullable(alumnos.get(id));
    }

    @Override
    public void deteteById(AlumnoId id) {
        alumnos.remove(id);
    }

    @Override
    public Optional<Alumno> getByName(String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getByName'");
    }
}

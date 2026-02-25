package es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.infraestructure.mapper;

import java.util.ArrayList;
import java.util.List;

import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.application.command.alumno.CreateAlumnoCommand;
import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.application.command.alumno.EditAlumnoCommand;
import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.domain.model.Alumno;
import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.domain.model.id.AlumnoId;
import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.domain.model.id.IdiomaId;
import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.infraestructure.db.jpa.entity.AlumnoEntity;
import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.infraestructure.db.jpa.entity.IdiomaEntity;
import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.infraestructure.web.dto.alumno.AlumnoRequest;
import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.infraestructure.web.dto.alumno.AlumnoResponse;

public class AlumnoMapper {
    
    public static CreateAlumnoCommand toCommand(AlumnoRequest alumnoRequest) {
        return new CreateAlumnoCommand(alumnoRequest.nombre(), alumnoRequest.apellido(), alumnoRequest.email(), alumnoRequest.numeroTelefono(),
                new IdiomaId(alumnoRequest.idioma()));
    }

    public static AlumnoResponse toResponse(Alumno a) {
        return new AlumnoResponse(a.getId().getValue(),
                a.getNombre(),
                a.getApellidos(),
                a.getEmail(),
                a.getNumeroTelefono(),
                a.getFechaCreacion(),
                a.getIdiomaId().getValue());
    }

    public static EditAlumnoCommand toCommand(int id, AlumnoRequest alumnoRequest) {
        return new EditAlumnoCommand(new AlumnoId(id), alumnoRequest.nombre(), alumnoRequest.apellido(), alumnoRequest.email(), alumnoRequest.numeroTelefono(), new IdiomaId(alumnoRequest.idioma()));
    }

    public static AlumnoEntity toEntity(Alumno a) {
        
        IdiomaEntity idioma = new IdiomaEntity();
        idioma.setId(a.getIdiomaId().getValue());
        AlumnoId id = a.getId();

        return AlumnoEntity.builder().id(id != null ? id.getValue() : null)
                .nombre(a.getNombre())
                .apellido(a.getApellidos())
                .email(a.getEmail())
                .numeroTelefono(a.getNumeroTelefono())
                .fechaCreacion(a.getFechaCreacion())
                .idioma(idioma)
                .build();
    }

    public static Alumno toDomain(AlumnoEntity a) {
        return Alumno.builder().id(new AlumnoId(a.getId()))
                .nombre(a.getNombre())
                .apellidos(a.getApellido())
                .email(a.getEmail())
                .numeroTelefono(a.getNumeroTelefono())
                .fechaCreacion(a.getFechaCreacion())
                .idiomaId(new IdiomaId(a.getIdioma().getId()))
                .build();
    }

    public static List<Alumno> toDomain(List<AlumnoEntity> lista) {
        List<Alumno> al = new ArrayList<>();
        for (AlumnoEntity alumno : lista) {
            al.add(toDomain(alumno));
        }

        return al;
    }

    public static List<Alumno> toDomainResponse(List<AlumnoResponse> lista){
        List<Alumno> lp = new ArrayList<>();
        for(AlumnoResponse pe: lista){
            lp.add(toDomain(pe));
        }
        return lp;
    }

    public static AlumnoRequest toRequest(Alumno t) {
        return new AlumnoRequest(t.getNombre(), t.getApellidos(), t.getEmail(), t.getNumeroTelefono(), t.getIdiomaId().getValue());
        
    }

    public static Alumno toDomain(AlumnoResponse a){
        return new Alumno(new AlumnoId(a.id()), a.nombre(), a.apellido(), a.email(), a.numeroTelefono(), a.createdAt(), new IdiomaId(a.idioma()));
    }

    
}

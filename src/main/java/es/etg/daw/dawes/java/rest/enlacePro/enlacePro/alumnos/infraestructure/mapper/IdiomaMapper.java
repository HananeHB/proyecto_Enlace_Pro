package es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.infraestructure.mapper;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.application.command.idioma.CreateIdiomaCommand;
import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.application.command.idioma.EditIdiomaCommand;
import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.domain.model.Idioma;
import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.domain.model.id.IdiomaId;
import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.infraestructure.db.jpa.entity.AlumnoEntity;
import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.infraestructure.db.jpa.entity.IdiomaEntity;
import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.infraestructure.web.dto.idioma.IdiomaRequest;
import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.infraestructure.web.dto.idioma.IdiomaResponse;

public class IdiomaMapper {

    public static CreateIdiomaCommand toCommand(
            es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.infraestructure.web.dto.idioma.IdiomaRequest idiomaRequest) {
        return new CreateIdiomaCommand(idiomaRequest.nombre());
    }

    public static IdiomaResponse toResponse(Idioma idioma) {
        return new IdiomaResponse(idioma.getId().getValue(),
                idioma.getNombre(),
                idioma.getFechaCreacion());
    }

    public static IdiomaEntity toEntity(Idioma i) {
        // 1. Mapeamos los campos básicos
        IdiomaEntity entity = IdiomaEntity.builder()
                .id(i.getId() != null ? i.getId().getValue() : null)
                .nombre(i.getNombre())
                .fechaCreacion(i.getFechaCreacion() != null ? i.getFechaCreacion() : LocalDateTime.now())
                .build();

        // 2. Mapeamos la lista de alumnos (complicándonos un poco)
        if (i.getAlumnos() != null) {
            List<AlumnoEntity> alumnosEntities = i.getAlumnos().stream()
                    .map(alumnoDominio -> AlumnoMapper.toEntity(alumnoDominio)) // Necesitas este mapper
                    .toList();

            // 3. ¡IMPORTANTE! Mantener la consistencia bidireccional
            // Usamos el método addAlumno que tienes en tu entidad para que el AlumnoEntity
            // sepa quién es su IdiomaEntity (el famoso .setIdioma(this))
            alumnosEntities.forEach(entity::addAlumno);
        }

        return entity;
    }

    public static Idioma toDomain(IdiomaEntity i) {
        return Idioma.builder().id(new IdiomaId(i.getId()))
                .nombre(i.getNombre())
                .fechaCreacion(LocalDateTime.now())
                .alumnos(i.getAlumnos() != null ? AlumnoMapper.toDomain(i.getAlumnos()) : new ArrayList<>())
                .build();
    }

    public static List<Idioma> toDomain(List<IdiomaEntity> lista) {
        List<Idioma> i = new ArrayList<>();
        for (IdiomaEntity idioma : lista) {
            i.add(toDomain(idioma));
        }
        return i;
    }

    public static EditIdiomaCommand toCommand(int id, IdiomaRequest idiomaRequest) {
        return new EditIdiomaCommand(new IdiomaId(id), idiomaRequest.nombre());
    }
}

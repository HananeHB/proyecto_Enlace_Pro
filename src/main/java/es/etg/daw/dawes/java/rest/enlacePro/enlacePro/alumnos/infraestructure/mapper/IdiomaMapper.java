package es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.infraestructure.mapper;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.application.command.idioma.CreateIdiomaCommand;
import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.application.command.idioma.EditIdiomaCommand;
import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.domain.model.Idioma;
import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.domain.model.id.IdiomaId;
import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.infraestructure.db.jpa.entity.IdiomaEntity;
import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.infraestructure.web.dto.idioma.IdiomaRequest;
import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.infraestructure.web.dto.idioma.IdiomaResponse;

public class IdiomaMapper {
    
    public static CreateIdiomaCommand toCommand(es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.infraestructure.web.dto.idioma.IdiomaRequest idiomaRequest) {
        return new CreateIdiomaCommand(idiomaRequest.nombre());
    }

    public static IdiomaResponse toResponse(Idioma idioma) {
        return new IdiomaResponse(idioma.getId().getValue(),
                idioma.getNombre(),
                idioma.getFechaCreacion());
    }

    public static IdiomaEntity toEntity(Idioma i) {

        IdiomaId id = i.getId();
        return IdiomaEntity.builder().id(id != null ? id.getValue() : null)
                .nombre(i.getNombre())
                .fechaCreacion(LocalDateTime.now())
                .build();
    }

    public static Idioma toDomain(IdiomaEntity i) {
        return Idioma.builder().id(new IdiomaId(i.getId()))
                .nombre(i.getNombre())
                .fechaCreacion(LocalDateTime.now())
                .build();
    }

    public static List<Idioma> toDomain(List<IdiomaEntity> lista) {
        List<Idioma> i = new ArrayList<>();
        for (IdiomaEntity idioma : lista) {
            i.add(toDomain(idioma));
        }
        return i;
    }

    public static EditIdiomaCommand toCommand(IdiomaId id, IdiomaRequest idiomaRequest){
        return new EditIdiomaCommand(id, idiomaRequest.nombre());
    }
}

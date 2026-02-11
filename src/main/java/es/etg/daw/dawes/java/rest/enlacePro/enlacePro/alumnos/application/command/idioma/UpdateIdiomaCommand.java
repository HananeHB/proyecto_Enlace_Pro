package es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.application.command.idioma;

import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.domain.model.id.IdiomaId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.Accessors;

@Getter
@AllArgsConstructor
@Accessors(fluent = true)
public class UpdateIdiomaCommand {
    private final IdiomaId id;
    private final String nombre;//solo se permite actualizar el nombre
}

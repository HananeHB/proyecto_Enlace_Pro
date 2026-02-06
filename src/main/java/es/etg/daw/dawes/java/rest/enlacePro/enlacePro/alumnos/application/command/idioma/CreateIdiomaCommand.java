package es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.application.command.idioma;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.Accessors;

@Getter
@AllArgsConstructor
@Accessors(fluent = true)
public class CreateIdiomaCommand {
    
    private String nombre;
}

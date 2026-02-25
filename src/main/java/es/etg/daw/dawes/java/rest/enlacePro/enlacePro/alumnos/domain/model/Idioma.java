package es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.domain.model;

import java.time.LocalDateTime;
import java.util.List;

import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.domain.model.id.IdiomaId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Idioma {
    private IdiomaId id;
    private String nombre;
    private LocalDateTime fechaCreacion;
    private List<Alumno> alumnos;
}

package es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.infraestructure.web.dto.idioma;

import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.domain.model.Idioma;
import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.infraestructure.web.validation.Nombrado;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record IdiomaRequest(
    @NotBlank(message="{idioma.valid.nombre.vacio}")
    @Nombrado(message="{idioma.valid.nombre.validacion.espacios}")
    @Pattern(regexp = "^[A-Za-zÁÉÍÓÚáéíóúÑñÜü]{2,50}$",
        message = "{idioma.valid.nombre.validacion.longitud}")
    String nombre
) {
    public IdiomaRequest(Idioma i) {
        this(i.getNombre());
    }
}
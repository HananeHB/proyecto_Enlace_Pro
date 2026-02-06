package es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.infraestructure.web.dto.alumno;

import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.domain.model.Alumno;
import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.infraestructure.web.validation.Nombrado;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;


public record AlumnoRequest(
    @NotBlank(message = "{alumno.valid.nombre.vacio}")
    @Nombrado(message="{alumno.valid.nombre.validacion}")
    @Pattern(regexp = "^[A-Za-zÁÉÍÓÚáéíóúÑñÜü]{2,50}$",
        message = "{alumno.valid.alumno.validacion.longitud}")
    String nombre,

    @NotBlank(message = "{alumno.valid.apellidos.vacios}")
    @Nombrado(message="{alumno.valid.apellidos.validacion}")
    @Pattern(regexp = "^[A-Za-zÁÉÍÓÚáéíóúÑñÜü]{2,50}$",
        message = "{alumno.valid.apellidos.validacion.longitud}")
    String apellido,

    @Email
    String email,

    @Pattern(regexp = "^[6-9][0-9]{8}$",
        message = "{alumno.valid.telefono.formato}")
    String numeroTelefono,

    @Min(value = 1) 
    int idioma) {

        public AlumnoRequest(Alumno a){
            this(a.getNombre(), a.getApellidos(), a.getEmail(), a.getNumeroTelefono(), a.getIdiomaId().getValue());
        }
} 

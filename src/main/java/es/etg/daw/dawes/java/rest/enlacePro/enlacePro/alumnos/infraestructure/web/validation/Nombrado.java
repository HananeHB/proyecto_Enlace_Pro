package es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.infraestructure.web.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.ElementType;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NombradoValidador.class)
@Documented
public @interface Nombrado {
    String message() default "{es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.infraestructure.web.validation.alumno.NombradoAlumno}";

    Class<?>[] groups() default{};

    Class<? extends Payload>[] payload() default{};
}

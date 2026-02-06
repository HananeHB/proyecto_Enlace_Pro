package es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.infraestructure.web.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class NombradoValidador implements ConstraintValidator<Nombrado, String>{

    public final static String STR_BLANCO = " ";
    public final static String STR_SALTO = "\n";
    public final static String DOBLE_ESPACIO = "  ";
    public static final int MIN_LONGITUD = 2;
    public static final int MAX_LONGITUD = 50;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        
        if(value == null || value.length()==0 || value.contains(STR_BLANCO) || value.contains(STR_SALTO) || 
        value.contains(DOBLE_ESPACIO) || value.length() < MIN_LONGITUD || value.length() > MAX_LONGITUD)
            return false;

        return true;
    }
    
}

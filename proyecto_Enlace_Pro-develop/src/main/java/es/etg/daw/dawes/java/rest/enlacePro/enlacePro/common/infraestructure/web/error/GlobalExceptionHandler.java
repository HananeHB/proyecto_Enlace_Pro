package es.etg.daw.dawes.java.rest.enlacePro.enlacePro.common.infraestructure.web.error;

import java.time.LocalDateTime;
import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.common.domain.error.ApiVersionIncorrectaException;
import lombok.AllArgsConstructor;

@RestControllerAdvice
@AllArgsConstructor
public class GlobalExceptionHandler {

    private final MessageSource messageSource;
    
    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<CustomResponse> nullPointerHandler(NullPointerException nfe) {

        
        Object [] datos = new Object[]{
                nfe 
                };
        String msg = messageSource.getMessage(
                        "common.error.null_pointer",
                        datos,
                        Locale.getDefault());


        CustomResponse cr = new CustomResponse(LocalDateTime.now(), HttpStatus.INTERNAL_SERVER_ERROR, msg);
        return new ResponseEntity<>(cr, cr.getStatus());
    }

    @ExceptionHandler(ApiVersionIncorrectaException.class)
    public ResponseEntity<CustomResponse> handleApiVersion(ApiVersionIncorrectaException hv){
         Object [] datos = new Object[]{
                hv 
                };
        String mensaje = messageSource.getMessage(
            "api.error.version_incorrecta",datos, Locale.getDefault());

        CustomResponse cr = new CustomResponse(LocalDateTime.now(), HttpStatus.INTERNAL_SERVER_ERROR,mensaje);
        return new ResponseEntity<>(cr, cr.getStatus());
    }

}
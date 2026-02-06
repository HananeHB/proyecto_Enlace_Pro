package es.etg.daw.dawes.java.rest.enlacePro.enlacePro.common.domain.error;

public class ApiVersionIncorrectaException extends RuntimeException {
    
    public ApiVersionIncorrectaException(){
        super();
    }

    public ApiVersionIncorrectaException(String message){
        super(message);
    }
}

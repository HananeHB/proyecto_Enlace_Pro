package es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.infraestructure.web.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.application.command.idioma.CreateIdiomaCommand;
import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.application.service.idioma.CreateIdiomaService;
import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.application.service.idioma.FindIdiomaService;
import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.domain.model.Idioma;
import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.infraestructure.mapper.IdiomaMapper;
import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.infraestructure.web.dto.idioma.IdiomaRequest;
import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.infraestructure.web.dto.idioma.IdiomaResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/idiomas")
@RequiredArgsConstructor
public class IdiomaController {
    
    private final CreateIdiomaService createIdiomaService;
    private final FindIdiomaService findIdiomaService;
    
    @PostMapping
    public ResponseEntity<?> createIdioma(@Valid @RequestBody IdiomaRequest idiomaRequest) {
        String nombre =idiomaRequest.nombre();

        //verifica si ya existe
        if (createIdiomaService.idiomaExiste(nombre)) {
            Map<String,String>error=new HashMap<>();
            error.put("nombre", "El idioma '" + nombre + "' ya está registrado");
            return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
        }
        CreateIdiomaCommand comando = IdiomaMapper.toCommand(idiomaRequest);
        Idioma idioma = createIdiomaService.createIdioma(comando);
        return ResponseEntity.status(HttpStatus.CREATED).body(IdiomaMapper.toResponse(idioma));
    }

    @Value("${api.version}")
    private String apiVersion;
    
    @GetMapping
    public List<IdiomaResponse> allIdiomas() {
        if("1.0".equals(apiVersion)) {
            return findIdiomaService.findAll()
                    .stream()
                    .map(IdiomaMapper::toResponse)
                    .toList();
        } else {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Versión de la API incorrecta.");
        }
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST) 
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handlerValidationException(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}

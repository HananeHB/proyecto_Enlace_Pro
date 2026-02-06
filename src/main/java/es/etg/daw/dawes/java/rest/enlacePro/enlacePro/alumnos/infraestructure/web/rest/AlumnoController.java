package es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.infraestructure.web.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.application.command.alumno.CreateAlumnoCommand;
import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.application.command.alumno.EditAlumnoCommand;
import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.application.service.alumno.CreateAlumnoService;
import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.application.service.alumno.DeleteAlumnoService;
import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.application.service.alumno.EditarAlumnoService;
import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.application.service.alumno.FindAlumnoService;
import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.domain.model.Alumno;
import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.domain.model.id.AlumnoId;
import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.infraestructure.mapper.AlumnoMapper;
import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.infraestructure.web.dto.alumno.AlumnoRequest;
import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.infraestructure.web.dto.alumno.AlumnoResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "Alumnado", description = "Operaciones relacionadas con la gestión del alumnado")
@RestController
@RequestMapping("/alumnos")
@RequiredArgsConstructor
public class AlumnoController {
    public final CreateAlumnoService createAlumnoService;
    public final FindAlumnoService findAlumnoService;
    public final DeleteAlumnoService deleteAlumnoService;
    public final EditarAlumnoService editarAlumnoService;

    @PostMapping
    public ResponseEntity<AlumnoResponse> createAlumno(@Valid @RequestBody AlumnoRequest alumnoRequest) {
        CreateAlumnoCommand comando = AlumnoMapper.toCommand(alumnoRequest);
        Alumno al = createAlumnoService.createAlumno(comando);
        return ResponseEntity.status(HttpStatus.CREATED).body(AlumnoMapper.toResponse(al));
    }

    @Value("${api.version}")
    private String apiVersion;

    @Operation(summary = "Obtiene el listado de alumnado", description = "Busca en la base de datos todo el alumnado y sus detalles")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Listado del alumnado generado"),
            @ApiResponse(responseCode = "404", description = "No hay alumnos en la base de datos")
    })

    @GetMapping
    public List<AlumnoResponse> allAlumnos() {
        if ("1.0".equals(apiVersion)) {
            return findAlumnoService.findAll()
                    .stream()
                    .map(AlumnoMapper::toResponse)
                    .toList();
        } else {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Version del API incorrecta");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAlumno(@PathVariable Integer id) {
        deleteAlumnoService.delete(new AlumnoId(id));
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public AlumnoResponse editAlumno(@PathVariable int id, @RequestBody AlumnoRequest alumnoRequest) {
        EditAlumnoCommand comando = AlumnoMapper.toCommand(id, alumnoRequest);
        Alumno alumno = editarAlumnoService.update(comando);
        return AlumnoMapper.toResponse(alumno);
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

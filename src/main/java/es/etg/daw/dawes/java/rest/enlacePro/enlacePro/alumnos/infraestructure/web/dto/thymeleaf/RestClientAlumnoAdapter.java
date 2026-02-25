package es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.infraestructure.web.dto.thymeleaf;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.domain.model.Alumno;
import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.domain.model.id.AlumnoId;
import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.domain.model.id.IdiomaId;
import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.domain.repository.AlumnoRepository;
import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.infraestructure.mapper.AlumnoMapper;
import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.infraestructure.web.dto.alumno.AlumnoRequest;
import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.infraestructure.web.dto.alumno.AlumnoResponse;
import jakarta.servlet.http.HttpSession;

@Component
public class RestClientAlumnoAdapter implements AlumnoRepository {

    private final RestClient restClient;
    private final String alumnoBaseUrl;
    private final HttpSession session;


    public RestClientAlumnoAdapter(@Qualifier("alumnoRestClient") RestClient restClient, 
                                @Value("${restclient.alumnos.baseurl}") String alumnoBaseUrl,
                                HttpSession session) {
        this.restClient = restClient;
        this.alumnoBaseUrl = alumnoBaseUrl;
        this.session=session;
    }

    private RestClient authenticatedClient() {
        // String token = (String) session.getAttribute("JWT_TOKEN");
        // if (token == null) return restClient;

        // return restClient.mutate()
        //         .defaultHeader(HttpHeaders.AUTHORIZATION, "Bearer " + token)
        //         .build();
        return restClient;// si se quiere activar el JWT se quita esta línea

    }
    
    @Override
    public Alumno save(Alumno a) {
        AlumnoRequest request = AlumnoMapper.toRequest(a);

        // Si tiene ID, usamos PUT (Actualizar)
        if (a.getId() != null && a.getId().getValue() != null) {
            return AlumnoMapper.toDomain(authenticatedClient().put()
                    .uri(alumnoBaseUrl + "/" + a.getId().getValue())
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(request)
                    .retrieve()
                    .body(new ParameterizedTypeReference<AlumnoResponse>(){}));
        }
        // Si no tiene ID, usamos POST (Crear)
        else {
            return AlumnoMapper.toDomain(authenticatedClient().post()
                    .uri(alumnoBaseUrl)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(request)
                    .retrieve()
                    .body(new ParameterizedTypeReference<AlumnoResponse>(){}));
        }
    }

    @Override
    public List<Alumno> getAll() {
        return AlumnoMapper.toDomainResponse(authenticatedClient().get()
                .uri(alumnoBaseUrl)
                .retrieve()
                .body(new ParameterizedTypeReference<List<AlumnoResponse>>() {
                }));
    }

    @Override
    public Optional<Alumno> getById(AlumnoId id) {
        try {
            AlumnoResponse resp = authenticatedClient().get()
                    .uri(alumnoBaseUrl + "/" + id.getValue())
                    .retrieve()
                    .body(AlumnoResponse.class);
            return Optional.ofNullable(AlumnoMapper.toDomain(resp));
        } catch (Exception e) {
            return Optional.empty(); // Si no lo encuentra o falla la API
        }
    }

    @Override    
    public void deleteById(AlumnoId id) {
        authenticatedClient().delete()
                .uri(alumnoBaseUrl + "/" + id.getValue())
                .retrieve()
                .toBodilessEntity(); // se usa esto porque no emperamos un cuerpo de respuesta

    }

    @Override
    public Optional<Alumno> getByName(String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getByName'");
    }

    

    

}

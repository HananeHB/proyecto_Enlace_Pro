package es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.infraestructure.web.dto.thymeleaf;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.domain.model.Idioma;
import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.domain.model.id.IdiomaId;
import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.domain.repository.IdiomaRepository;
import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.infraestructure.mapper.IdiomaMapper;
import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.infraestructure.web.dto.idioma.IdiomaRequest;
import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.infraestructure.web.dto.idioma.IdiomaResponse;
import jakarta.servlet.http.HttpSession;

@Component
public class RestClientIdiomaAdapter implements IdiomaRepository {

    private final RestClient restClient;
    private final String idiomaBaseUrl;
    private final HttpSession session;

    // Constructor para inyectar el RestClient específico de idiomas y la url base
    // se usa @Qualifier("idiomaRestClient") para evitar conflicto con otros
    // RestClient
    public RestClientIdiomaAdapter(
            @Qualifier("idiomaRestClient") RestClient restClient,
            @Value("${restclient.idiomas.baseurl}") String idiomaBaseUrl,
            HttpSession session) {
        this.restClient = restClient;
        this.idiomaBaseUrl = idiomaBaseUrl;
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
    public Idioma save(Idioma i) {
        IdiomaRequest nuevo = IdiomaMapper.toRequest(i);
        /// Si tiene ID, usamos PUT (Actualizar)
        if (i.getId() != null && i.getId().getValue() != null) {
            return IdiomaMapper.toDomain(restClient.put()
                    .uri(idiomaBaseUrl + "/" + i.getId().getValue())
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(nuevo)
                    .retrieve()
                    .body(new ParameterizedTypeReference<IdiomaResponse>(){}));
        }
        // Si no tiene ID, usamos POST (Crear)
        else {
            return IdiomaMapper.toDomain(authenticatedClient().post()
                    .uri(idiomaBaseUrl)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(nuevo)
                    .retrieve()
                    .body(new ParameterizedTypeReference<IdiomaResponse>(){}));
        }
    }

    @Override
    public List<Idioma> getAll() {
        return IdiomaMapper.toDomainResponse(authenticatedClient().get()
                .uri(idiomaBaseUrl)
                .retrieve()
                .body(new ParameterizedTypeReference<List<IdiomaResponse>>() {
                }));
    }

    @Override
    public Optional<Idioma> getById(IdiomaId id) {
        try {
            IdiomaResponse res = authenticatedClient().get()
                    .uri(idiomaBaseUrl + "/" + id.getValue())
                    .retrieve()
                    .body(new ParameterizedTypeReference<IdiomaResponse>() {
                    });
            return Optional.ofNullable(IdiomaMapper.toDomain(res));
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    @Override
    public void deleteById(IdiomaId id) {
        authenticatedClient().delete()
                .uri(idiomaBaseUrl + "/" + id.getValue())
                .retrieve()
                .body(Void.class);// No necesitamos el cuerpo
    }

}

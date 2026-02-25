package es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.infraestructure.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class RestClientConfig {
    @Value("${restclient.alumnos.baseurl}")
    private String alumnosBaseUrl;

    @Value("${restclient.idiomas.baseurl}")
    private String idiomasBaseUrl;
    
    @Bean
    public RestClient alumnoRestClient() {
        return RestClient.builder()
                .baseUrl(alumnosBaseUrl)
                .build();
    }
    @Bean
    public RestClient idiomaRestClient() {
        return RestClient.builder()
                .baseUrl(idiomasBaseUrl)
                .build();
    }
}

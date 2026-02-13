package es.etg.daw.dawes.java.rest.enlacePro.enlacePro.auth.infraestructure.config;

import static org.springframework.security.config.Customizer.withDefaults;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.auth.domain.Rol;
import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.auth.infraestructure.db.jpa.repository.UserEntityRepository;
import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.auth.infraestructure.mapper.UserMapper;
import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.auth.infraestructure.security.JwtFilter;
import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

    private final UserEntityRepository repository;

    @Value("${security.endpoint.alumnos}")
    private String alumnosEndpoint;

    @Value("${security.endpoint.idiomas}")
    private String idiomasEndpoint;

    @Bean
    public UserDetailsService userDetailsService() {
        return username -> UserMapper.toAuth(UserMapper.toDomain(repository.findByEmail(username)));
    }


    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    // ESTE ES JWT
    // @Bean
    // public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

    //     http.csrf(csrf -> csrf.disable()) //desactivar CSRF porque usmaos JWT
    //         .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))//no usamos sesión(JWT es stateless)
    //         //configuración de permisos por endpoint
    //         .authorizeHttpRequests(requests -> requests
    //                     .requestMatchers("/auth/login").permitAll()
    //                     .requestMatchers(idiomasEndpoint).hasRole(Rol.ADMIN.name())
    //                     .requestMatchers(alumnosEndpoint).hasAnyRole(Rol.ADMIN.name())
    //                     .anyRequest().authenticated()
    //         )      
    //         //anadir el filtro JWT antes del filtro de Spring
    //         .addFilterBefore(new JwtFilter(), UsernamePasswordAuthenticationFilter.class);             
    //     return http.build();
    // }


    /**
     * ESTE ES EL BEAN CON LA AUTENTICACIÓN SOLO SIN EL JWT 
     */
    // @Bean
    // public SecurityFilterChain securityFilterChain(HttpSecurity http) throws
    // Exception {

    // http.authorizeHttpRequests((requests) -> requests
    // .requestMatchers(idiomasEndpoint).hasRole(Rol.ADMIN.name())
    // .requestMatchers(alumnosEndpoint).hasAnyRole(Rol.ADMIN.name()));
    // http.formLogin(withDefaults());
    // http.httpBasic(withDefaults());
    // return http.build();
    // }

    /**
     * ESTO ES PARA DESACTIVAR EL ANTERIOR BEAN 
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.csrf(csrf -> csrf.disable()) //Desactiva CSRF
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().permitAll() //Permite todas las peticiones
                )
                .formLogin(form -> form.disable()) //Desactiva login
                .httpBasic(basic -> basic.disable()); //Desactiva basic auth

        return http.build();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOriginPatterns(Arrays.asList("*"));
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        configuration.setAllowedHeaders(Arrays.asList("*"));
        configuration.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

}
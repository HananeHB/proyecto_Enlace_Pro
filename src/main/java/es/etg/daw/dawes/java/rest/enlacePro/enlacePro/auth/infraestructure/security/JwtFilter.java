package es.etg.daw.dawes.java.rest.enlacePro.enlacePro.auth.infraestructure.security;

import java.io.IOException;
import java.util.Collections;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JwtFilter extends OncePerRequestFilter{

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        //obtiene el header Authorization de la petición
        String header = request.getHeader("Authorization");

        
        if (header != null && header.startsWith("Bearer ")) {
            String token = header.substring(7);

            try {
                // Valida el token usando JwtUtil
                Jws<Claims> claims = JwtUtil.validarToken(token);
                // Extrae el email (subject del token)
                String email = claims.getBody().getSubject();

                 // Extrae el rol almacenado como claim
                String role= claims.getBody().get("role",String.class);
                UsernamePasswordAuthenticationToken authentication=
                                new UsernamePasswordAuthenticationToken(
                                    email,
                                    null,
                                    Collections.singletonList(
                                        new SimpleGrantedAuthority("ROLE_"+role))
                                    );
                /**Esto permite guardar la autenticación en el contexto de seguridad. 
                 * Permite que Spring apligue hasRole() o hasAnyRole()
                 */
                SecurityContextHolder.getContext().setAuthentication(authentication);
            } catch (Exception e) {
                /**
                 * Si el token es inválido, expiró o fue manipulado no se establece 
                 * autenticación y la petición seguirá sin usuario autenticado
                 */
            }
        }
        //continúa con el siguiente filtro de la cadena
        filterChain.doFilter(request, response);
    }
    
}

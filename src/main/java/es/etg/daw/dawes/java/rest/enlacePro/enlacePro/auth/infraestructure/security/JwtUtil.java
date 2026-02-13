package es.etg.daw.dawes.java.rest.enlacePro.enlacePro.auth.infraestructure.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.util.Date;

public class JwtUtil {
    //clave secreta generada automáticamente para firmar y validar los tockens JWT de manera segura 
    private static final Key key= Keys.secretKeyFor(SignatureAlgorithm.HS256);
    private static final long EXPIRATION=100*60*60; //Una hora

    //Genenrar un JWT usando email y rol
    public static String generarToken(String email,String role){
        return Jwts.builder()
            .setSubject(email) 
            .claim("role", role)
            .setIssuedAt(new Date()) //Fecha de emisión
            .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION))
            .signWith(key)
            .compact();
    }

    //valida un tocken JWT
    public static Jws<Claims> validarToken(String token) throws JwtException{
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token);
    }
}

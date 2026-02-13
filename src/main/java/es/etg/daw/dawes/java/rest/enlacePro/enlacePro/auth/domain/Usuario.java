package es.etg.daw.dawes.java.rest.enlacePro.enlacePro.auth.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Usuario {
    
    private UsuarioId id;
    private String nombre;
    private String apellido;
    private String email;
    private String password;
    private Rol rol;
}

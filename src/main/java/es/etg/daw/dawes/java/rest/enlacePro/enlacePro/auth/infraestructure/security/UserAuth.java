package es.etg.daw.dawes.java.rest.enlacePro.enlacePro.auth.infraestructure.security;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.auth.domain.Rol;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserAuth implements UserDetails{
    
    private Integer id;
    private String nombre;
    private String email;
    private String password;
    private Rol rol;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        var authorities = rol.getPermisos()
                .stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermiso()))
                .collect(Collectors.toList());
        authorities.add(new SimpleGrantedAuthority("ROLE_" + rol.name()));
        return authorities;
    }
    @Override
    public String getUsername() {
        return email;
    }
}

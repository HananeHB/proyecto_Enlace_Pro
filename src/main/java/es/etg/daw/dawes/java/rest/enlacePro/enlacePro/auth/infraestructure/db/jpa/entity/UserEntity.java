package es.etg.daw.dawes.java.rest.enlacePro.enlacePro.auth.infraestructure.db.jpa.entity;

import es.etg.daw.dawes.java.rest.enlacePro.enlacePro.auth.domain.Rol;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "USUARIOS")
public class UserEntity {
    
    @Id
    @GeneratedValue
    private Integer id;
    private String nombre;
    private String apellidos;
    private String email;
    private String password;

    @Enumerated(EnumType.STRING)
    private Rol rol;
}

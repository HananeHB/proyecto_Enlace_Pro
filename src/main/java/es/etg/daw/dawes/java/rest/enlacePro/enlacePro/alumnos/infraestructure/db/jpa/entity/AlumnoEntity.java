package es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.infraestructure.db.jpa.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "alumnos")
public class AlumnoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @Column(name = "apellidos", nullable = false, length = 50)
    private String apellido;

    @Column(name = "numero_telefono", nullable = false, length = 9)
    private String numeroTelefono;

    @Column(name = "email", nullable = false, unique = true, length = 100)
    private String email;

    @Column(name = "direccion", nullable = false, unique = true, length = 200)
    private String direccion;

    @Column(name = "fecha_creacion", nullable = false, updatable = false)
    private LocalDateTime fechaCreacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idioma_id", nullable = false)
    private IdiomaEntity idioma;

    // NO NOS HACE FALTA PORQUE TENEMOS EL AllArgsConstructor
    public AlumnoEntity(Integer id, String nombre, String apellido, String numeroTelefono, String email,
            LocalDateTime fechaCreacion, IdiomaEntity idioma) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.numeroTelefono = numeroTelefono;
        this.fechaCreacion = fechaCreacion;
        this.idioma = idioma;
    }
}

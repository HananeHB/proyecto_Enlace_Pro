package es.etg.daw.dawes.java.rest.enlacePro.enlacePro.alumnos.infraestructure.db.jpa.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
@Builder
@Table(name = "idiomas")
public class IdiomaEntity {

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @Column(name = "fecha_creacion", nullable = false, updatable = false)
    private LocalDateTime fechaCreacion;
    
    @Builder.Default
    @OneToMany(mappedBy = "idioma", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AlumnoEntity> alumnos = new ArrayList<AlumnoEntity>();

    public IdiomaEntity(){

    }

    public IdiomaEntity(Integer id, String nombre, LocalDateTime createdAt) {
        this.id = id;
        this.nombre = nombre;
        this.fechaCreacion = createdAt;
    }

    public void addAlumno(AlumnoEntity a) {
        this.alumnos.add(a);
        a.setIdioma(this);
    }

    public void removeAlumno(AlumnoEntity a) {
        this.alumnos.remove(a);
        a.setIdioma(null);
    }
}

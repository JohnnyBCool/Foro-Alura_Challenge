package foro.challenge.api.domain.curso;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name="cursos")
@Entity(name="Curso")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class Cursos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    public Cursos (DatosRegistroCurso datos){
        this.id=null;
        this.nombre = datos.nombre();
        this.categoria = datos.categoria();
    }

    public void actualizarCurso(@Valid DatosActualizarCurso datos) {
        if(datos.nombre() != null){
            this.nombre = datos.nombre();
        }
        if(datos.categoria() != null){
            this.categoria = datos.categoria();
        }
    }
}

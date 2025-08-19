package foro.challenge.api.domain.perfil;

import foro.challenge.api.domain.curso.Categoria;
import foro.challenge.api.domain.curso.DatosActualizarCurso;
import foro.challenge.api.domain.curso.DatosRegistroCurso;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name="perfiles")
@Entity(name="Perfil")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class Perfiles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;

    public Perfiles (DatosRegistroPerfil datos){
        this.id=null;
        this.nombre = datos.nombre();
    }

    public void actualizarPerfil(@Valid DatosActualizarPerfil datos) {
        if(datos.nombre() != null){
            this.nombre = datos.nombre();
        }
    }
}

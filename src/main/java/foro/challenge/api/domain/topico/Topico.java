package foro.challenge.api.domain.topico;

import foro.challenge.api.domain.curso.Cursos;
import foro.challenge.api.domain.usuario.Usuario;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

@Table(name="topicos")
@Entity(name="Topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")

public class Topico {
    //Importar repositorio de Usuarios, cursos y de respuestas
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    @Column(name="fechaCreacion")
    private LocalDateTime fechaCreacion;

    private Boolean status = true;

    //@ManyToOne(fetch = FetchType.LAZY)
    //@Column(name="autor") //usuario_id es un campo dentro de la tabla Topico
    // private Long autor;
    private String autor;
    private String curso;
    //private Cursos curso;
    //@Column(name="respuestas")
    private String respuestas="";

    @Enumerated(EnumType.STRING)
    private Tags tag;

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }




    public Topico(DatosRegistroTopico datos, LocalDateTime fecha){ //La fecha se asigna en cuando se invoca en el método
        this.id = null;
        this.titulo = datos.titulo();
        this.mensaje = datos.mensaje();
        //this.autor = datos.autor();
        this.curso = datos.curso();
        //this.respuestas="";
        this.tag = datos.tag();
        this.fechaCreacion = fecha;
    }

    public void actualizarInformacion(@Valid ActualizarTopico datos) {
        //Titulo, mensaje, autor y curso
        if(datos.titulo() != null) {
            this.titulo = datos.titulo();
        }
        if(datos.mensaje() != null) {
            this.mensaje = datos.mensaje();
        }

        if(datos.curso() != null){
            this.curso = datos.curso();
        }

    }

    public void eliminar() {
        this.status = false;
    }

}

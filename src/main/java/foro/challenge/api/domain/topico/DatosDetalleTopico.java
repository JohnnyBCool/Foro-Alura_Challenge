package foro.challenge.api.domain.topico;

import foro.challenge.api.domain.curso.Cursos;

import java.time.LocalDateTime;

//Esta clase muetra solamente información particular de un solo tópico
public record DatosDetalleTopico (
     Long id,
     String titulo,
     String mensaje,
     LocalDateTime fechaCreacion,
     Boolean status,
     String autor,
     String curso,
     Tags Tag
     ){
    public DatosDetalleTopico(Topico topico){
            this(
                    topico.getId(),
                    topico.getTitulo(),
                    topico.getMensaje(),
                    topico.getFechaCreacion(),
                    topico.getStatus(),
                    topico.getAutor(),
                    topico.getCurso(),
                    topico.getTag()

                    //Agregar status, autor y curso
            );
    }
}

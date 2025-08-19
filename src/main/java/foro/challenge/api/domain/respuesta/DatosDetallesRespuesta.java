package foro.challenge.api.domain.respuesta;

import jakarta.persistence.*;

import java.time.LocalDateTime;

public record DatosDetallesRespuesta (
       Long id,
       String mensaje,
       String toipico,
       LocalDateTime fechacreacion,
       String autor,
       Long solucion
){
    public DatosDetallesRespuesta(Respuesta respuesta){
            this(respuesta.getId(), respuesta.getMensaje(), respuesta.getToipico(), respuesta.getFechacreacion(), respuesta.getAutor(), respuesta.getSolucion());
    }
}

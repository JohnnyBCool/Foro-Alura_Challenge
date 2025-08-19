package foro.challenge.api.domain.topico;

import jakarta.persistence.*;
//Esta clase muestra información más completa y general para la lista de TODOS los Tópicos
import java.time.LocalDateTime;//Esta clase muestra los campos de los topicos
public record DatosListaTopico(
        Long id,
        String titulo,
        String mensaje,
        LocalDateTime fechaCreacion,
        //Boolean status,
        //Long autor
       //String curso,
        Tags tag
) {
    public DatosListaTopico(Topico topico) {
        this(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFechaCreacion(),
                //topico.getStatus(),
                //topico.getAutor()
                //topico.getCurso(),
                topico.getTag()
        );
    }
}

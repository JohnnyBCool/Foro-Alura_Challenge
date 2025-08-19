package foro.challenge.api.domain.respuesta;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DatosRegistroRespuesta(

        Long id,
        @NotNull
        String menaje,
        String toipico,
        LocalDateTime fechacreacion,
        String autor,
        @NotNull
        Long solucion
) {
}

package foro.challenge.api.domain.topico;

import foro.challenge.api.domain.curso.Cursos;

public record ActualizarTopico(
        Long id,
        String titulo,
        String mensaje,
        String status,
        String curso,
        String tag
) {

}

package foro.challenge.api.domain.curso;

import jakarta.validation.constraints.NotBlank;

public record DatosActualizarCurso(
        @NotBlank
        String nombre,
        @NotBlank
        Categoria categoria
) {
}


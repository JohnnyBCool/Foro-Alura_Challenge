package foro.challenge.api.domain.curso;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

public record DatosRegistroCurso(
        @NotNull
        String nombre,
        @NotNull
        Categoria categoria
        ) {
}

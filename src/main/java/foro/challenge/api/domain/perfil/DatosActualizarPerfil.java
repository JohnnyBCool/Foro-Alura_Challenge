package foro.challenge.api.domain.perfil;

import jakarta.validation.constraints.NotNull;

public record DatosActualizarPerfil(
        @NotNull
        String nombre
) {
}

package foro.challenge.api.domain.topico;

import foro.challenge.api.domain.curso.Cursos;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;


public record DatosRegistroTopico(
        @NotNull (message = "Es necesario escribir un título")
        String titulo,
        @NotBlank (message = "Es necesario escribir un mensaje")
        String mensaje,
        LocalDateTime fechaCreacion,
        //Long autor,
        //@NotNull (message = "Ingrese el curso")
        String curso,
        //Cursos curso,
        Tags tag) {
}

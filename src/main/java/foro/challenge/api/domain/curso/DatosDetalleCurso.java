package foro.challenge.api.domain.curso;

public record DatosDetalleCurso (
        Long id,
        String nombre,
        Categoria categoria
        ){
    public DatosDetalleCurso(Cursos curso) {
            this(
                    curso.getId(),
                    curso.getNombre(),
                    curso.getCategoria()
            );
    }
}

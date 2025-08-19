package foro.challenge.api.domain.curso;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CursosRepository extends JpaRepository<Cursos, Long> {
    String findByNombre(String nombre);
}

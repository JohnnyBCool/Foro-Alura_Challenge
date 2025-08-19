package foro.challenge.api.domain.topico;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TopicoRepository extends JpaRepository <Topico, Long> {
    @Query("""
            SELECT t from Topico t
            where t.titulo = :titulo    
            """)
    Page<Topico> findAllByTitulo(Pageable paginacion);

    @Query("SELECT COUNT(t) > 0 FROM Topico t " +
            "WHERE (:titulo IS NULL OR t.titulo = :titulo) " +
            "AND (:mensaje IS NULL OR t.mensaje = :mensaje)")
    Boolean existsByTituloAndMensaje(@Param("titulo") String titulo,
                                     @Param("mensaje") String mensaje);
}

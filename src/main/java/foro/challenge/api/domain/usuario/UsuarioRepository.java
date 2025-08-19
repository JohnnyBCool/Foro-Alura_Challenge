package foro.challenge.api.domain.usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    UserDetails findByLogin(String login);

    @Query("""
            SELECT u from Usuario u
            where u.login = :username
            """)
    Long findByUserName(String username);
}

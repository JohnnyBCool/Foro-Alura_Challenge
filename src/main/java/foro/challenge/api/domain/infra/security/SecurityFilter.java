package foro.challenge.api.domain.infra.security;

import foro.challenge.api.controller.TopicoController;
import foro.challenge.api.domain.usuario.UsuarioRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private TopicoController LoggedUser;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        System.out.println("Filtro llamado.");
        var tokenJWT = recuperarToken(request);
        if(tokenJWT != null){

            var subject = tokenService.getSubject(tokenJWT);
            var usuario = repository.findByLogin(subject);
            //System.out.println("Usuario"+ usuario.getUsername());
            //System.out.println("Password"+ usuario.getPassword());
            LoggedUser.setAutorTopico(usuario.getUsername());

            var authentication =new UsernamePasswordAuthenticationToken(usuario, null, usuario.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            System.out.println("Usuario logueado");

        }

        filterChain.doFilter(request, response);

    }

    private String recuperarToken(HttpServletRequest request) {
        var authorizationHeader = request.getHeader("Authorization");
        if(authorizationHeader !=null) {
            return authorizationHeader.replace("Bearer ", "");
        }else {
            //throw new RuntimeException("Token JWT no enviado en el encabezado de Authorization");
            return null;
        }
    }
}

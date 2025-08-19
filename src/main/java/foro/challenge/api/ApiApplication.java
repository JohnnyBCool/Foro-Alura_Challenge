package foro.challenge.api;

import foro.challenge.api.domain.usuario.Usuario;
import foro.challenge.api.domain.usuario.UsuarioRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiApplication {
	private UsuarioRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}


}

package foro.challenge.api.controller;

import foro.challenge.api.domain.curso.Cursos;
import foro.challenge.api.domain.curso.CursosRepository;
import foro.challenge.api.domain.curso.DatosDetalleCurso;
import foro.challenge.api.domain.curso.DatosRegistroCurso;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/cursos")
@SecurityRequirement(name = "bearer-key")
public class CursosController {

    @Autowired
    private CursosRepository repository;

    @Transactional
    @PostMapping

    public ResponseEntity registraCurso (@RequestBody @Valid DatosRegistroCurso datos, UriComponentsBuilder uriComponentsBuilder){
        var curso = new Cursos(datos);
        repository.save(curso);
        var idCurso = curso.getId();
        var uri =uriComponentsBuilder.path("/cursos/{id}").buildAndExpand(idCurso).toUri();
        return ResponseEntity.created(uri).body(new DatosDetalleCurso(curso));
    }
}

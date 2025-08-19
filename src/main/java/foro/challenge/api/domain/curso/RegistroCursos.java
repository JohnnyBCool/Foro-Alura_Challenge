package foro.challenge.api.domain.curso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistroCursos {
    @Autowired
    private CursosRepository cursosRepository;

public void registrarCurso(DatosRegistroCurso datos){

    var nuevoCurso = new Cursos(null,datos.nombre(), datos.categoria() );
    cursosRepository.save(nuevoCurso);
}
}

package foro.challenge.api.controller;
import foro.challenge.api.domain.Validaciones.ValidadorDeTopicos;
import foro.challenge.api.domain.curso.CursosRepository;
import foro.challenge.api.domain.infra.security.TokenService;
import foro.challenge.api.domain.topico.*;
import foro.challenge.api.domain.usuario.DatosAutenticacion;
import foro.challenge.api.domain.usuario.Usuario;
import foro.challenge.api.domain.usuario.UsuarioRepository;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import jakarta.validation.ValidationException;
import jakarta.validation.constraints.Null;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/topicos")
@SecurityRequirement(name = "bearer-key")
public class TopicoController {

    @Autowired
    private TopicoRepository repository;
    @Autowired
    private CursosRepository cursosRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private List<ValidadorDeTopicos> validadores;

    private String LoggedUser;


    @Transactional
    @PostMapping
    public ResponseEntity<DatosDetalleTopico> registrarTopico(@RequestBody @Valid DatosRegistroTopico datos, UriComponentsBuilder uriComponentsBuilder) {
        var ahora = LocalDateTime.now();
        var topico = new Topico(datos, ahora);
        System.out.println(LoggedUser);
        topico.setAutor(LoggedUser);
        //Aunque solo es un validador para esta función en particular, decidí dejar el estilo que aprendí con el intructor.

        validadores.forEach(v ->v.validar(datos));
        Boolean existe = repository.existsByTituloAndMensaje(datos.titulo(), datos.mensaje());
        //Verificar que no se registre un nuevo toíco con el mismo topico y el mimo menaje existente en la base de datos

        if (!existe){ //Si el tópico no se encuentra regustrado, esta evaluación debe ser "false"
            System.out.println("Guardando tópico...");
            System.out.println(topico);
            System.out.println("Fecha de creación:");
            System.out.println(ahora);

            repository.save(topico);
            var idTopico = topico.getId();
            var uri =uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(idTopico).toUri();

            return ResponseEntity.created(uri).body(new DatosDetalleTopico(topico));
        }else{
            throw new ValidationException("¡Ya existe este tópico!.");
        }
    }

    @Transactional
    @PutMapping("/{id}")
    public ResponseEntity actualizar(@RequestBody @Valid ActualizarTopico datos, @PathVariable Long id){
        if(id != null){
            if(repository.existsById(id)){
            var topico = repository.getReferenceById(id); //En esta ocasión, la id e toma dede el cuerpo del topico
            topico.actualizarInformacion(datos);
                System.out.println(datos.curso());
            return ResponseEntity.ok(new DatosDetalleTopico(topico));
            }else{
                throw new ValidationException("El tópico que quieres modificar no existe.");
            }
        }else{
            throw new ValidationException("Ingrese un Id válido.");
        }
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity eliminar(@PathVariable Long id){
        if(id != null){
            if(repository.existsById(id)) {
                var topico = repository.getReferenceById(id);
                topico.eliminar();
                repository.deleteById(id);
                return ResponseEntity.noContent().build();
            }else {
                throw new RuntimeException("Tópico no encontrado con el ID:" + id);
            }
        }else{
            throw new ValidationException("Ingrese un Id válido.");
        }
    }

    @GetMapping
    public ResponseEntity<Page<DatosListaTopico>> lista(@PageableDefault(size=10, sort={"titulo"}) Pageable paginacion){
    var page = repository.findAll(paginacion).map(DatosListaTopico::new);
    System.out.println("Saludos desde lista tópicos.");
    System.out.println(page);
    return ResponseEntity.ok(page);
    }


    @GetMapping("/{id}")
    public ResponseEntity detallar(@PathVariable Long id){
        var topico = repository.getReferenceById(id);
        return ResponseEntity.ok(new DatosDetalleTopico(topico));
    }

    public void setAutorTopico(String username) {
        this.LoggedUser = username;
    }
}

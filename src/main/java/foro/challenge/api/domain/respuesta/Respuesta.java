package foro.challenge.api.domain.respuesta;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name="respuestas")
@Entity(name="Respuesta")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class Respuesta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String mensaje;
    private String toipico;
    private LocalDateTime fechacreacion;
    private String autor;
    //@ManyToOne(fetch = FetchType.LAZY)
    @Column(name = "solucion")
    private Long solucion;

}



package foro.challenge.api.domain.Validaciones;

import foro.challenge.api.domain.topico.DatosDetalleTopico;
import foro.challenge.api.domain.topico.DatosRegistroTopico;
import org.springframework.stereotype.Component;

@Component
public class VerificarID implements ValidadorDeTopicosID{

    public void validarID (DatosDetalleTopico datos){
        if (datos.id() == null){
            throw new ValidationException("Introduce un Id válido.");
        }
    }
}

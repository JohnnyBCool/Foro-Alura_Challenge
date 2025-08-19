package foro.challenge.api.domain.Validaciones;

import foro.challenge.api.domain.topico.DatosDetalleTopico;
import foro.challenge.api.domain.topico.DatosRegistroTopico;

public interface ValidadorDeTopicos {
        void validar (DatosRegistroTopico datos);
}

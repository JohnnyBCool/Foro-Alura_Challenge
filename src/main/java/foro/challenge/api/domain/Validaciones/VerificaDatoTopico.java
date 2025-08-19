package foro.challenge.api.domain.Validaciones;

import foro.challenge.api.domain.topico.DatosDetalleTopico;
import foro.challenge.api.domain.topico.DatosRegistroTopico;
import jakarta.validation.ValidationException;
import org.springframework.stereotype.Component;

@Component
public class VerificaDatoTopico implements ValidadorDeTopicos{

public void validar (DatosRegistroTopico datos){

    System.out.println("Saludos desde Topico Controller:");
    System.out.println("Título "+datos.titulo());
    System.out.println("Mensaje "+datos.mensaje());

    System.out.println("Tag "+datos.tag());
    //System.out.println("Título introducido: "+datos.titulo());
    if(datos.titulo() == null){
        throw new jakarta.validation.ValidationException("El tópico debe incluir un título.");
    }
   // System.out.println("Cuerpo del tópico: "+ datos.mensaje());
    if(datos.mensaje() == null){
        throw new ValidationException("El tópico debe contener un mensaje.");
    }
}
}

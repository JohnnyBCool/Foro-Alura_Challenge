package foro.challenge.api.domain.Validaciones;

import org.springframework.stereotype.Component;

public class ValidationException extends RuntimeException {
    public ValidationException(String message) {
        super(message);
    }
}

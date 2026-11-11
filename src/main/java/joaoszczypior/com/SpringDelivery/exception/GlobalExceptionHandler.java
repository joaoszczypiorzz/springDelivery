package joaoszczypior.com.SpringDelivery.exception;

import jakarta.persistence.EntityNotFoundException;
import joaoszczypior.com.SpringDelivery.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Centraliza as respostas de erro da API.
 *
 * @author Joao Szczypior
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    /** Trata entidades inexistentes. */
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFound(EntityNotFoundException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(ErrorResponse.of(HttpStatus.NOT_FOUND.value(), exception.getMessage()));
    }

    /** Trata parÃ¢metros e corpos invÃ¡lidos. */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidation(MethodArgumentNotValidException exception) {
        return ResponseEntity.badRequest()
                .body(ErrorResponse.of(HttpStatus.BAD_REQUEST.value(), "Dados invÃ¡lidos"));
    }
}


package joaoszczypior.com.SpringDelivery.dto;

import java.time.LocalDateTime;

/**
 * Resposta padronizada para erros da API.
 *
 * @author JoÃ£o Szczypior
 */
public record ErrorResponse(LocalDateTime timestamp, int status, String error) {
    /** Cria uma resposta sem detalhes internos da exceÃ§Ã£o. */
    public static ErrorResponse of(int status, String error) {
        return new ErrorResponse(LocalDateTime.now(), status, error);
    }
}


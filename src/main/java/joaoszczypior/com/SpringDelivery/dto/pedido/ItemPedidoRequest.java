package joaoszczypior.com.SpringDelivery.dto.pedido;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

/**
 * Dados mínimos de um item informado na criação do pedido.
 *
 * @author Joao Szczypior
 */
public record ItemPedidoRequest(
        @NotNull Long produtoId,
        @NotNull @Positive Integer quantidade) {
}

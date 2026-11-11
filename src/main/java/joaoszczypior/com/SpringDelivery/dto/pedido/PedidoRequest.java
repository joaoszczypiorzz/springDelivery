package joaoszczypior.com.SpringDelivery.dto.pedido;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Dados necessários para criar um pedido e seus itens.
 *
 * @author Joao Szczypior
 */
public record PedidoRequest(
        LocalDateTime dataPedido,
        @NotEmpty @Valid List<ItemPedidoRequest> itens) {
}

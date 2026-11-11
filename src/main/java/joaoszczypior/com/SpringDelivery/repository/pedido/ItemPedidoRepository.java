package joaoszczypior.com.SpringDelivery.repository.pedido;

import joaoszczypior.com.SpringDelivery.models.pedido.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositório dos itens pertencentes a pedidos.
 *
 * @author Joao Szczypior
 */
public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Long> {
}

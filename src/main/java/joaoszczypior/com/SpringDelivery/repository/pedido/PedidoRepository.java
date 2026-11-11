package joaoszczypior.com.SpringDelivery.repository.pedido;

import joaoszczypior.com.SpringDelivery.models.pedido.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * RepositÃ³rio de pedidos.
 *
 * @author JoÃ£o Szczypior
 */
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}


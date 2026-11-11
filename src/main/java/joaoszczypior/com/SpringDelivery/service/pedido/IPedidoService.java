package joaoszczypior.com.SpringDelivery.service.pedido;

import joaoszczypior.com.SpringDelivery.dto.pageable.FilterPageable;
import joaoszczypior.com.SpringDelivery.dto.pageable.ResponsePagedCommom;
import joaoszczypior.com.SpringDelivery.dto.pedido.PedidoRequest;
import joaoszczypior.com.SpringDelivery.models.pedido.Pedido;

/**
 * Contrato das regras de pedido.
 *
 * @author Joao Szczypior
 */
public interface IPedidoService {
    /** Cria um pedido. */
    Pedido criar(PedidoRequest pedido);

    /** Busca um pedido pelo identificador. */
    Pedido buscar(Long id);

    /** Lista pedidos de forma paginada. */
    ResponsePagedCommom<Pedido> listar(FilterPageable filtro);
}

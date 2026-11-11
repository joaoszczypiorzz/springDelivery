package joaoszczypior.com.SpringDelivery.service.entrega;

import joaoszczypior.com.SpringDelivery.dto.pageable.FilterPageable;
import joaoszczypior.com.SpringDelivery.dto.pageable.ResponsePagedCommom;
import joaoszczypior.com.SpringDelivery.models.entrega.Entrega;

/**
 * Contrato das regras de entrega.
 *
 * @author Joao Szczypior
 */
public interface IEntregaService {
    /** Cria uma entrega. */
    Entrega criar(Entrega entrega);

    /** Lista entregas de forma paginada. */
    ResponsePagedCommom<Entrega> listar(FilterPageable filtro);
}


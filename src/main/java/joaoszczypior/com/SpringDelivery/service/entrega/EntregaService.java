package joaoszczypior.com.SpringDelivery.service.entrega;

import joaoszczypior.com.SpringDelivery.dto.pageable.FilterPageable;
import joaoszczypior.com.SpringDelivery.dto.pageable.ResponsePagedCommom;
import joaoszczypior.com.SpringDelivery.models.entrega.Entrega;
import joaoszczypior.com.SpringDelivery.repository.entrega.EntregaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementa as regras de negocio de entregas.
 *
 * @author Joao Szczypior
 */
@Service
public class EntregaService implements IEntregaService {
    private final EntregaRepository repository;

    /** Cria o serviÃ§o com seu repositÃ³rio. */
    public EntregaService(EntregaRepository repository) {
        this.repository = repository;
    }

    /** {@inheritDoc} */
    @Override
    @Transactional
    public Entrega criar(Entrega entrega) {
        return repository.save(entrega);
    }

    /** {@inheritDoc} */
    @Override
    @Transactional(readOnly = true)
    public ResponsePagedCommom<Entrega> listar(FilterPageable filtro) {
        Page<Entrega> pagina = repository.findAll(PageRequest.of(
                filtro.getPage(), filtro.getSize(), filtro.getDirection(), filtro.getOrderBy()));
        return new ResponsePagedCommom<>(pagina.getContent(), pagina.getTotalElements(),
                pagina.getTotalPages(), pagina.getSize());
    }
}


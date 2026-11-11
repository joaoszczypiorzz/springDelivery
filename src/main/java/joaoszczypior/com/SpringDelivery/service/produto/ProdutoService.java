package joaoszczypior.com.SpringDelivery.service.produto;

import joaoszczypior.com.SpringDelivery.dto.pageable.FilterPageable;
import joaoszczypior.com.SpringDelivery.dto.pageable.ResponsePagedCommom;
import joaoszczypior.com.SpringDelivery.models.produto.Produto;
import joaoszczypior.com.SpringDelivery.repository.produto.ProdutoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Consulta produtos usando a Abstração Produto.
 *
 * @author Joao Szczypior
 */
@Service
public class ProdutoService {
    private final ProdutoRepository repository;

    /** Cria o serviÃ§o com seu repositÃ³rio. */
    public ProdutoService(ProdutoRepository repository) {
        this.repository = repository;
    }

    /** Lista produtos de forma paginada. */
    @Transactional(readOnly = true)
    public ResponsePagedCommom<Produto> listar(FilterPageable filtro) {
        Page<Produto> pagina = repository.findAll(PageRequest.of(
                filtro.getPage(), filtro.getSize(), filtro.getDirection(), filtro.getOrderBy()));
        return new ResponsePagedCommom<>(pagina.getContent(), pagina.getTotalElements(),
                pagina.getTotalPages(), pagina.getSize());
    }
}


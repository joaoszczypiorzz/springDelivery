package joaoszczypior.com.SpringDelivery.controller.produto;

import jakarta.validation.Valid;
import joaoszczypior.com.SpringDelivery.dto.pageable.FilterPageable;
import joaoszczypior.com.SpringDelivery.dto.pageable.ResponsePagedCommom;
import joaoszczypior.com.SpringDelivery.models.produto.Produto;
import joaoszczypior.com.SpringDelivery.service.produto.ProdutoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Endpoint HTTP de consulta de produtos.
 *
 * @author Joao Szczypior
 */
@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    private final ProdutoService service;

    /** Cria o controller com o serviÃ§o de produtos. */
    public ProdutoController(ProdutoService service) {
        this.service = service;
    }

    /** Lista pizza, hambÃºrguer e bebida com paginaÃ§Ã£o padronizada. */
    @GetMapping
    public ResponseEntity<ResponsePagedCommom<Produto>> listar(@Valid FilterPageable filtro) {
        return ResponseEntity.ok(service.listar(filtro));
    }
}


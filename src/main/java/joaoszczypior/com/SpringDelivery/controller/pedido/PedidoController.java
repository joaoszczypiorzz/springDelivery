package joaoszczypior.com.SpringDelivery.controller.pedido;

import jakarta.validation.Valid;
import joaoszczypior.com.SpringDelivery.dto.pageable.FilterPageable;
import joaoszczypior.com.SpringDelivery.dto.pageable.ResponsePagedCommom;
import joaoszczypior.com.SpringDelivery.dto.pedido.PedidoRequest;
import joaoszczypior.com.SpringDelivery.models.pedido.Pedido;
import joaoszczypior.com.SpringDelivery.service.pedido.IPedidoService;
import joaoszczypior.com.SpringDelivery.service.relatorio.IRelatorioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Endpoints HTTP de pedidos.
 *
 * @author Joao Szczypior
 */
@RestController
@RequestMapping("/pedidos")
public class PedidoController {
    private final IPedidoService service;
    private final IRelatorioService relatorioService;

    /** Cria o controller com os contratos necessÃ¡rios. */
    public PedidoController(IPedidoService service, IRelatorioService relatorioService) {
        this.service = service;
        this.relatorioService = relatorioService;
    }

    /** Cria um pedido. */
    @PostMapping
    public ResponseEntity<Pedido> criar(@Valid @RequestBody PedidoRequest pedido) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(pedido));
    }

    /** Busca um pedido pelo identificador. */
    @GetMapping("/{id}")
    public ResponseEntity<Pedido> buscar(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscar(id));
    }

    /** Lista pedidos com paginaÃ§Ã£o padronizada. */
    @GetMapping
    public ResponseEntity<ResponsePagedCommom<Pedido>> listar(@Valid FilterPageable filtro) {
        return ResponseEntity.ok(service.listar(filtro));
    }

    /** Retorna o relatÃ³rio resumido de pedidos. */
    @GetMapping("/relatorio")
    public ResponseEntity<String> relatorio() {
        return ResponseEntity.ok(relatorioService.gerarRelatorioPedidos());
    }
}

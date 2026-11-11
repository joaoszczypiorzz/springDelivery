package joaoszczypior.com.SpringDelivery.controller.entrega;

import jakarta.validation.Valid;
import joaoszczypior.com.SpringDelivery.dto.pageable.FilterPageable;
import joaoszczypior.com.SpringDelivery.dto.pageable.ResponsePagedCommom;
import joaoszczypior.com.SpringDelivery.models.entrega.Entrega;
import joaoszczypior.com.SpringDelivery.service.entrega.IEntregaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Endpoints HTTP de entregas.
 *
 * @author Joao Szczypior
 */
@RestController
@RequestMapping("/entregas")
public class EntregaController {
    private final IEntregaService service;

    /** Cria o controller com o contrato de entrega. */
    public EntregaController(IEntregaService service) {
        this.service = service;
    }

    /** Cria uma entrega. */
    @PostMapping
    public ResponseEntity<Entrega> criar(@Valid @RequestBody Entrega entrega) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(entrega));
    }

    /** Lista entregas com paginação padronizada. */
    @GetMapping
    public ResponseEntity<ResponsePagedCommom<Entrega>> listar(@Valid FilterPageable filtro) {
        return ResponseEntity.ok(service.listar(filtro));
    }
}


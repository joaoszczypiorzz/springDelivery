package joaoszczypior.com.SpringDelivery.service.pedido;

import jakarta.persistence.EntityNotFoundException;
import joaoszczypior.com.SpringDelivery.dto.pageable.FilterPageable;
import joaoszczypior.com.SpringDelivery.dto.pageable.ResponsePagedCommom;
import joaoszczypior.com.SpringDelivery.dto.pedido.ItemPedidoRequest;
import joaoszczypior.com.SpringDelivery.dto.pedido.PedidoRequest;
import joaoszczypior.com.SpringDelivery.enums.pedido.StatusPedido;
import joaoszczypior.com.SpringDelivery.models.pedido.ItemPedido;
import joaoszczypior.com.SpringDelivery.models.pedido.Pedido;
import joaoszczypior.com.SpringDelivery.models.produto.Produto;
import joaoszczypior.com.SpringDelivery.repository.pedido.ItemPedidoRepository;
import joaoszczypior.com.SpringDelivery.repository.pedido.PedidoRepository;
import joaoszczypior.com.SpringDelivery.repository.produto.ProdutoRepository;
import joaoszczypior.com.SpringDelivery.service.relatorio.IRelatorioService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Implementa as regras de negocio de pedidos.
 *
 * @author Joao Szczypior
 */
@Service
public class PedidoService implements IPedidoService, IRelatorioService {
    private final PedidoRepository pedidoRepository;
    private final ItemPedidoRepository itemPedidoRepository;
    private final ProdutoRepository produtoRepository;

    /** Cria o serviÃ§o com seu repositÃ³rio. */
    public PedidoService(PedidoRepository pedidoRepository,
                         ItemPedidoRepository itemPedidoRepository,
                         ProdutoRepository produtoRepository) {
        this.pedidoRepository = pedidoRepository;
        this.itemPedidoRepository = itemPedidoRepository;
        this.produtoRepository = produtoRepository;
    }

    /** {@inheritDoc} */
    @Override
    @Transactional
    public Pedido criar(PedidoRequest request) {
        Pedido pedido = new Pedido(null,
                request.dataPedido() == null ? LocalDateTime.now() : request.dataPedido(),
                StatusPedido.CRIADO);
        Pedido pedidoSalvo = pedidoRepository.save(pedido);

        List<ItemPedido> itens = request.itens().stream()
                .map(item -> criarItem(item, pedidoSalvo))
                .toList();
        itemPedidoRepository.saveAll(itens);
        return pedidoSalvo;
    }

    private ItemPedido criarItem(ItemPedidoRequest request, Pedido pedido) {
        Produto produto = produtoRepository.findById(request.produtoId())
                .orElseThrow(() -> new EntityNotFoundException(
                        "Produto não encontrado: " + request.produtoId()));
        return new ItemPedido(null, produto, pedido, request.quantidade(), produto.getPreco());
    }

    /** {@inheritDoc} */
    @Override
    @Transactional(readOnly = true)
    public Pedido buscar(Long id) {
        return pedidoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Pedido nÃ£o encontrado: " + id));
    }

    /** {@inheritDoc} */
    @Override
    @Transactional(readOnly = true)
    public ResponsePagedCommom<Pedido> listar(FilterPageable filtro) {
        Page<Pedido> pagina = pedidoRepository.findAll(PageRequest.of(
                filtro.getPage(), filtro.getSize(), filtro.getDirection(), filtro.getOrderBy()));
        return new ResponsePagedCommom<>(pagina.getContent(), pagina.getTotalElements(),
                pagina.getTotalPages(), pagina.getSize());
    }

    /** {@inheritDoc} */
    @Override
    @Transactional(readOnly = true)
    public String gerarRelatorioPedidos() {
        return "Total de pedidos: " + pedidoRepository.count();
    }
}

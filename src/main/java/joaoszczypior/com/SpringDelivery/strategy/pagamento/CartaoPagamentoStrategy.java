package joaoszczypior.com.SpringDelivery.strategy.pagamento;

import java.math.BigDecimal;
import org.springframework.stereotype.Component;

/**
 * Processa pagamentos via cartão.
 *
 * @author Joao Szczypior
 */
@Component("cartao")
public class CartaoPagamentoStrategy implements PagamentoStrategy {
    /** {@inheritDoc} */
    @Override
    public String processar(BigDecimal valor) {
        return "Pagamento de " + valor + " processado via cartÃ£o";
    }
}


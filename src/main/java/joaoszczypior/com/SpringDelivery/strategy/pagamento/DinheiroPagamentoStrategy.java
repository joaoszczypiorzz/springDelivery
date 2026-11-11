package joaoszczypior.com.SpringDelivery.strategy.pagamento;

import java.math.BigDecimal;
import org.springframework.stereotype.Component;

/**
 * Processa pagamentos em dinheiro.
 *
 * @author Joao Szczypior
 */
@Component("dinheiro")
public class DinheiroPagamentoStrategy implements PagamentoStrategy {
    /** {@inheritDoc} */
    @Override
    public String processar(BigDecimal valor) {
        return "Pagamento de " + valor + " processado em dinheiro";
    }
}


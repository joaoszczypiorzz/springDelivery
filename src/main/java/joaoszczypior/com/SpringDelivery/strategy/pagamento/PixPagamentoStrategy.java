package joaoszczypior.com.SpringDelivery.strategy.pagamento;

import java.math.BigDecimal;
import org.springframework.stereotype.Component;

/**
 * Processa pagamentos via PIX.
 *
 * @author Joao Szczypior
 */
@Component("pix")
public class PixPagamentoStrategy implements PagamentoStrategy {
    /** {@inheritDoc} */
    @Override
    public String processar(BigDecimal valor) {
        return "Pagamento de " + valor + " processado via PIX";
    }
}


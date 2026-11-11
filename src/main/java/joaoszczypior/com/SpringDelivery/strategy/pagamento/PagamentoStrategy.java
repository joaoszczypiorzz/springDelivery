package joaoszczypior.com.SpringDelivery.strategy.pagamento;

import java.math.BigDecimal;

/**
 * Estratégia extensível para processamento de pagamentos.
 *
 * @author João Szczypior
 */
public interface PagamentoStrategy {
    /** Processa o valor usando o mÃ©todo desta estratÃ©gia. */
    String processar(BigDecimal valor);
}


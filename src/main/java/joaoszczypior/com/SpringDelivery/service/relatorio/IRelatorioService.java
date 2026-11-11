package joaoszczypior.com.SpringDelivery.service.relatorio;

/**
 * Contrato de relatórios do sistema.
 *
 * @author Joao Szczypior
 */
public interface IRelatorioService {
    /** Gera o relatório resumido de pedidos. */
    String gerarRelatorioPedidos();
}


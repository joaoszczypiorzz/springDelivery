package joaoszczypior.com.SpringDelivery.service.notificacao;

/**
 * Abstrastração para envio de notificações.
 *
 * @author João Szczypior
 */
public interface INotificacaoService {
    /** Envia uma mensagem ao destinatário configurado. */
    void enviar(String mensagem);
}


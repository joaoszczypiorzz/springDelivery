package joaoszczypior.com.SpringDelivery.service.notificacao;

import org.springframework.stereotype.Service;

/**
 * Notificação via WhatsApp.
 *
 * @author Joao Szczypior
 */
@Service
public class WhatsAppNotificacaoService implements INotificacaoService {
    /** {@inheritDoc} */
    @Override
    public void enviar(String mensagem) {
        System.out.println("[WhatsApp] " + mensagem);
    }
}


package joaoszczypior.com.SpringDelivery.service.notificacao;

import org.springframework.stereotype.Service;

/**
 * Notificação via SMS.
 *
 * @author Joao Szczypior
 */
@Service
public class SmsNotificacaoService implements INotificacaoService {
    /** {@inheritDoc} */
    @Override
    public void enviar(String mensagem) {
        System.out.println("[SMS] " + mensagem);
    }
}


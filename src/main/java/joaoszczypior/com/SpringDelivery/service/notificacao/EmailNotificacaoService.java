package joaoszczypior.com.SpringDelivery.service.notificacao;

import org.springframework.stereotype.Service;

/**
 * Notificação via e-mail.
 *
 * @author Joao Szczypior
 */
@Service
public class EmailNotificacaoService implements INotificacaoService {
    /** {@inheritDoc} */
    @Override
    public void enviar(String mensagem) {
        System.out.println("[Email] " + mensagem);
    }
}


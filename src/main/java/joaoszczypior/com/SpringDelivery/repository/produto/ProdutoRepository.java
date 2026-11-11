package joaoszczypior.com.SpringDelivery.repository.produto;

import joaoszczypior.com.SpringDelivery.models.produto.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * RepositÃ³rio polimÃ³rfico de produtos.
 *
 * @author JoÃ£o Szczypior
 */
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}


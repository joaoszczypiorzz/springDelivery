package joaoszczypior.com.SpringDelivery.models.produto;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_produto")
public abstract class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_produto")
    private Long id;

    @Column(name = "nome_produto", nullable = false, length = 130)
    private String nome;


    @Column(name = "preco", nullable = false)
    private BigDecimal preco;

    @Column(name = "tipo_produto", nullable = false, length = 50)
    private String tipoProduto;
}


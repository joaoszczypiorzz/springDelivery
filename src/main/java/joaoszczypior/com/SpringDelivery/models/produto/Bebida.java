package joaoszczypior.com.SpringDelivery.models.produto;


import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@Entity
@DiscriminatorValue("Bebida")
public class Bebida extends Produto {

    @Column(name = "gelo")
    private Boolean gelo;

    public Bebida(Long id, String nome, BigDecimal preco, String tipoProduto, Boolean gelo) {
        super(id, nome, preco, tipoProduto);
        this.gelo = gelo;
    }
}


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
@DiscriminatorValue("Hamburger")
public class Hamburger extends Produto {

    @Column(name = "ponto_carne", length = 50)
    private String pontoCarne;

    public Hamburger(Long id, String nome, BigDecimal preco, String tipoProduto, String pontoCarne) {
        super(id, nome, preco, tipoProduto);
        this.pontoCarne = pontoCarne;
    }
}


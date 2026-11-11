package joaoszczypior.com.SpringDelivery.models.produto;


import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@DiscriminatorValue("Pizza")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Pizza extends Produto {

    @Column(name = "tamanho", length = 50)
    private String tamanho;

    public Pizza(Long id, String nome, BigDecimal preco, String tipoProduto, String tamanho) {
        super(id, nome, preco, tipoProduto);
        this.tamanho = tamanho;
    }
}


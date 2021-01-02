package cybersecu.api.article;

import cybersecu.api.stock.Stock;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
@Data
public class Article {

    @Id
    private int id;
    private String name;
    private int price;

    @OneToOne
    private Stock stock;
}

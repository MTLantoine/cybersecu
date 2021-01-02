package cybersecu.api.stock;

import cybersecu.api.article.Article;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
@Data
public class Stock {

    @Id
    private int id;
    private int quantity;
    @OneToOne
    @JoinColumn(name = "article_id")
    private Article article;
}

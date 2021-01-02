package cybersecu.api.commande;

import cybersecu.api.article.Article;
import cybersecu.api.article.ArticleRepository;
import cybersecu.api.stock.Stock;
import cybersecu.api.stock.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/commande")
public class CommandeController {

    @Autowired
    private CommandeRepository commandeRepository;

    @Autowired
    private StockRepository stockRepository;

    @Autowired
    private ArticleRepository articleRepository;

    @PostMapping("add-command/{articleId}/{quantity}")
    public ResponseEntity<Commande> addCommand(@PathVariable("articleId") int articleId, @PathVariable("quantity") int quantity) {
        Commande command = commandeRepository.findById(1).isPresent() ? commandeRepository.findById(1).get() : new Commande();
        Stock stock = stockRepository.findById(articleId).get();
        Article article = articleRepository.findById(articleId).get();
        int stockQuantity = stock.getQuantity();
        int quantityMax = quantity <= stockQuantity ? quantity : stockQuantity;
        command.setMap(articleId, quantityMax);
        stock.setQuantity(stock.getQuantity() - quantityMax);
        command.setTotalPrice(command.getTotalPrice() + (quantityMax * article.getPrice()));
        final Commande updatedCommande = commandeRepository.save(command);
        return ResponseEntity.ok(updatedCommande);
    }

}

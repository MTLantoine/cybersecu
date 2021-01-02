package cybersecu.api.stock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping(path="/stock")
public class StockController {

    @Autowired
    private StockRepository stockRepository;

    @GetMapping("find-by-quantity/{quantity}")
    public Set<Stock> getStockByQuantity(@PathVariable("quantity") int quantity) {
        return stockRepository.findByQuantity(quantity);
    }
}

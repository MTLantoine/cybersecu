package cybersecu.api.catalogue;

import cybersecu.api.stock.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Stream;

@RestController
@RequestMapping(path="/catalogue")
public class CatalogueController {

    @Autowired
    private CatalogueRepository catalogueRepository;

    @GetMapping
    public Stream<Stock> getNotEmptyStock() {
        return catalogueRepository.findById(1).get().getStock().stream().filter(stock -> stock.getQuantity() > 0);
    }
}

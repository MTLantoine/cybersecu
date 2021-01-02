package cybersecu.api.stock;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Set;

@RepositoryRestResource(path="stock")
public interface StockRepository extends JpaRepository<Stock, Integer> {

    Set<Stock> findByQuantity(int quantity);
}

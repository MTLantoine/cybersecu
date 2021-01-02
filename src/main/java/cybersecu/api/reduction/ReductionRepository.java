package cybersecu.api.reduction;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Set;

@RepositoryRestResource(path="reduction")
public interface ReductionRepository extends JpaRepository<Reduction, Integer> {

    Set<Reduction> findByPercent(int quantity);
}

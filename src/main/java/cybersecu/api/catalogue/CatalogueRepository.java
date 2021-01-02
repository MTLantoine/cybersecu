package cybersecu.api.catalogue;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path="catalogue")
public interface CatalogueRepository extends JpaRepository<Catalogue, Integer> {


}

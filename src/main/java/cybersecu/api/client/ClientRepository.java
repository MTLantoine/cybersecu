package cybersecu.api.client;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

@RepositoryRestResource(path="client")
public interface ClientRepository extends JpaRepository<Client, Integer> {

    Optional<Client> findByLogin(String login);
}

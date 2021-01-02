package cybersecu.api.article;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

@RepositoryRestResource(path="article")
public interface ArticleRepository extends JpaRepository<Article, Integer> {

    Optional<Article> findByName(String name);
}

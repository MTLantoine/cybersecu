package cybersecu.api.article;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(path="/article")
public class ArticleController {

    @Autowired
    private ArticleRepository articleRepository;

    // Récupère l'article par son nom
    @GetMapping("find-by-name/{name}")
    public Optional<Article> getArticleByName(@PathVariable("name") String name) {
        return articleRepository.findByName(name);
    }
}

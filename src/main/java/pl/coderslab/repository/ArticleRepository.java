package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.model.Article;
import pl.coderslab.model.Category;

import java.util.List;
import java.util.Optional;

public interface ArticleRepository extends JpaRepository<Article, Long> {

    Optional<Article> findById(Long id);

    List<Article> findByCategories(Category category);

    List<Article> findFirst5ByOrderByCreatedDesc();

}

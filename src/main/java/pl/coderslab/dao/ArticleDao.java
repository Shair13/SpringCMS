package pl.coderslab.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.model.Article;
import pl.coderslab.model.Author;
import pl.coderslab.model.Category;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class ArticleDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void saveArticle(Article article) {
        entityManager.persist(article);
    }

    public void deleteArticle(Article article) {
        entityManager.remove(entityManager.contains(article) ? article : entityManager.merge(article));
    }

    public void updateArticle(Article article) {
        entityManager.merge(article);
    }

    public Article findArticleById(Long id){
        return entityManager.find(Article.class, id);
    }

    public List<Article> findAllArticles() {
        return entityManager.createQuery("SELECT a FROM Article a", Article.class).getResultList();
    }

    public List<Article> findFiveLastArticles(){
        return entityManager.createQuery("SELECT a FROM Article a ORDER BY a.created DESC", Article.class)
                .setMaxResults(5)
                .getResultList();
    }

    public List<Article> findArticlesByCategory(Category category){
        return entityManager.createQuery("SELECT a FROM Article a JOIN a.categories WHERE :category MEMBER OF a.categories", Article.class)
                .setParameter("category", category)
                .getResultList();
    }
}

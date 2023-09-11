package pl.coderslab.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.model.Article;
import pl.coderslab.model.Author;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class ArticleDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void saveArticle(Article article){
        entityManager.persist(article);
    }

    public void deleteArticle(Article article){
        entityManager.remove(entityManager.contains(article) ? article : entityManager.merge(article));
    }

    public void updateArticle(Article article){
        entityManager.merge(article);
    }
}
